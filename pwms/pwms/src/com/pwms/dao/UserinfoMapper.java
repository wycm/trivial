package com.pwms.dao;

import com.pwms.pojo.Userinfo;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer id);
    
    Userinfo selectByUserid(Integer userId);
    
    Userinfo selectByStuOrJobId(Integer StuOrJobId);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
}