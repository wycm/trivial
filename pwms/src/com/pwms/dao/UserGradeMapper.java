package com.pwms.dao;

import com.pwms.pojo.UserGrade;

public interface UserGradeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserGrade record);

    int insertSelective(UserGrade record);

    UserGrade selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserGrade record);

    int updateByPrimaryKey(UserGrade record);
}