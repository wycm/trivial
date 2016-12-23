package com.pwms.pojo;

public class UserAnswerResult {
    private Integer id;

    private Integer userId;

    private Integer questionId;

    private String userAnswer;

    private Integer rightFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer == null ? null : userAnswer.trim();
    }

    public Integer getRightFlag() {
        return rightFlag;
    }

    public void setRightFlag(Integer rightFlag) {
        this.rightFlag = rightFlag;
    }
    public void copyUserAnswerResult(UserAnswerResult userAnswerResult){
    	this.questionId = userAnswerResult.getQuestionId();
    	this.rightFlag = userAnswerResult.getRightFlag();
    	this.userAnswer = userAnswerResult.getUserAnswer();
    	this.userId = userAnswerResult.getUserId();
    }
}