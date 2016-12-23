package com.pwms.dao;

import java.util.List;

import com.pwms.pojo.TheoryCourse;

public interface TheoryCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TheoryCourse record);

    int insertSelective(TheoryCourse record);

    TheoryCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TheoryCourse record);

    int updateByPrimaryKeyWithBLOBs(TheoryCourse record);

    int updateByPrimaryKey(TheoryCourse record);
    /**
     * 获取全部理论课程
     * @return
     */
    List<TheoryCourse> selectAll();
    /**
     * 获取最新top5理论课程
     * @return
     */
    List<TheoryCourse> selectTopCourse();
}