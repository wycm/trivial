package com.blog.service.voservice;


import com.blog.dao.ArticleDAO;
import com.blog.dao.ArticleTypeDAO;
import com.blog.dao.CommentDAO;
import com.blog.dao.MessageDAO;
import com.blog.dao.TagDAO;
import com.blog.vo.HeaderAndSider;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
/**
 * 管理网站herader和sider部分内容
 * 将该部分所需数据设置为session
 * @author wy
 *
 */
@Service
public class HeaderSiderService {
	public Logger log = Logger.getLogger(getClass());
	@Autowired
	private ArticleDAO articleDAO;
	@Autowired
	private ArticleTypeDAO articletypeDAO;
	@Autowired
	private CommentDAO commentDAO;
	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private TagDAO tagDAO;
	private HeaderAndSider headerAndSider;
	public HeaderSiderService(){
		headerAndSider = new HeaderAndSider();
	}
	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}
	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
	public ArticleTypeDAO getArticletypeDAO() {
		return articletypeDAO;
	}
	public void setArticletypeDAO(ArticleTypeDAO articletypeDAO) {
		this.articletypeDAO = articletypeDAO;
	}
	public CommentDAO getCommentDAO() {
		return commentDAO;
	}
	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}
	public MessageDAO getMessageDAO() {
		return messageDAO;
	}
	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}
	public HeaderAndSider getHeaderAndSider() {
		return headerAndSider;
	}
	public void setHeaderAndSider(HeaderAndSider headerAndSider) {
		this.headerAndSider = headerAndSider;
	}
	
	public TagDAO getTagDAO() {
		return tagDAO;
	}
	public void setTagDAO(TagDAO tagDAO) {
		this.tagDAO = tagDAO;
	}
	/**
	 * 将网站hearder和sider部分设置为session
	 * @return
	 */
	public boolean setApplication(ServletContext sc){
		this.headerAndSider.setHotArticles(articleDAO.getHotArticleList());
		this.headerAndSider.setLatestArticles(articleDAO.getLatestArticleList());
		this.headerAndSider.setRandomArticles(articleDAO.getRandomArticleList(null));
		this.headerAndSider.setLatestComments(commentDAO.getLatestComments());
		this.headerAndSider.setLatestMsgs(messageDAO.getLatestMessage());
		this.headerAndSider.setParArticletypes(articletypeDAO.getAllParentArticleType());
		this.headerAndSider.setHotTags(tagDAO.findHotTags(20));
		sc.setAttribute("headerAndSider", headerAndSider);
		return true;
	}
	/**
	 * 判断是否存在hs部分的session，如果存在，不创建session，不存在，创建session
	 * @return
	 */
	public void SessionManage(ServletContext sc){
		if(sc.getAttribute("headerAndSider") == null){
			log.debug("设置headerAndSider中...");
			setApplication(sc);
		}
		else {
			log.debug("headerAndSider中已存在");
		}
	}
}
