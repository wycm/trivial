package com.pwms.dao;

import java.util.List;

import com.pwms.pojo.RewardPunishRecord;

public interface RewardPunishRecordMapper {

	List<RewardPunishRecord> findAll();
	
    int deleteByPrimaryKey(Integer id);

    int insert(RewardPunishRecord record);

    int insertSelective(RewardPunishRecord record);

    RewardPunishRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RewardPunishRecord record);

    int updateByPrimaryKey(RewardPunishRecord record);
}