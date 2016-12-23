package com.pwms.dao;

import com.pwms.pojo.UserAnswerResult;

public interface UserAnswerResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAnswerResult record);

    int insertSelective(UserAnswerResult record);

    UserAnswerResult selectByPrimaryKey(Integer id);
    
    UserAnswerResult selectByQuestionIdAndUserId(Integer questionid, Integer userid);

    int updateByPrimaryKeySelective(UserAnswerResult record);

    int updateByPrimaryKey(UserAnswerResult record);
    
}