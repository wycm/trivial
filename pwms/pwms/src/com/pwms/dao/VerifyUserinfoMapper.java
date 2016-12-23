package com.pwms.dao;

import java.util.List;

import com.pwms.pojo.VerifyUserinfo;

public interface VerifyUserinfoMapper {
	VerifyUserinfo selectByPrimaryKey(Integer id);
	List<VerifyUserinfo> selectByVerifyuserinfo(String identity, String name, String studentid);
	int deleteByPrimaryKey(Integer id);
	int insert(VerifyUserinfo record);
}
