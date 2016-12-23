package com.blog.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blog.pojo.BlogInfo;
@Repository
@Transactional
public class BlogInfoDAO extends BaseDAO<BlogInfo>{
//	private static final Logger log = LoggerFactory
//			.getLogger(BlogInfoDAO.class);
	
	public BlogInfo merge(BlogInfo detachedInstance) {
//		log.debug("merging Bloginfo instance");
		try {
			BlogInfo result = (BlogInfo) super.getCurrentSession().merge(
					detachedInstance);
//			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
//			log.error("merge failed", re);
			throw re;
		}
	}
	public int findMaxId(){
		Session session = super.getCurrentSession();//得到一个Session对象
		Query query = session.createQuery("select max(id) from BlogInfo as b");
		int count = ((Number)query.uniqueResult()).intValue();
		return count;
	}
}