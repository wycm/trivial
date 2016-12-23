package com.blog.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blog.pojo.Article;
import com.blog.pojo.Comment;
@Repository
@Transactional
public class CommentDAO extends BaseDAO<Comment>{
//	private final Logger log = LoggerFactory.getLogger(CommentDAO.class);
	/**
	 * 插入评论
	 * @param c 评论
	 * @param article_id
	 */
	@SuppressWarnings("unchecked")
	public void insertComment(Comment c,int article_id){
		Session session = super.getCurrentSession();
		Article article = (Article)session.get(Article.class, article_id);
		c.setArticle(article);
		try{
			session.save(c);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 获取最新评论
	 * @return 最近5条评论List
	 */
	@SuppressWarnings("unchecked")
	public List<Comment> getLatestComments(){
		Session session = super.getCurrentSession();//得到一个Session对象
		Query query = session.createQuery("from com.blog.pojo.Comment as c where c.throughFlag=1 order by c.id desc");
		query.setFirstResult(0);
		query.setMaxResults(5);
		List<Comment> list = query.list();
		return list;
	}
	public List<Comment> getLatestComments(Integer user_id){
		Session session = super.getCurrentSession();//得到一个Session对象
		Query query = session.createQuery("from com.blog.pojo.Comment as c where c.article.user.id=" + user_id + " and c.throughFlag=1 order by c.id desc");
		query.setFirstResult(0);
		query.setMaxResults(5);
		List<Comment> list = query.list();
		return list;
	}
	/**
	 * 通过Comment id查询user_id
	 * @param id
	 * @return user_id
	 */
	public int getUserId(int id){
		Session session = super.getCurrentSession();//得到一个Session对象
		Query query = session.createQuery("select c.user.id from com.blog.pojo.Comment as c where id=" + id);
		int userId = ((Number)query.uniqueResult()).intValue();
		return userId;
	}
	/**
	 * 审核评论
	 * @param id 评论id
	 * @param flag 审核标志，1表示通过，0表示不通过
	 */
	public void auditing(int id ,int flag){
		String hql = "UPDATE com.blog.pojo.Comment c SET c.throughFlag=" + flag + " ,c.auditingFlag=1 WHERE c.id="+id;
		Session session = super.getCurrentSession();
		try{
			Query q = session.createQuery(hql);
			q.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 获取所有评论数
	 * @return
	 */
	public int getCommentCount(){
		String hql = "select count(*) from com.blog.pojo.Comment";
		Session session = super.getCurrentSession();
		Query q = session.createQuery(hql);
		int count = ((Number)q.uniqueResult()).intValue();
		return count;
	}
	/**
	 * 顶评论
	 * @param id
	 */
	public void setCommentLight(int id){
		String hql = "update com.blog.pojo.Comment as c set c.light=c.light+1 where c.id=" + id;
		Session session = super.getCurrentSession();
		try{
			Query q = session.createQuery(hql);
			q.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} 
	}
	/**
	 * @param article_id
	 * @return article_id对应文章评论数
	 */
	public int getArticleCommentCount(int article_id){
		Session session = super.getCurrentSession();//得到一个Session对象
		Query query = session.createQuery("select count(*) from com.blog.pojo.Comment as c where c.throughFlag=1 and c.article.id=" + article_id);
		int count = ((Number)query.uniqueResult()).intValue();
		return count;
	}
	public List<Comment> findAdminVOList(){
		String hql = "select new com.blog.pojo.Comment(id, content, time," +
				"throughFlag,auditingFlag,user.username) from com.blog.pojo.Comment";
		return findListByHql(hql);
	}
}
