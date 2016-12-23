package com.pwms.dao;

import java.util.List;

import com.pwms.pojo.Exam;

public interface ExamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Exam record);

    int insertSelective(Exam record);

    Exam selectByPrimaryKey(Integer id);
    
    List<Exam> selectDesc();

    List<Exam> getExamListByUserId(Integer userId);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);
    
    
}