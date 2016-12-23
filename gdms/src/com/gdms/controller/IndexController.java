package com.gdms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdms.pojo.User;
import com.gdms.service.MessageService;
import com.gdms.service.TutorStuService;

@Controller
@RequestMapping("")
public class IndexController {
	@Resource
	private TutorStuService tutorStuService;
	@Resource
	private MessageService messageService;
	public TutorStuService getTutorStuService() {
		return tutorStuService;
	}

	public void setTutorStuService(TutorStuService tutorStuService) {
		this.tutorStuService = tutorStuService;
	}
	/**
	 * 首页
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("")
	public String index(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		int unReadMsgSize;//未读消息数量
		if (user.isStudent()) {
			User teacher = tutorStuService.getTeacherByStudent(user.getId());
			model.addAttribute("teacher", teacher);
		}
		unReadMsgSize = messageService.getUnreadMessageListByUser(user).size();
		model.addAttribute("unReadMsgSize", unReadMsgSize == 0?null:unReadMsgSize);
		model.addAttribute("user", user);
		return "index";
	}

	@RequestMapping("/")
	public String indexTmp(HttpSession session, Model model) {
		index(session,model);
		return "index";
	}

	@RequestMapping("/test1")
	public String test(Model model) {
		return "gd/as-teacher-list";
	}
	@RequestMapping("/notice-msg")
	public String showNoticeMsg(HttpServletRequest request, Model model) {
		model.addAttribute("msg1", request.getParameter("msg1"));
		return "/notice-msg";
	}
}
