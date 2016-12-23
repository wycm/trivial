package com.pwms.dao;

import java.util.List;

import com.pwms.pojo.ExamRecord;

public interface ExamRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamRecord record);

    int insertSelective(ExamRecord record);

    ExamRecord selectByPrimaryKey(Integer id);
    
    List<ExamRecord> selectByUserid(Integer userId);
    /**
     * 通过用户id和考试id来获取到以时间降序排列的List
     * @param examId
     * @param userId
     * @return
     */
    List<ExamRecord> selectByExamidUserid(Integer examId, Integer userId);
    /**
     * 获取所有考试记录列表
     * @return
     */
    List<ExamRecord> selectAll();
    
    int updateByPrimaryKeySelective(ExamRecord record);

    int updateByPrimaryKey(ExamRecord record);
}