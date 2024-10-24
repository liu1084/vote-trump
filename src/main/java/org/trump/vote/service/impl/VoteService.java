package org.trump.vote.service.impl;

import com.cinaval.cache.redis.service.ICacheHandler;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trump.vote.entity.TwitterUser;
import org.trump.vote.entity.VoteRecord;
import org.trump.vote.mapper.VoteRecordMapper;
import org.trump.vote.service.IVoteService;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.trump.vote.constant.VoteConstant.CACHE_SEPARATOR;
import static org.trump.vote.constant.VoteConstant.USER_CACHE_PREFIX;

@Service
public class VoteService implements IVoteService {

    @Autowired
    private ICacheHandler cacheHandler;

    @Autowired
    private VoteRecordMapper voteRecordMapper;

    @Override
    public void cacheTwitterUser(TwitterUser twitterUser) {
        String userId = twitterUser.getUserId();
        String userKey = USER_CACHE_PREFIX + CACHE_SEPARATOR + userId;
        if (cacheHandler.isExist(userKey)) {
            return;
        }
        cacheHandler.set(userKey, new Gson().toJson(twitterUser));
    }

    @Override
    public TwitterUser getTwitterUser(String userId) {
        String userKey = USER_CACHE_PREFIX + CACHE_SEPARATOR + userId;
        if (!cacheHandler.isExist(userKey)) {
            throw new RuntimeException("User not found: " + userId);
        }
        return new Gson().fromJson(cacheHandler.get(userKey), TwitterUser.class);
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
    public long getTotalVotes() {
        return 0;
    }

    @Override
    public List<String> getVotedUserIds() {
        return Collections.emptyList();
    }

    @Override
    public List<Long> getVoteCountsBetweenDays(Date start, Date end) {
        return Collections.emptyList();
    }

    @Override
    public List<Long> getVoteCountsByDays(Date start, Date end) {
        return Collections.emptyList();
    }

    @Override
    public String showHome() {
        return "";
    }
}
