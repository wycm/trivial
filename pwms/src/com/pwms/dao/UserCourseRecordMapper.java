package com.pwms.dao;

import com.pwms.pojo.UserCourseRecord;

public interface UserCourseRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCourseRecord record);

    int insertSelective(UserCourseRecord record);

    UserCourseRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCourseRecord record);

    int updateByPrimaryKey(UserCourseRecord record);
}