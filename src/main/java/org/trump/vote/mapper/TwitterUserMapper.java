package org.trump.vote.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.trump.vote.entity.TwitterUser;


@Mapper
@Repository
public interface TwitterUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TwitterUser record);

    int insertSelective(TwitterUser record);

    TwitterUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TwitterUser record);

    int updateByPrimaryKey(TwitterUser record);
}