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
		 * 设置开始时间
		 */
//		PropertiesLog4j p4j = new PropertiesLog4j();
//		Properties pps = p4j.getProperties();
//		//String s = DateFormat.getDateInstance().format(date);
//		System.out.println("时间:"+dateStr);
//		pps.setProperty("startDate", dateStr);
		PropertiesLog4j.setStartDate(date);
		model.addAttribute("msg", "开始时间设置为:"+date);
		return "notice-msg";
	}
	@RequestMapping(value="setStart", method=RequestMethod.GET)
	public String setStartDate(){
		return "dean/set-choose-teacher-time";
	}
	@RequestMapping(value="setGrade", method=RequestMethod.POST)
	public String setCurrentGrade(int grade, Model model){
		/**
		 * 设置当前进行选导师的年级
		 */
		PropertiesLog4j.setGrade(grade);
		model.addAttribute("msg", "年级设置为:"+grade);
		return "notice-msg";
	}
	@RequestMapping(value="setGrade", method=RequestMethod.GET)
	public String setCurrentGrade(){
		/**
		 * 设置当前进行选导师的年级的视图
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
	 * 设置学生选择老师时间区间
	 * @return
	 */
	@RequestMapping(value = "set-student-choose-teacher-time", method = RequestMethod.POST)
	public String setSCT(Model m, String startDate, String endDate){
		Properties p = PropertiesUtils.loadConfig();
		p.setProperty("studentChooseTeacherStartDate", startDate);
		p.setProperty("studentChooseTeacherEndDate", endDate);
		PropertiesUtils.writeConfigProperties(p);
		m.addAttribute("msg","设置学生选择导师时间成功");
		return "notice-msg";
	}
	/**
	 * 设置学生选择老师时间区间
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
	 * 设置老师选择学生时间区间
	 * @return
	 */
	@RequestMapping(value = "set-teacher-choose-student-time", method = RequestMethod.POST)
	public String setTCS(Model m, String startDate, String endDate){
		Properties p = PropertiesUtils.loadConfig();
		p.setProperty("teacherChooseStudentStartDate", startDate);
		p.setProperty("teacherChooseStudentEndDate", endDate);
		PropertiesUtils.writeConfigProperties(p);
		m.addAttribute("msg","设置导师选择学生时间成功");
		return "notice-msg";
	}
}
