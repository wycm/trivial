package com.pwms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pwms.pojo.Process;
import com.pwms.pojo.ProcessRecord;
import com.pwms.pojo.User;
import com.pwms.service.IProcessService;

@Controller
@RequestMapping("/process")
public class ProcessController extends BaseController {
	//查看已经完成的进度，以一棵进度树的形式显示
	@Resource
	private IProcessService processService;
	@RequestMapping({"/","","/jpprocess"})
	public String getProcess(HttpServletRequest request, HttpSession session, Model model){
		return "website/process/jpprocess";
	}
	@RequestMapping("/myprocess")
	public String getUserProcess(HttpServletRequest request, HttpSession session, Model model){
		User user = (User) session.getAttribute("user");
		System.out.println(user.getName());
		List<ProcessRecord> userProcessList = this.processService.getUserProcessRecord(user);
		if(verifyClient(request)){
			outJson("{"+listToJson("userProcessList",userProcessList)+"}");
			return null;
		}
		model.addAttribute("userProcessList", userProcessList);
		return "website/process/myjpprocess";
	}
	//根据id显示详细介绍
	@RequestMapping("/detail")
	public String getDetail(HttpServletRequest request, int id, Model model){
		Process process = this.processService.getProcess(id);
		if(verifyClient(request)){
			outJson(objectToJson("process",process));
			return null;
		}
		model.addAttribute("process", process);
		return null;
	}
}
