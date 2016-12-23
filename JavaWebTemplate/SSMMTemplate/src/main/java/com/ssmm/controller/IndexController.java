package com.ssmm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssmm.pojo.User;
import com.ssmm.service.UserService;
@Controller
@RequestMapping("")
public class IndexController{
	private User user;
	@Resource
	private UserService userService;
	@RequestMapping("/index")
	public String getUser(Model model){
		System.out.println("11111111111111");
		user = userService.getUser(7);
		model.addAttribute("user", user);
		return "index";
	}
}
