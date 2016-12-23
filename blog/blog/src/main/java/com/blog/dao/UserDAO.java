package com.blog.dao;

import com.blog.pojo.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAO extends BaseDAO<User>{

	public int findMaxId(){
		Session session = super.getCurrentSession();//得到一个Session对象
		Query query = session.createQuery("select max(id) from com.blog.pojo.User as u");
		int count = ((Number)query.uniqueResult()).intValue();
		return count;
	}
	public int getBlogComments(Integer user_id){
		Session session = super.getCurrentSession();//得到一个Session对象
		Query query = session.createQuery("select count(*) from com.blog.pojo.Article as a right join a.comments as c where c.auditingFlag=1 and a.user.id=" + user_id);
		int count = ((Number)query.uniqueResult()).intValue();
		return count;
	}

	public int getMsgCounts(Integer user_id){
		Session session = super.getCurrentSession();//得到一个Session对象
		Query query = session.createQuery("select count(*) from com.blog.pojo.Comment as c where c.auditingFlag=0 and c.article.user.id=" + user_id);
		int count = ((Number)query.uniqueResult()).intValue();
		return count;
	}
	public int getArticleCounts(Integer user_id){
		Session session = super.getCurrentSession();//得到一个Session对象
		Query query = session.createQuery("select count(*) from com.blog.pojo.Article as a where a.user.id=" + user_id);
		int count = ((Number)query.uniqueResult()).intValue();
		return count;
	}
}
