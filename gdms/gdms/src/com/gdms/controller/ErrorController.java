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
	//学生选择导师还未开始
	public static final int STUDENT_CHOOSE_TEACHER_NOT_START = 6;
	//学生选择导师已结束
	public static final int STUDENT_CHOOSE_TEACHER_END = 7;
	//导师选择学生还未开始
	public static final int TEACHER_CHOOSE_STUDENT_NOT_START = 8;
	//导师选择学生已结束
	public static final int TEACHER_CHOOSE_STUDENT_END = 9;
	//public static final int START = 5;
	@RequestMapping("error")
	public String showError(int code, Model model){
		String error=null;
		switch(code){
		case TEACHER:
			error = "你不是老师";break;
		case DIRECTOR:
			error = "你不是系主任";break;
		case STUDENT:
			error = "你不是学生";break;
		case LEADER:
			error = "你不是院领导";break;
		case NOT_STUDENT:
			error = "学生没有这个权限";break;
		case STUDENT_CHOOSE_TEACHER_NOT_START:
			error = getSCTNTMsg();break;
		case STUDENT_CHOOSE_TEACHER_END:
			error = "选择导师已经结束";break;
		case TEACHER_CHOOSE_STUDENT_NOT_START:
			error = getTCSNTMsg();break;
		case TEACHER_CHOOSE_STUDENT_END:
			error = "选择学生已经结束";break;
		default:
				error="未知错误";
		}
		model.addAttribute("msg", error);
		return "notice-msg";
	}
	/**
	 * 获取学生选择导师还未开始的提示消息
	 */
	public String getSCTNTMsg(){
		Properties p = PropertiesUtils.loadConfig();
		String startDate = p.getProperty("studentChooseTeacherStartDate");
		String endDate = p.getProperty("studentChooseTeacherEndDate");
		String msg = "选择导师还未开始，选择导师时间为:" + startDate + "到" + endDate + ",请注意时间安排";
		return msg;
	}
	/**
	 * 获取导师选择学生还未开始的提示信息
	 * @return
	 */
	public String getTCSNTMsg(){
		Properties p = PropertiesUtils.loadConfig();
		String startDate = p.getProperty("teacherChooseStudentStartDate");
		String endDate = p.getProperty("teacherChooseStudentEndDate");
		String msg = "选择学生还未开始，选择学生时间为:" + startDate + "到" + endDate + ",请注意时间安排";
		return msg;
	}
}
