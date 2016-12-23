package com.gdms.controller;

import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdms.tools.PropertiesUtils;

@Controller
@RequestMapping("")
public class ErrorController {
	public static final int TEACHER = 0;
	public static final int DIRECTOR = 1;
	public static final int STUDENT = 2;
	public static final int LEADER = 3;
	public static final int NOT_STUDENT = 4;
	//ѧ��ѡ��ʦ��δ��ʼ
	public static final int STUDENT_CHOOSE_TEACHER_NOT_START = 6;
	//ѧ��ѡ��ʦ�ѽ���
	public static final int STUDENT_CHOOSE_TEACHER_END = 7;
	//��ʦѡ��ѧ����δ��ʼ
	public static final int TEACHER_CHOOSE_STUDENT_NOT_START = 8;
	//��ʦѡ��ѧ���ѽ���
	public static final int TEACHER_CHOOSE_STUDENT_END = 9;
	//public static final int START = 5;
	@RequestMapping("error")
	public String showError(int code, Model model){
		String error=null;
		switch(code){
		case TEACHER:
			error = "�㲻����ʦ";break;
		case DIRECTOR:
			error = "�㲻��ϵ����";break;
		case STUDENT:
			error = "�㲻��ѧ��";break;
		case LEADER:
			error = "�㲻��Ժ�쵼";break;
		case NOT_STUDENT:
			error = "ѧ��û�����Ȩ��";break;
		case STUDENT_CHOOSE_TEACHER_NOT_START:
			error = getSCTNTMsg();break;
		case STUDENT_CHOOSE_TEACHER_END:
			error = "ѡ��ʦ�Ѿ�����";break;
		case TEACHER_CHOOSE_STUDENT_NOT_START:
			error = getTCSNTMsg();break;
		case TEACHER_CHOOSE_STUDENT_END:
			error = "ѡ��ѧ���Ѿ�����";break;
		default:
				error="δ֪����";
		}
		model.addAttribute("msg", error);
		return "notice-msg";
	}
	/**
	 * ��ȡѧ��ѡ��ʦ��δ��ʼ����ʾ��Ϣ
	 */
	public String getSCTNTMsg(){
		Properties p = PropertiesUtils.loadConfig();
		String startDate = p.getProperty("studentChooseTeacherStartDate");
		String endDate = p.getProperty("studentChooseTeacherEndDate");
		String msg = "ѡ��ʦ��δ��ʼ��ѡ��ʦʱ��Ϊ:" + startDate + "��" + endDate + ",��ע��ʱ�䰲��";
		return msg;
	}
	/**
	 * ��ȡ��ʦѡ��ѧ����δ��ʼ����ʾ��Ϣ
	 * @return
	 */
	public String getTCSNTMsg(){
		Properties p = PropertiesUtils.loadConfig();
		String startDate = p.getProperty("teacherChooseStudentStartDate");
		String endDate = p.getProperty("teacherChooseStudentEndDate");
		String msg = "ѡ��ѧ����δ��ʼ��ѡ��ѧ��ʱ��Ϊ:" + startDate + "��" + endDate + ",��ע��ʱ�䰲��";
		return msg;
	}
}
