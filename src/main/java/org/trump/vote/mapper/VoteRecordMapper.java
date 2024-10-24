package org.trump.vote.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.trump.vote.entity.VoteRecord;
import org.trump.vote.entity.VoteRecordExample;

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
}