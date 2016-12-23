package com.pwms.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pwms.dao.RewardPunishRecordMapper;
import com.pwms.pojo.RewardPunishRecord;
import com.pwms.service.IRewardPunishRecordService;

@Service("rewardPunishRecordService")
public class RewardPunishRecordServiceImpl implements
		IRewardPunishRecordService {

	@Resource
	private RewardPunishRecordMapper rewardRecordDao;
	public RewardPunishRecordMapper getRewardRecordDao() {
		return rewardRecordDao;
	}

	public void setRewardRecordDao(RewardPunishRecordMapper rewardRecordDao) {
		this.rewardRecordDao = rewardRecordDao;
	}
	@Override
	public List<RewardPunishRecord> findAll() {
		// TODO Auto-generated method stub
		return rewardRecordDao.findAll();
	}

	@Override
	public RewardPunishRecord getRewardPunishRecord(int id) {
		// TODO Auto-generated method stub
		return rewardRecordDao.selectByPrimaryKey(id);
	}

	@Override
	public void update(RewardPunishRecord rewardPunish) {
		// TODO Auto-generated method stub
		rewardRecordDao.updateByPrimaryKeySelective(rewardPunish);
	}

	@Override
	public File exportXls(RewardPunishRecord rewardPunish) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void save(RewardPunishRecord rewardPunish) {
		// TODO Auto-generated method stub
		rewardRecordDao.insertSelective(rewardPunish);
	}
}
