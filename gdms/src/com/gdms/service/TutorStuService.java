package com.gdms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdms.dao.IssueMapper;
import com.gdms.dao.TutorStuMapper;
import com.gdms.dao.UserMapper;
import com.gdms.pojo.Issue;
import com.gdms.pojo.TutorStu;
import com.gdms.pojo.User;
import com.gdms.tools.PropertiesLog4j;
import com.gdms.tools.UtilXls;

@Service("tutorService")
public class TutorStuService {
	@Resource
	private UserMapper userDAO;
	@Resource
	private TutorStuMapper tutorStuDAO;
	@Resource
	private IssueMapper issueDAO;

	public IssueMapper getIssueDAO() {
		return issueDAO;
	}

	public void setIssueDAO(IssueMapper issueDAO) {
		this.issueDAO = issueDAO;
	}

	public UserMapper getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserMapper userDAO) {
		this.userDAO = userDAO;
	}

	public TutorStuMapper getTutorStuDAO() {
		return tutorStuDAO;
	}

	public void setTutorStuDAO(TutorStuMapper tutorStuDAO) {
		this.tutorStuDAO = tutorStuDAO;
	}

	public boolean create(int studentId, int teatherId) {
		User teacher = userDAO.selectByPrimaryKey(teatherId);
		User student = userDAO.selectByPrimaryKey(studentId);
		int grade = PropertiesLog4j.getGrade();
		if (teacher == null || student == null) {
			return false;
		} else {
			if (teacher.getAmount() == null
					|| tutorStuDAO.selectChoiseCount(teatherId, grade) >= teacher
							.getAmount()) {
				return false;
			}
			TutorStu oldTutor = tutorStuDAO.getTeacherByStudentId(studentId);
			if(oldTutor==null){
				TutorStu tutorStu = new TutorStu();
				tutorStu.setStudentId(studentId);
				tutorStu.setTeathcerId(teatherId);
				tutorStuDAO.insertSelective(tutorStu);
			}else{
				oldTutor.setStudentId(studentId);
				oldTutor.setTeacherId(teatherId);
				tutorStuDAO.updateByPrimaryKeySelective(oldTutor);
			}
			
			return true;
		}
	}
	
	public boolean createByArr(int studentId[], int teathcerId) {
		for (int i=0; i<studentId.length; i++){
			boolean isSucc = create(studentId[i], teathcerId);
			if(!isSucc){
				return false;
			}
		}
		return true;
	}
	public List<User> getLastStudentByMajor(String major) {
		/**
		 * 获取没有导师选择的学生，剩下的学生
		 */
//		PropertiesLog4j p4j = new PropertiesLog4j();
		int grade = PropertiesLog4j.getGrade();
		return userDAO.getLastStudentByMajor(major, grade);
	}

	public void distributeStudent(int[] studentId, int teacherId) {
		for (int i = 0; i < studentId.length; i++) {
			create(studentId[i], teacherId);
		}
	}

	public User getTeacherByStudent(int studentId) {
		/**
		 * 获取老师，根据学生id
		 */
		TutorStu tutorStu = tutorStuDAO.getTeacherByStudentId(studentId);
		if(tutorStu==null){
			return null;
		}
		User teacher = null;
		if(tutorStu.getTeacherId()!=null&&tutorStu.getTeacherId()!=0){
			teacher = userDAO.selectByPrimaryKey(tutorStu.getTeacherId());
		}
		tutorStu.setInstance(userDAO.selectByPrimaryKey(tutorStu.getStudentId()), teacher);
		return tutorStu.getTeacher();
	}
	/**
	 * 获取学生信息，如果专业为null，则返回全部学生信息
	 * 否则按专业返回
	 * @param major 专业
	 * @param grade 年级
	 * @return
	 */
	public Map<String, List> getData(String major, int grade) {
		/**
		 * 获取所有数据map对象
		 */
		Map<String, List> map = new HashMap<String, List>();
		List<String> teacherList = new ArrayList<String>();
		List<String> studentList = new ArrayList<String>();
		List<String> issueList = new ArrayList<String>();
		//学号
		List<String> workIdList = new ArrayList<String>();
		//专业班级列表
		List<String> majorList = new ArrayList<String>();
		//电话号码列表
		List<String> phoneNumberList = new ArrayList<String>();
		List<TutorStu> tutorStuList = null;
		if(major == null){
			tutorStuList = tutorStuDAO.getAllTutorStu(grade);
		}
		else{
			tutorStuList = tutorStuDAO.getTutorStuByMajor(major, grade);
		}
		for (int i = 0; i < tutorStuList.size(); i++) {
			TutorStu tutorStu = tutorStuList.get(i);
			tutorStu.setInstance(userDAO.selectByPrimaryKey(tutorStu.getStudentId()), userDAO.selectByPrimaryKey(tutorStu.getTeacherId()));
			User teacher = tutorStu.getTeacher();
			User student = tutorStu.getStudent();
			teacherList.add(teacher.getName());
			studentList.add(student.getName());
			workIdList.add(student.getWorkId() + "");
			phoneNumberList.add(student.getPhoneNumber());
			majorList.add(student.getMajor() + "-" + student.getUserClass());
			Integer issueId = student.getIssueId();
			Issue issue;
			if (issueId != null) {
				issue = issueDAO.selectByPrimaryKey(issueId);
				issueList.add(issue.getSubject());
			} else {
				issueList.add(null);
			}
		}
		map.put("学生", studentList);
		map.put("学号", workIdList);
		map.put("专业班级", majorList);
		map.put("电话号码", phoneNumberList);
		map.put("老师", teacherList);
		map.put("课题", issueList);
		return map;
	}

	public void exportMajorXls(String major, String filePathAndName) {
		/**
		 * 获得本专业对应年级的xls结果
		 */
		int grade = PropertiesLog4j.getGrade();
		Map<String, List> map = getData(major, grade);
		UtilXls.WriteXls(filePathAndName, map);
//		return null;
	}
	/**
	 * 获得对应年级的xls结果
	 * @param filePathAndName 文件名
	 */
	public void exportAllXls(String filePathAndName) {
		int grade = PropertiesLog4j.getGrade();
		Map<String, List> map = getData(null, grade);
		UtilXls.WriteXls(filePathAndName, map);
	}
}
