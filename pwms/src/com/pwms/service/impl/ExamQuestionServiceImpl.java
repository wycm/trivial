package com.pwms.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.springframework.stereotype.Service;

import com.pwms.dao.ExamMapper;
import com.pwms.dao.ExamQuestionMapper;
import com.pwms.dao.ExamRecordMapper;
import com.pwms.pojo.Exam;
import com.pwms.pojo.ExamQuestion;
import com.pwms.pojo.ExamRecord;
import com.pwms.pojo.User;
import com.pwms.service.IExamQuestionService;
import com.pwms.tools.UtilXls;

@Service("examQuestionService")
public class ExamQuestionServiceImpl implements IExamQuestionService {
	@Resource
	private ExamQuestionMapper examQuestionDao;
	@Resource
	private ExamMapper examDao;
	@Resource
	private ExamRecordMapper examRecordDao;

	public ExamQuestionMapper getExamQuestionDao() {
		return examQuestionDao;
	}

	public void setExamQuestionDao(ExamQuestionMapper examQuestionDao) {
		this.examQuestionDao = examQuestionDao;
	}

	public ExamMapper getExamDao() {
		return examDao;
	}

	public void setExamDao(ExamMapper examDao) {
		this.examDao = examDao;
	}

	public ExamRecordMapper getExamRecordDao() {
		return examRecordDao;
	}

	public void setExamRecordDao(ExamRecordMapper examRecordDao) {
		this.examRecordDao = examRecordDao;
	}

	@Override
	public List<ExamQuestion> getQuestionsByExamId(int examid) {
		// TODO Auto-generated method stub
		return this.examQuestionDao.selectByExamId(examid);
	}

	@Override
	public void saveQuestion(ExamQuestion examQuestion) {
		// TODO Auto-generated method stub
		this.examQuestionDao.insertSelective(examQuestion);
	}

	@Override
	public int getQuestionGrade(int questionId, String anwser) {
		// TODO Auto-generated method stub
		ExamQuestion questionObj = this.examQuestionDao
				.selectByPrimaryKey(questionId);
		Exam exam = this.examDao.selectByPrimaryKey(questionObj.getExamId());
		if (exam == null) {
			return 0;
		}
		if (questionObj.getAnswer().equals(anwser)) {
			return exam.getSingleScore();
		} else {
			return 0;
		}
	}

	@Override
	public int calcExamGrade(Map<Integer, String> answers) {
		// TODO Auto-generated method stub
		int sumScore = 0;
		// List<ExamQuestion> questionList =
		// this.examQuestionDao.selectByExamId(examId);
		for (Map.Entry<Integer, String> entry : answers.entrySet()) {
			int score = getQuestionGrade(entry.getKey(), entry.getValue());
			sumScore = sumScore + score;
		}
		return sumScore;
	}

	@Override
	public ExamQuestion getExamQuestionById(int id) {
		// TODO Auto-generated method stub
		return this.examQuestionDao.selectByPrimaryKey(id);
	}

	@Override
	public void save2Record(int examId, int score, User user) {
		// TODO Auto-generated method stub
		Date date = new Date();
		ExamRecord record = new ExamRecord();
		record.setExamId(examId);
		record.setScore(score);
		record.setUserId(user.getId());
		record.setTime(date);
		examRecordDao.insertSelective(record);
	}

	@Override
	public int calcGrade2Record(int examId, Map<Integer, String> answers,
			User user) {
		// TODO Auto-generated method stub
		int score = calcExamGrade(answers);
		save2Record(examId, score, user);
		return score;
	}

	@Override
	public boolean xls2ExamQuestion(File file, int examid) {
		// TODO Auto-generated method stub
		ExamQuestion[] examQuestionArr = null;
		if(file==null){
			return false;
		}
		Workbook workbook = null;
		try {
			workbook = Workbook.getWorkbook(file);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		Map<String, String[]> map = UtilXls.xlsToMap(workbook);
		if(map==null){
			return false;
		}
		String[] str = (String[]) map.values().toArray()[0];
		examQuestionArr = new ExamQuestion[str.length];
		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			String[] DataArr = entry.getValue();
			if (entry.getKey().equals("A")) {
				for(int i=0; i<DataArr.length&&i<examQuestionArr.length; i++){
					examQuestionArr[i].setOptionA(DataArr[i]);
				}
			}
			else if (entry.getKey().equals("B")) {
				for(int i=0; i<DataArr.length&&i<examQuestionArr.length; i++){
					examQuestionArr[i].setOptionB(DataArr[i]);
				}
			}
			else if (entry.getKey().equals("C")) {
				for(int i=0; i<DataArr.length&&i<examQuestionArr.length; i++){
					examQuestionArr[i].setOptionC(DataArr[i]);
				}
			}
			else if (entry.getKey().equals("D")) {
				for(int i=0; i<DataArr.length&&i<examQuestionArr.length; i++){
					examQuestionArr[i].setOptionD(DataArr[i]);
				}
			}
			else if (entry.getKey().equals("正确答案")) {
				for(int i=0; i<DataArr.length&&i<examQuestionArr.length; i++){
					examQuestionArr[i].setAnswer(DataArr[i]);
				}
			}
			else if (entry.getKey().equals("题目")) {
				for(int i=0; i<DataArr.length&&i<examQuestionArr.length; i++){
					examQuestionArr[i].setQuestion(DataArr[i]);
				}
			}
		}
		for(int i=0; i<examQuestionArr.length&&examQuestionArr[i]!=null; i++){
			examQuestionArr[i].setExamId(examid);
			this.saveQuestion(examQuestionArr[i]);
		}
		return true;
	}

	@Override
	public List<ExamQuestion> getAllQuestionsList() {
		// TODO Auto-generated method stub
		return examQuestionDao.selectAll();
	}

	@Override
	public void deleteQuestionById(Integer id) {
		// TODO Auto-generated method stub
		examQuestionDao.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(ExamQuestion record) {
		// TODO Auto-generated method stub
		return examQuestionDao.updateByPrimaryKey(record);
	}

	@Override
	public List<ExamQuestion> randomSelectByExamId(Integer count, Integer examId) {
		// TODO Auto-generated method stub
		return examQuestionDao.randomSelectByExamId(count, examId);
	}
}
