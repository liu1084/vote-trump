package org.trump.vote.service;

import org.trump.vote.entity.TwitterUser;
import org.trump.vote.entity.VoteCountsBy30Minutes;
import org.trump.vote.entity.VoteCountsByDays;
import org.trump.vote.entity.VoteRecord;

import java.util.List;
import java.util.Optional;

public interface IVoteService {
    void cacheTwitterUser(TwitterUser twitterUser);

    TwitterUser getCachedTwitterUser(String userId);

    List<VoteRecord> getLatestRecord(int count);

    boolean isVoted(String userId);

    void vote(String userId, String proofImageUrl);

    Optional<Long> getTotalVotes();

    List<TwitterUser> getVotedUsers(int min);

    List<VoteCountsByDays> getVoteCountsByMonth();

    List<VoteCountsBy30Minutes> trending();
}
