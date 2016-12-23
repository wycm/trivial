package com.sshm.service;



import com.sshm.dao.UserHbmSQL;
import com.sshm.pojo.User;

public class UserService {
	private UserHbmSQL userDAO;
	public UserHbmSQL getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserHbmSQL userDAO) {
		this.userDAO = userDAO;
	}
	public void insertUser(User user){
		userDAO.save(user);
	}
	public User getUser(int id){
		return userDAO.getUser(id);
	}
	public int findMaxId(){
		return userDAO.findMaxId();
	}
}
