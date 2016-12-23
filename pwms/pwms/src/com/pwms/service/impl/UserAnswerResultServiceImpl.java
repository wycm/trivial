package com.pwms.service.impl;

import javax.annotation.Resource;

import com.pwms.dao.UserAnswerResultMapper;
import com.pwms.pojo.ExamQuestion;
import com.pwms.pojo.User;
import com.pwms.pojo.UserAnswerResult;
import com.pwms.service.IUserAnswerResultService;

public class UserAnswerResultServiceImpl implements IUserAnswerResultService {
	@Resource
	private UserAnswerResultMapper userAnswerResultDao;
	@Override
	public UserAnswerResult getUserAnswerResult(Integer answerid) {
		// TODO Auto-generated method stub
		return this.userAnswerResultDao.selectByPrimaryKey(answerid);
	}

	@Override
	public void updateById(UserAnswerResult userAnswerResult) {
		// TODO Auto-generated method stub
		this.userAnswerResultDao.updateByPrimaryKeySelective(userAnswerResult);
	}

	@Override
	public void save(UserAnswerResult userAnswerResult) {
		// TODO Auto-generated method stub
		UserAnswerResult userAnswerResultTmp = userAnswerResultDao.selectByQuestionIdAndUserId(userAnswerResult.getQuestionId(), userAnswerResult.getUserId());
		if(userAnswerResultTmp == null){
		    this.userAnswerResultDao.insertSelective(userAnswerResult);
		}
		else{
			userAnswerResultTmp.copyUserAnswerResult(userAnswerResult);
			this.userAnswerResultDao.updateByPrimaryKeySelective(userAnswerResultTmp);
		}
	}

	@Override
	public boolean isRight(UserAnswerResult userAnswerResult, ExamQuestion question) {
		// TODO Auto-generated method stub
		if(question.getAnswer().equals(userAnswerResult.getUserAnswer()))
		{
			return true;
		}
		return false;
	}

	@Override
	public void answerQuestion(User user, UserAnswerResult userAnswerResult) {
		// TODO Auto-generated method stub
		userAnswerResult.setUserId(user.getId());
		UserAnswerResult userAnswerResultTmp = userAnswerResultDao.selectByQuestionIdAndUserId(userAnswerResult.getQuestionId(), user.getId());
		if(userAnswerResultTmp!=null){
			userAnswerResultTmp.copyUserAnswerResult(userAnswerResult);
			userAnswerResultDao.updateByPrimaryKeySelective(userAnswerResultTmp);
		}
		else{
		    userAnswerResultDao.insertSelective(userAnswerResult);
		}
	}

}
