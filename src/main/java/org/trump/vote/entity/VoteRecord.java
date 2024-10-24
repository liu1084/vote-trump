package org.trump.vote.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class VoteRecord implements Serializable {
    private Long id;

    private String twitterUserId;

    private Date voteDate;

    private String proofImageUrl;

    private Date createDatetime;

    private Date updateDatetime;

    private static final long serialVersionUID = 1L;
}