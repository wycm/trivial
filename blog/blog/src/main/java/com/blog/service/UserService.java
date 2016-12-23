package com.blog.service;


import java.util.List;
import java.util.Map;

import com.blog.dao.UserDAO;
import com.blog.pojo.User;
import com.blog.util.MD5;
import com.blog.vo.UserVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Service
public class UserService extends BaseService<User>{
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserDAO userDAO;
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public void insertUser(User user){
		userDAO.save(user);
	}
	public User getUser(int id){
		return userDAO.findById(id);
	}
	public int findMaxId(){
		return userDAO.findMaxId();
	}
	/**
	 * 检测用户名是否已经存在
	 * @param username
	 * @return
	 */
	public boolean hasUser(String username){
		List list = userDAO.findByProperty("username", username);
		if(list.size() == 0){
			return false;
		}
		return true;
	}
	/**
	 * 验证账户
	 * @param username 用户名
	 * @param password 密码
	 * @return 0表示密码错误 1登录成功 2表示用户被封禁
	 */
	protected int checkLogin(String username,String password, HttpSession session){
		log.debug("username:" + username + "---password:" + password);
		List<User> us = userDAO.findByProperty("username",username);
		if(us.size() == 0){
			return 0;
		}
		else{
			if(us.get(0).getPassword().equals(MD5.getInstance().getMD5(password))){
				log.debug("登录成功!");
				if(us.get(0).getThroughFlag() == 1){
					setUserSession(us.get(0).getId(),session);
					return 1;
				}
				else{
					log.debug("用户被封禁!");
					return 2;
				}
			}
			log.debug("密码错误!");
			return 0;
		}
	}
	/**
	 * 用户登录
	 * @return 登录结果
     */
	public boolean login(Model model, User user, HttpSession session){
		if(user.getUsername() == null || user.getPassword() == null){
			model.addAttribute("loginState", "请输入用户名和密码");
			return false;
		}
		try{
			int rVal = checkLogin(user.getUsername(),user.getPassword(),session);
			System.out.println("登录状态:" + rVal);
			if(rVal == 1){
				//登录成功
				model.addAttribute("loginState", "登录成功");
				return true;
			}
			else if(rVal == 2){
				model.addAttribute("loginState", "该账户已被封禁，请联系管理员");
				return false;
			}
			else{
				model.addAttribute("loginState", "账号或密码错误");
				return false;
				//登录失败
			}
		} catch(Exception e){
			e.printStackTrace();
			model.addAttribute("loginState", "服务器异常，请联系管理员");
			return false;
		}
	}
	/**
	 * 用户注销，清空session
	 * @return
	 */
	public boolean loginOut(){
		Map session = ActionContext.getContext().getSession();
		session.remove("user");
		return true;
	}
	/**
	 * 根据url判断是否存在用户
	 * @param url
	 */
	public boolean hasUserByurl(String url){
		if(userDAO.findByProperty("url", url).size() == 0){
			//不存在该用户
			return false;
		}
		return true;
	}
	public User findUserByurl(String url){
		User user = userDAO.findByProperty("url", url).get(0);
		return user;
	}
	public int getBlogComments(int user_id){
		return userDAO.getBlogComments(user_id);
	}
	public void setBlogVisits(int user_id){
		User user = userDAO.findById(user_id);
		user.getBloginfo().setVisits(user.getBloginfo().getVisits() + 1);
	}
	/**
	 * 审核评论
	 * @param id 评论id
	 * @param flag 审核标志，1表示通过，0表示不通过
	 */
	public void auditing(int id ,int flag){
		User u = userDAO.findById(id);
		u.setThroughFlag(flag);
		userDAO.update(u);
	}
	/**
	 * 刷新用户session
	 * @param user_id
	 */
	public UserVO setUserSession(Integer user_id, HttpSession session){
		User user = userDAO.findById(user_id);
		UserVO uv = new UserVO();
		BeanUtils.copyProperties(user, uv);
		uv.setBlogComments(userDAO.getBlogComments(user_id));
		uv.setMsgCounts(userDAO.getMsgCounts(user_id));
		uv.setArticleCounts(userDAO.getArticleCounts(user_id));
		//此处放在页面上取，会出现lazy no-session异常
		uv.setBlogVisits(uv.getBloginfo().getVisits());
		System.out.println("博客访问量:" + uv.getBlogVisits());
		session.setAttribute("user", uv);
		System.out.println("用户session设置成功");
		return uv;
	}
	public int getmMsgCounts(Integer user_id){
		return userDAO.getMsgCounts(user_id);
	}
}
