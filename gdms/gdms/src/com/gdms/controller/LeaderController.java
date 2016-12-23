package com.gdms.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gdms.tools.PropertiesLog4j;
import com.gdms.tools.PropertiesUtils;

@Controller
@RequestMapping("leader")
public class LeaderController {
	@RequestMapping(value="setStart", method=RequestMethod.POST)
	public String setStartDate(String date, Model model){
		/**
		 * ���ÿ�ʼʱ��
		 */
//		PropertiesLog4j p4j = new PropertiesLog4j();
//		Properties pps = p4j.getProperties();
//		//String s = DateFormat.getDateInstance().format(date);
//		System.out.println("ʱ��:"+dateStr);
//		pps.setProperty("startDate", dateStr);
		PropertiesLog4j.setStartDate(date);
		model.addAttribute("msg", "��ʼʱ������Ϊ:"+date);
		return "notice-msg";
	}
	@RequestMapping(value="setStart", method=RequestMethod.GET)
	public String setStartDate(){
		return "dean/set-choose-teacher-time";
	}
	@RequestMapping(value="setGrade", method=RequestMethod.POST)
	public String setCurrentGrade(int grade, Model model){
		/**
		 * ���õ�ǰ����ѡ��ʦ���꼶
		 */
		PropertiesLog4j.setGrade(grade);
		model.addAttribute("msg", "�꼶����Ϊ:"+grade);
		return "notice-msg";
	}
	@RequestMapping(value="setGrade", method=RequestMethod.GET)
	public String setCurrentGrade(){
		/**
		 * ���õ�ǰ����ѡ��ʦ���꼶����ͼ
		 */
		return "dean/set-grade";
	}
	@RequestMapping(value = "set-student-choose-teacher-time", method = RequestMethod.GET)
	public String showSCT(Model m){
		Properties p = PropertiesUtils.loadConfig();
		m.addAttribute("startDate", p.getProperty("studentChooseTeacherStartDate"));
		m.addAttribute("endDate", p.getProperty("studentChooseTeacherEndDate"));
		return "dean/set-student-choose-teacher-time";
	}
	/**
	 * ����ѧ��ѡ����ʦʱ������
	 * @return
	 */
	@RequestMapping(value = "set-student-choose-teacher-time", method = RequestMethod.POST)
	public String setSCT(Model m, String startDate, String endDate){
		Properties p = PropertiesUtils.loadConfig();
		p.setProperty("studentChooseTeacherStartDate", startDate);
		p.setProperty("studentChooseTeacherEndDate", endDate);
		PropertiesUtils.writeConfigProperties(p);
		m.addAttribute("msg","����ѧ��ѡ��ʦʱ��ɹ�");
		return "notice-msg";
	}
	/**
	 * ����ѧ��ѡ����ʦʱ������
	 * @return
	 */
	@RequestMapping(value = "set-teacher-choose-student-time", method = RequestMethod.GET)
	public String showTCS(Model m){
		Properties p = PropertiesUtils.loadConfig();
		m.addAttribute("startDate", p.getProperty("teacherChooseStudentStartDate"));
		m.addAttribute("endDate", p.getProperty("teacherChooseStudentEndDate"));
		return "dean/set-student-choose-teacher-time";
	}
	/**
	 * ������ʦѡ��ѧ��ʱ������
	 * @return
	 */
	@RequestMapping(value = "set-teacher-choose-student-time", method = RequestMethod.POST)
	public String setTCS(Model m, String startDate, String endDate){
		Properties p = PropertiesUtils.loadConfig();
		p.setProperty("teacherChooseStudentStartDate", startDate);
		p.setProperty("teacherChooseStudentEndDate", endDate);
		PropertiesUtils.writeConfigProperties(p);
		m.addAttribute("msg","���õ�ʦѡ��ѧ��ʱ��ɹ�");
		return "notice-msg";
	}
}
