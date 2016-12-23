package com.pwms.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pwms.service.IBranchService;
/**
 * 后台管理页面显示，主要负责将页面显示所需数据传输到前台
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminShowController extends BaseController {
	@Resource
	private IBranchService branchService;
	@RequestMapping("/index")
	public String directView(HttpSession session){
		//测试专用，设置支部session
		session.setAttribute("branch", branchService.getBranch(1));
		System.out.println("支部负责人登录成功！");
		return "admin/index";
	}
}
