package com.pwms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pwms.pojo.Process;
import com.pwms.service.IProcessService;

@Controller
@RequestMapping("/admin/process")
public class AdminProcessController extends BaseController {
	@Resource
	private IProcessService processService;
	//查看所有的进度，以用户名以及，进度号列表显示
	@RequestMapping("/all")
	public String getAll(Model model){
		List<Process> processList = this.processService.getProcessList();
		model.addAttribute("processList", processList);
		return null;
	}
	//xls导出所有的进度
	@RequestMapping("/export")
	public String exportXls(Model model){
		return null;
	}
}
