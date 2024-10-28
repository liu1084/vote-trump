package org.trump.vote.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.trump.vote.entity.*;

import java.util.List;

@Mapper
@Repository
public interface VoteRecordMapper {
    long countByExample(VoteRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VoteRecord record);

    int insertSelective(VoteRecord record);

    VoteRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VoteRecord record);

    int updateByPrimaryKey(VoteRecord record);

    int countByUserId(String userId);

    List<VoteRecord> getLatestRecord(@Param("count") Integer count);

    long totalCount();

    List<VoteCountsByDays> voteCountsByMonth();

    List<VoteCountsBy30Minutes> voteCountsBy30Minutes();

    List<TwitterUser> votedUsers(int min);
}