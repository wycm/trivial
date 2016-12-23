package com.pwms.service;

import java.util.List;

import com.pwms.pojo.Branch;
import com.pwms.pojo.BranchMember;
//import com.pwms.pojo.NoticeTheroyContruction;
import com.pwms.pojo.User;

public interface IBranchService {
	//获取支部对象
	public Branch getBranch(Integer id);
	//保存对象
	public void save(Branch branch);
	//更新对象
	public void update(Branch branch);
	//增加成员
	public void addMember(Branch branch, User user);
    //发布支部公告
//	public void publishNotice(Branch branch, NoticeTheroyContruction notice);
	//获取支部成员
	public List<BranchMember> getBranchMember(Branch branch);
	//检查是否是支部成员
	public boolean isMember(Branch branch, User user);
	//获取用户支部
	public Branch getUserBranch(User user);

	public List<Branch> findAll();
	
	public List<Branch> findByName(String name);
}
