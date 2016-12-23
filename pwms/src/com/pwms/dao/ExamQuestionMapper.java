package com.pwms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pwms.pojo.ExamQuestion;

public interface ExamQuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamQuestion record);

    int insertSelective(ExamQuestion record);

    ExamQuestion selectByPrimaryKey(Integer id);
    
    List<ExamQuestion> selectByExamId(Integer examid);
    /**
     * 根据考试id随机获取count条考试题
     * @param count 要查询的数量
     * @param examId 考试id
     * @return count条考试题目
     */
    List<ExamQuestion> randomSelectByExamId(@Param("count")Integer count,@Param("examid")Integer examid);
    /**
     * 获取全部考试题目
     * @return
     */
    List<ExamQuestion> selectAll();

    int updateByPrimaryKeySelective(ExamQuestion record);

    int updateByPrimaryKeyWithBLOBs(ExamQuestion record);

    int updateByPrimaryKey(ExamQuestion record);
    
    
}