package org.trump.vote.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class VoteCountsByDays {
    private Date voteDay;
    private Integer voteCount;
}
