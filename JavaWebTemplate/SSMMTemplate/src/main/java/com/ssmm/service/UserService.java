package com.ssmm.service;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssmm.dao.UserDAO;
import com.ssmm.pojo.User;
@Service("userService")
public class UserService {
	@Resource
	private UserDAO userDAO;
	public User getUser(int id){
		return userDAO.selectByPrimaryKey(id);
	}
}
