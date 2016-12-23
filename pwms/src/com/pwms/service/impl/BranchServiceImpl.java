package com.pwms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pwms.dao.BranchMapper;
import com.pwms.dao.BranchMemberMapper;
import com.pwms.dao.UserMapper;
import com.pwms.pojo.Branch;
import com.pwms.pojo.BranchMember;
import com.pwms.pojo.User;
import com.pwms.service.IBranchService;
@Service("branchService")
public class BranchServiceImpl implements IBranchService {
	@Resource
	private BranchMapper branchDao;
	@Resource
	private BranchMemberMapper branchMemberDao;
	@Resource
	private UserMapper userDao;
	public BranchMapper getBranchDao() {
		return branchDao;
	}

	public void setBranchDao(BranchMapper branchDao) {
		this.branchDao = branchDao;
	}

	public BranchMemberMapper getBranchMemberDao() {
		return branchMemberDao;
	}

	public void setBranchMemberDao(BranchMemberMapper branchMemberDao) {
		this.branchMemberDao = branchMemberDao;
	}

	public UserMapper getUserDao() {
		return userDao;
	}

	public void setUserDao(UserMapper userDao) {
		this.userDao = userDao;
	}

	@Override
	public Branch getBranch(Integer id) {
		// TODO Auto-generated method stub
		return this.branchDao.selectByPrimaryKey(id);
	}

	@Override
	public void save(Branch branch) {
		// TODO Auto-generated method stub
		this.branchDao.insertSelective(branch);
	}

	@Override
	public void update(Branch branch) {
		// TODO Auto-generated method stub
		this.branchDao.updateByPrimaryKeySelective(branch);
	}

	@Override
	public void addMember(Branch branch, User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BranchMember> getBranchMember(Branch branch) {
		// TODO Auto-generated method stub
		return branchMemberDao.selectByBranchId(branch);
	}

	@Override
	public boolean isMember(Branch branch, User user) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Branch getUserBranch(User user) {
		// TODO Auto-generated method stub
		BranchMember bm = branchMemberDao.selectByUserId(user);
		return bm.getBranch();
	}

	@Override
	public List<Branch> findAll() {
		// TODO Auto-generated method stub
		return branchDao.findAll();
	}

	@Override
	public List<Branch> findByName(String name) {
		// TODO Auto-generated method stub
		List<Branch> branchList = this.branchDao.findByName(name);
		return branchList;
	}

}
