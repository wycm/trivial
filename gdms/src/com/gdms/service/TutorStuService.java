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
		 * ��ȡû�е�ʦѡ���ѧ����ʣ�µ�ѧ��
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
		 * ��ȡ��ʦ������ѧ��id
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
	 * ��ȡѧ����Ϣ�����רҵΪnull���򷵻�ȫ��ѧ����Ϣ
	 * ����רҵ����
	 * @param major רҵ
	 * @param grade �꼶
	 * @return
	 */
	public Map<String, List> getData(String major, int grade) {
		/**
		 * ��ȡ��������map����
		 */
		Map<String, List> map = new HashMap<String, List>();
		List<String> teacherList = new ArrayList<String>();
		List<String> studentList = new ArrayList<String>();
		List<String> issueList = new ArrayList<String>();
		//ѧ��
		List<String> workIdList = new ArrayList<String>();
		//רҵ�༶�б�
		List<String> majorList = new ArrayList<String>();
		//�绰�����б�
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
		map.put("ѧ��", studentList);
		map.put("ѧ��", workIdList);
		map.put("רҵ�༶", majorList);
		map.put("�绰����", phoneNumberList);
		map.put("��ʦ", teacherList);
		map.put("����", issueList);
		return map;
	}

	public void exportMajorXls(String major, String filePathAndName) {
		/**
		 * ��ñ�רҵ��Ӧ�꼶��xls���
		 */
		int grade = PropertiesLog4j.getGrade();
		Map<String, List> map = getData(major, grade);
		UtilXls.WriteXls(filePathAndName, map);
//		return null;
	}
	/**
	 * ��ö�Ӧ�꼶��xls���
	 * @param filePathAndName �ļ���
	 */
	public void exportAllXls(String filePathAndName) {
		int grade = PropertiesLog4j.getGrade();
		Map<String, List> map = getData(null, grade);
		UtilXls.WriteXls(filePathAndName, map);
	}
}
