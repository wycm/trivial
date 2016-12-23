package com.pwms.service;

import java.util.List;

import com.pwms.pojo.JoinOutRecord;

public interface IJoinOutRecordService {
	public List<JoinOutRecord> findAll();
	//保存对象
	public void save(JoinOutRecord joinrecord);
	//更新对象
	public void update(JoinOutRecord joinrecord);
	//获取对象
	public JoinOutRecord getJoinOutRecord(int id);
	
}
