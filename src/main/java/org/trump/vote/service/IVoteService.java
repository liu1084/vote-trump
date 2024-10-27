package org.trump.vote.service;

import org.trump.vote.entity.TwitterUser;
import org.trump.vote.entity.VoteRecord;

import java.util.Date;
import java.util.List;

public interface IVoteService {
    void cacheTwitterUser(TwitterUser twitterUser);

    TwitterUser getCachedTwitterUser(String userId);

    List<VoteRecord> getLatestRecord(int count);

    boolean isVoted(String userId);

    void vote(String userId, String proofImageUrl);

    long getTotalVotes();

    List<String> getVotedUsers();

    List<Long> getVoteCountsBetweenDays(Date start, Date end);

    List<Long> getVoteCountsByDays(Date start, Date end);

    String showHome();
}
