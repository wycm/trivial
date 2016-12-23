package com.sshm.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sshm.pojo.User;
import com.sshm.service.UserService;

public class IndexAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private UserService userService;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String execute(){
		user = userService.getUser(35);
		return SUCCESS;
	}
}
