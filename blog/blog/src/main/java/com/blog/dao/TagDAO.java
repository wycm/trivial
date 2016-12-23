package com.blog.dao;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blog.pojo.Tag;
@Repository
@Transactional
public class TagDAO extends BaseDAO<Tag>{
//	private static final Logger log = LoggerFactory.getLogger(TagDAO.class);
	public static final String VALUE = "value";
	public List<Tag> findHotTags(int size){
//		log.debug("finding all Tag instances");
		try {
			String queryString = "from com.blog.pojo.Tag";
			Query queryObject = super.getCurrentSession().createQuery(queryString);
			queryObject.setFirstResult(0);
			queryObject.setMaxResults(size);
			return queryObject.list();
		} catch (RuntimeException re) {
//			log.error("find all failed", re);
			throw re;
		}
	}
	public Tag merge(Tag detachedInstance) {
//		log.debug("merging Tag instance");
		try {
			Tag result = (Tag) super.getCurrentSession().merge(detachedInstance);
//			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
//			log.error("merge failed", re);
			throw re;
		}
	}
}