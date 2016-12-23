package com.blog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.blog.dao.CommentDAO;
import com.blog.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends BaseService<Comment>{
	@Autowired
	private CommentDAO commentDAO;
	public CommentDAO getCommentDAO() {
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
	/**
	 * 插入评论
	 * @param c 评论
	 * @param article_id
	 */
	@SuppressWarnings("unchecked")
	public void insertComment(Comment c, int article_id){
		//提醒用户审核评论
		commentDAO.insertComment(c, article_id);
		
	}
	/**
	 * 通过article_id查询所有评论
	 * @param article_id
	 * @return 该文章所有(已通过审核)第一级Comment列表
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getParentComments(int article_id){
		Map<String, Object> conditionMap = new HashMap<String, Object>();
		conditionMap.put("article.id",article_id);
		conditionMap.put("parComment.id",null);
		return commentDAO.findByProperty(conditionMap);
	}
	/**
	 * 通过parent_id查询所有子评论
	 * @param parent_id
	 * @return parent_id对应子评论列表
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getChildrenComments(int parent_id){
		return commentDAO.findByProperty("parComment.id", parent_id);
	}
	/**
	 * 获取最新评论
	 * @return 最近5条评论List
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getLatestComments(){
		return commentDAO.getLatestComments();
	}

	/**
	 * 审核评论
	 * @param id 评论id
	 * @param flag 审核标志，1表示通过，0表示不通过
	 */
	public void auditing(int id ,int flag){
		Comment c = commentDAO.findById(id);
		c.setAuditingFlag(1);//表示已审核
		c.setThroughFlag(flag);
		commentDAO.update(c);
	}
	/**
	 * 获取所有评论数
	 * @return
	 */
	public int getCommentCount(){
		return commentDAO.getCommentCount();
	}
	/**
	 *顶评论
	 * @param id
	 */
	public void setCommentLight(int id){
		commentDAO.setCommentLight(id);
	}
	/**
	 * @param article_id
	 * @return article_id对应文章评论数
	 */
	public int getArticleCommentCount(int article_id){
		return commentDAO.getArticleCommentCount(article_id);
	}
	/**
	 * 获取该用户博客所有待审核的评论
	 * @return
	 */
	public List<Comment> getUnauditing(Integer user_id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user.id", user_id);
		map.put("auditingFlag",0);
		return commentDAO.findByProperty(map);
	}
	public List<Comment> getLatestComment(Integer user_id){
		return commentDAO.getLatestComments(user_id);
	}
	public List<Comment> findAdminVOList(){
		return commentDAO.findAdminVOList();
	}
}
