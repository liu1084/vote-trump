package org.trump.vote.service;

import org.trump.vote.entity.TwitterUser;

import java.util.Date;
import java.util.List;

public interface IVoteService {
    void cacheTwitterUser(TwitterUser twitterUser);

    TwitterUser getTwitterUser(String userId);

    boolean isVoted(String userId);

    void vote(String userId, String proofImageUrl);

    long getTotalVotes();

    List<String> getVotedUserIds();

    List<Long> getVoteCountsBetweenDays(Date start, Date end);

    List<Long> getVoteCountsByDays(Date start, Date end);

    String showHome();
}
