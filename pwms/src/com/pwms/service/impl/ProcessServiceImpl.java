package com.pwms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pwms.dao.ProcessMapper;
import com.pwms.dao.ProcessRecordMapper;
import com.pwms.pojo.Process;
import com.pwms.pojo.ProcessRecord;
import com.pwms.pojo.User;
import com.pwms.service.IProcessService;
@Service("processService")
public class ProcessServiceImpl implements IProcessService {
	@Resource
	private ProcessMapper processDao;
	@Resource
	private ProcessRecordMapper pRecordDao;
	public ProcessMapper getProcessDao() {
		return processDao;
	}

	public void setProcessDao(ProcessMapper processDao) {
		this.processDao = processDao;
	}

	public ProcessRecordMapper getpRecordDao() {
		return pRecordDao;
	}

	public void setpRecordDao(ProcessRecordMapper pRecordDao) {
		this.pRecordDao = pRecordDao;
	}

	@Override
	public Process getProcess(Integer id) {
		// TODO Auto-generated method stub
		return this.processDao.selectByPrimaryKey(id);
	}

	@Override
	public void save(Process process) {
		// TODO Auto-generated method stub
		this.processDao.insertSelective(process);
	}

	@Override
	public void updateById(Process process) {
		// TODO Auto-generated method stub
		this.processDao.updateByPrimaryKeySelective(process);
	}

	@Override
	public void addProcessRecord(ProcessRecord precord, User user) {
		// TODO Auto-generated method stub
		precord.setUserId(user.getId());
		if(precord.getId()==null){
			this.pRecordDao.insertSelective(precord);
		}
		else{
			this.pRecordDao.updateByPrimaryKeySelective(precord);
		}
	}

	@Override
	public int getLastProcessNum(User user) {
		// TODO Auto-generated method stub
		return this.pRecordDao.selectLastByUser(user);
	}

	@Override
	public List<ProcessRecord> getUserProcessRecord(User user) {
		// TODO Auto-generated method stub
		return this.pRecordDao.selectByUser(user);
	}

	@Override
	public boolean isComplete(User user, Process process) {
		// TODO Auto-generated method stub
		ProcessRecord pRecord = pRecordDao.selectByProcessUser(process.getId(), user.getId());
		if(pRecord==null){
		    return false;
		}
		return true;
	}

	@Override
	public List<Process> getProcessList() {
		// TODO Auto-generated method stub
		return this.processDao.selectByNum();
	}

}
