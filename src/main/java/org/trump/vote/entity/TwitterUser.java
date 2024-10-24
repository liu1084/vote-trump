package org.trump.vote.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TwitterUser implements Serializable {
    private Long id;

    private String userId;

    private String screenName;

    private String name;

    private String profileImageUrl;

    private Date createDatetime;

    private Date updateDatetime;

    private static final long serialVersionUID = 1L;

}