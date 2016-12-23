package com.pwms.service;

import java.util.List;

import com.pwms.pojo.User;
import com.pwms.pojo.Userinfo;
import com.pwms.pojo.UserinfoModify;

public interface IUserinfoService {
	//获取Userinfo
	public Userinfo getUserinfo(int StuOrJobid);
	/**
	 * 通过userid得到userinfo对象
	 * @param userId 
	 * @return Userinfo对象
	 */
	public Userinfo getUserinfoByUserid(int userId);
	/**
	 * 通过id查询修改记录
	 * @param id
	 * @return
	 */
	public UserinfoModify getUserinfoModifyByid(int id);
	//修改信息
	public void updateUserinfo(Userinfo userinfo);
	//保存
	public void save(Userinfo userinfo);
	//再增加一些导入导出之类的功能
	/**
	 * 获取本支部内未审核的信息修改
	 * @param user
	 * @return
	 */
	public List<UserinfoModify> getModifyNotEffect(User user);
	/**
	 * 获取本支部，不同标志的信息
	 * @param user
	 * @param flag
	 * @return
	 */
	public List<UserinfoModify> getModifyByUserFlag(User user, int flag);
	/**
	 * 处理信息修改
	 * @param modify,来自数据库查询的对象，不需要修改
	 * @param flag，标志 0：未审核 1： 审核通过 2：未通过
	 * @param msg，
	 */
	public void dealModify(UserinfoModify modify, int flag, String msg);
	/**
	 * 通过信息修改
	 * @param modify
	 */
	public void dealPass(UserinfoModify modify);
	/**
	 * 不通过信息修改
	 * @param modify
	 */
	public void dealNotPass(UserinfoModify modify, String msg);
}
