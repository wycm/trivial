package com.pwms.service.impl;

import java.util.List;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pwms.dao.ExamMapper;
import com.pwms.dao.ExamRecordMapper;
import com.pwms.pojo.Exam;
import com.pwms.pojo.ExamRecord;
import com.pwms.pojo.User;
import com.pwms.service.IExamService;
/**
 * Exam和ExamRecord服务实现
 * @author Administrator
 *
 */
@Service("examService")
public class ExamServiceImpl implements IExamService {
	@Resource
	private ExamMapper examDao;
	@Resource
	private ExamRecordMapper examRecordDao;
//	private ExamRecordMapper examRecordDao;
	@Override
	public Exam getExam(Integer id) {
		// TODO Auto-generated method stub
		return this.examDao.selectByPrimaryKey(id);
	}

	@Override
	public void save(Exam exam) {
		// TODO Auto-generated method stub
		this.examDao.insertSelective(exam);
	}

	@Override
	public void updateById(Exam exam) {
		// TODO Auto-generated method stub
		this.examDao.updateByPrimaryKeySelective(exam);
	}

	@SuppressWarnings("null")
	@Override
	public int getGrade(User user, Exam exam) {
		// TODO Auto-generated method stub
		List<ExamRecord> examRecordList = this.examRecordDao.selectByExamidUserid(exam.getId(), user.getId());
		if(examRecordList != null){
			return examRecordList.get(0).getScore();
		}
		else{
		    return -1;
		}
	}

	@Override
	public void addRecord(ExamRecord examRecord) {
		// TODO Auto-generated method stub
		this.examRecordDao.insertSelective(examRecord);
	}

	@Override
	public List<ExamRecord> getRecord(User user) {
		// TODO Auto-generated method stub
		return examRecordDao.selectByUserid(user.getId());
	}

	@Override
	public List<ExamRecord> getRecordByUserExam(User user, Exam exam) {
		// TODO Auto-generated method stub
//		return examRecordDao.selectByExamidUserid(exam.getId(), user.getId());
		return this.examRecordDao.selectByExamidUserid(exam.getId(), user.getId());
	}

	@Override
	public List<Exam> getExamDesc() {
		// TODO Auto-generated method stub
		return this.examDao.selectDesc();
	}

	@Override
	public void deleteExamById(Integer id) {
		// TODO Auto-generated method stub
		examDao.deleteByPrimaryKey(id);
		
	}

	@Override
	public List<Exam> getExamListByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return examDao.getExamListByUserId(userId);
	}

	@Override
	public List<ExamRecord> selectAll() {
		// TODO Auto-generated method stub
		return examRecordDao.selectAll();
	}

	@Override
	public void deleteExamRecordById(Integer id) {
		// TODO Auto-generated method stub
		examRecordDao.deleteByPrimaryKey(id);
	}

	@Override
	public void updateExamRecord(ExamRecord er) {
		// TODO Auto-generated method stub
		examRecordDao.updateByPrimaryKeySelective(er);
	}

	@Override
	public ExamRecord getExamRecord(Integer id) {
		// TODO Auto-generated method stub
		return examRecordDao.selectByPrimaryKey(id);
	}

	@Override
	public List<ExamRecord> getRecordByUserId(Integer id) {
		// TODO Auto-generated method stub
		return examRecordDao.selectByUserid(id);
	}

}
