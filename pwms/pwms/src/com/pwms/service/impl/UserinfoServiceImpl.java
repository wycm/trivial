package com.pwms.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pwms.dao.UserinfoMapper;
import com.pwms.dao.UserinfoModifyMapper;
import com.pwms.pojo.User;
import com.pwms.pojo.Userinfo;
import com.pwms.pojo.UserinfoModify;
import com.pwms.service.IUserinfoService;

@Service("userinfoService")
public class UserinfoServiceImpl implements IUserinfoService {

	@Resource
	private UserinfoMapper userinfoDao;
	@Resource
	private UserinfoModifyMapper userinfoModifyDao;
	public UserinfoModifyMapper getUserinfoModifyDao() {
		return userinfoModifyDao;
	}

	public void setUserinfoModifyDao(UserinfoModifyMapper userinfoModifyDao) {
		this.userinfoModifyDao = userinfoModifyDao;
	}

	public UserinfoMapper getUserinfoDao() {
		return userinfoDao;
	}

	public void setUserinfoDao(UserinfoMapper userinfoDao) {
		this.userinfoDao = userinfoDao;
	}

	@Override
	public Userinfo getUserinfo(int StuOrJobid) {
		// TODO Auto-generated method stub
		return this.userinfoDao.selectByStuOrJobId(StuOrJobid);
	}

	@Override
	public void updateUserinfo(Userinfo userinfo) {
		// TODO Auto-generated method stub
		userinfoDao.updateByPrimaryKeySelective(userinfo);
	}

	@Override
	public void save(Userinfo userinfo) {
		// TODO Auto-generated method stub
		userinfoDao.insertSelective(userinfo);
	}

	@Override
	public Userinfo getUserinfoByUserid(int userId) {
		// TODO Auto-generated method stub
		return this.userinfoDao.selectByUserid(userId);
	}
	@Override
	public List<UserinfoModify> getModifyByUserFlag(User user, int flag) {
		List<UserinfoModify> um = new ArrayList<UserinfoModify>();
		um = this.userinfoModifyDao.selectByLeaderFLag(flag, user.getId());
		System.out.println(um.size());
		return um;
	}
	@Override
	public List<UserinfoModify> getModifyNotEffect(User user) {
		// TODO Auto-generated method stub
		if(user.haveBranchPermission()){
			return this.userinfoModifyDao.selectByLeaderFLag(0, user.getId());
		}
		else if(user.haveHeadPermission()){
			return this.userinfoModifyDao.selectByFlag(0);
		}
		return null;
	}

	@Override
	public void dealModify(UserinfoModify modify, int flag, String msg) {
		// TODO Auto-generated method stub
//		UserinfoModify userinfoModify this.userinfoModifyDao.selectByPrimaryKey(modifyid);
		modify.setAuditingFlag(flag);
		modify.setAuditingMsg(msg);
		userinfoModifyDao.updateByPrimaryKeySelective(modify);
	}

	@Override
	public void dealPass(UserinfoModify modify) {
		// TODO Auto-generated method stub
		this.dealModify(modify, 1, null);
	}

	@Override
	public void dealNotPass(UserinfoModify modify, String msg) {
		// TODO Auto-generated method stub
		this.dealModify(modify, 2, msg);
	}

	@Override
	public UserinfoModify getUserinfoModifyByid(int id) {
		// TODO Auto-generated method stub
		return userinfoModifyDao.selectByPrimaryKey(id);
	}
   
}
