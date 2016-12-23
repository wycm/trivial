package com.pwms.dao;

import com.pwms.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);
    User selectByPrimaryKey(Integer id);
    User selectByLoginfo(String loginf);
    User selectByNameOrFid(String loginfo, String password);
    int updateByUserid(User user);
    int insert(User user);
    int insertSelective(User user);
    User selectdByStuid(String stuid);
}