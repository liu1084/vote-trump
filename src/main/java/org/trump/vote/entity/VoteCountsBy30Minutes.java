package org.trump.vote.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class VoteCountsBy30Minutes {
    private Date voteDay;
    private Date voteHalfHour;
    private Integer voteCount;
}
