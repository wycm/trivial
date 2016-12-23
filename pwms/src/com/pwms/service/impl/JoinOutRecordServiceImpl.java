package com.pwms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pwms.dao.JoinOutRecordMapper;
import com.pwms.pojo.JoinOutRecord;
import com.pwms.service.IJoinOutRecordService;

@Service("JoinOutRecordService")
public class JoinOutRecordServiceImpl implements IJoinOutRecordService {

	@Resource
	private JoinOutRecordMapper joinOutRecordDao;
	public JoinOutRecordMapper getJoinOutRecordDao() {
		return joinOutRecordDao;
	}

	public void setJoinOutRecordDao(JoinOutRecordMapper joinOutRecordDao) {
		this.joinOutRecordDao = joinOutRecordDao;
	}

	@Override
	public void save(JoinOutRecord joinrecord) {
		// TODO Auto-generated method stub
		this.joinOutRecordDao.insertSelective(joinrecord);
	}

	@Override
	public void update(JoinOutRecord joinrecord) {
		// TODO Auto-generated method stub
		this.joinOutRecordDao.updateByPrimaryKeySelective(joinrecord);
	}

	@Override
	public JoinOutRecord getJoinOutRecord(int id) {
		// TODO Auto-generated method stub
		return this.joinOutRecordDao.selectByPrimaryKey(id);
	}

	@Override
	public List<JoinOutRecord> findAll() {
		// TODO Auto-generated method stub
		return this.joinOutRecordDao.findAll();
	}

}
