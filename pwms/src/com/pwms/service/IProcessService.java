package com.pwms.service;

import java.util.List;

import com.pwms.pojo.ProcessRecord;
import com.pwms.pojo.User;
import com.pwms.pojo.Process;

public interface IProcessService {
	//获取进度内容
	public Process getProcess(Integer id);
	//保存进度内容
	public void save(Process process);
	//更新进度内容
	public void updateById(Process process);
	//添加用户完成进度的记录  总是保存最新的记录
	public void addProcessRecord(ProcessRecord precord, User user);
	//获取用户最新记录号
	public int getLastProcessNum(User user);
	//获取用户所有的记录
	public List<ProcessRecord> getUserProcessRecord(User user);
	//查看是否完成某个进度
	public boolean isComplete(User user, Process process);
	/**
	 * 获取所有的进度，按编号排列
	 * @return
	 */
	public List<Process> getProcessList();
}
