package com.pwms.service;

import java.util.List;

import com.pwms.pojo.Exam;
import com.pwms.pojo.ExamRecord;
import com.pwms.pojo.User;
/**
 * Exam和ExamRecord相操作都在该接口
 * @author Administrator
 *
 */
public interface IExamService {
	//获取对象
	public Exam getExam(Integer id);
	
	public ExamRecord getExamRecord(Integer id);
	//保存考试
	public void save(Exam exam);
	//更新考试
	public void updateById(Exam exam);
	/**
	 * 修改考试成绩记录
	 * @param er
	 */
	public void updateExamRecord(ExamRecord er);
	
	public void deleteExamById(Integer id);
	
	public void deleteExamRecordById(Integer id);
	/**
	 * 查看考试的最新成绩  如果返回值是-1  则没有考试的记录
	 * @param user
	 * @param exam
	 * @return
	 */
	public int getGrade(User user, Exam exam);
	/**
	 * 增加一个新的考试完成的记录
	 * @param examRecord
	 */
	public void addRecord(ExamRecord examRecord);
	/**
	 * 获取用户的所有的考试记录列表
	 * @param user
	 * @return
	 */
	public List<ExamRecord> getRecord(User user);
	/**
	 * 获取用户某个考试的记录
	 * @param user
	 * @param exam
	 * @return
	 */
	public List<ExamRecord> getRecordByUserExam(User user, Exam exam);
	/**
	 * 根据用户id获取该用户所有成绩记录
	 * @param id
	 * @return
	 */
	public List<ExamRecord> getRecordByUserId(Integer id);
	/**
	 * 获取所有考试记录
	 * @param user
	 * @param exam
	 * @return
	 */
	public List<ExamRecord> selectAll();
	/**
	 * 获取所有考试列表
	 * @return
	 */
	public List<Exam> getExamDesc();
	/**
	 * 根据用户id获取该用户还未参加的考试列表
	 * @param userId
	 * @return
	 */
	public List<Exam> getExamListByUserId(Integer userId);
	//计算考试的成绩
//	public int getGrade();
	//返回具体某个题的题的成绩
//	public int getQuestionGrade(ExamQuestion question , String question);
}
