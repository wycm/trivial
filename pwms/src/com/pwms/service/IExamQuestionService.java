package com.pwms.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.pwms.pojo.ExamQuestion;
import com.pwms.pojo.User;

public interface IExamQuestionService {
	/**按照examid获取question列表
	 * @param examid
	 * @return
	 */
	 public List<ExamQuestion> getQuestionsByExamId(int examid);
	 /**
	  * 获取全部考试题目
	  * @return
	  */
	 public List<ExamQuestion> getAllQuestionsList();
	 /**
	  * 保存实体
	  * @param examQuestion
	  */
	 public void saveQuestion(ExamQuestion examQuestion);
	 /**
	  * 根据id获取对象
	  * @param examid
	  * @return
	  */
	 public ExamQuestion getExamQuestionById(int id);
	 /**
	  * 根据id删除题目
	  * @param id
	  */
	 public void deleteQuestionById(Integer id);
	 /**
	  * 根据答案返回本题的成绩
	  * @param questionId
	  * @param question
	  * @return
	  */
	 public int getQuestionGrade(int questionId, String question);
	 /**
	  * 根据Map计算出该考试的成绩
	  * @param examId
	  * @param answer
	  * @return
	  */
	 public int calcExamGrade(Map<Integer , String> answers );
	 /**
	  * 保存考试的记录
	  * @param examId
	  * @param score
	  * @param user
	  */
	 public void save2Record(int examId, int score, User user);
	 /**
	  * 计算成绩并保存考试记录
	  * @param examId
	  * @param answers
	  * @param user
	  */
	 public int calcGrade2Record(int examId, Map<Integer , String> answers, User user);
	 /**
	  * 导入xls
	  * @param file
	  * @param examid
	  * @return
	  */
	 public boolean xls2ExamQuestion(File file, int examid);
	 /**
	  * 根据id更新考试题目
	  * @param record
	  * @return
	  */
	 int updateByPrimaryKey(ExamQuestion record);
	 
	 /**
	     * 根据考试id随机获取count条考试题
	     * @param count 要查询的数量
	     * @param examId 考试id
	     * @return count条考试题目
	     */
	    List<ExamQuestion> randomSelectByExamId(Integer count,Integer examId);
	 
	 
}
