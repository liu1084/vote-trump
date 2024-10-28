package org.trump.vote.service.impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.trump.vote.entity.TwitterUser;
import org.trump.vote.entity.VoteCountsBy30Minutes;
import org.trump.vote.entity.VoteCountsByDays;
import org.trump.vote.entity.VoteRecord;
import org.trump.vote.mapper.VoteRecordMapper;
import org.trump.vote.service.IVoteService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.trump.vote.constant.VoteConstant.CACHE_SEPARATOR;
import static org.trump.vote.constant.VoteConstant.USER_CACHE_PREFIX;

@Service
public class VoteServiceImpl implements IVoteService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private VoteRecordMapper voteRecordMapper;

    @Override
    public void cacheTwitterUser(TwitterUser twitterUser) {
        String userId = twitterUser.getUserId();
        String userKey = USER_CACHE_PREFIX + CACHE_SEPARATOR + userId;
        if (Boolean.TRUE.equals(redisTemplate.hasKey(userKey))) {
            return;
        }
        redisTemplate.opsForValue().set(userKey, new Gson().toJson(twitterUser));
    }

    @Override
    public TwitterUser getCachedTwitterUser(String userId) {
        String userKey = USER_CACHE_PREFIX + CACHE_SEPARATOR + userId;
        if (Boolean.FALSE.equals(redisTemplate.hasKey(userKey))) {
            throw new RuntimeException("User not found: " + userId);
        }
        return new Gson().fromJson(redisTemplate.opsForValue().get(userKey), TwitterUser.class);
    }

    @Override
    public List<VoteRecord> getLatestRecord(int count) {
        return voteRecordMapper.getLatestRecord(count);
    }

    @Override
    public boolean isVoted(String userId) {
        int result = voteRecordMapper.countByUserId(userId);
        return result > 0;
    }

    @Override
    public void vote(String userId, String proofImageUrl) {
        VoteRecord record = new VoteRecord();
        record.setVoteDate(new Date());
        record.setTwitterUserId(userId);
        if (proofImageUrl != null) {
            record.setProofImageUrl(proofImageUrl);
        }

        voteRecordMapper.insertSelective(record);
    }

    @Override
    public Optional<Long> getTotalVotes() {
        long total = voteRecordMapper.totalCount();
        return Optional.of(total);
    }

    @Override
    public List<TwitterUser> getVotedUsers(int min) {
        return voteRecordMapper.votedUsers(min);
    }


    @Override
    public List<VoteCountsByDays> getVoteCountsByMonth() {
        return voteRecordMapper.voteCountsByMonth();
    }

    @Override
    public List<VoteCountsBy30Minutes> trending() {
        return voteRecordMapper.voteCountsBy30Minutes();
    }
}
