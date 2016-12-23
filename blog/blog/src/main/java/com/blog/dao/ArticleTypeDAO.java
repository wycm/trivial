package com.blog.dao;

import java.util.List;

import com.blog.pojo.Article;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blog.pojo.ArticleType;
@Repository
@Transactional
public class ArticleTypeDAO extends BaseDAO<ArticleType>{
//	private final Logger log = LoggerFactory.getLogger(getClass());
	/**
	 * 获取所有子分类
	 * @return
	 */
	public List<ArticleType> getAllChildrenArticleType(){
		Session session = super.getCurrentSession();
		String hql = "from com.blog.pojo.ArticleType as at where at.parArticleType is not null";
		Query q = session.createQuery(hql);
		List<ArticleType> ats = q.list();
		return ats;
	}
	/**
	 * 根据pid获取所有子分类
	 * @param pid 父id
	 * @return
	 */
	public List<ArticleType> getChildrenArticleType(int pid){
		Session session = super.getCurrentSession();
		String hql = "from com.blog.pojo.ArticleType as at where at.parArticleType.id =" + pid;
		Query q = session.createQuery(hql);
		List<ArticleType> ats = q.list();
		return ats;
	}
	/**
	 * 获取所有父分类
	 * @return
	 */
	public List<ArticleType> getAllParentArticleType(){
		Session session = super.getCurrentSession();
		String hql = "from com.blog.pojo.ArticleType as at where at.parArticleType is null";
		Query q = session.createQuery(hql);
		List<ArticleType> ats = q.list();
		return ats;
	}
	public List<ArticleType> findAdminVOList(){
		String hql = "select new " + entity.getName() + "(id,value,linkname,parArticleType.value)" + "from " + entity.getName();
		return super.findListByHql(hql);
	}
	public List<ArticleType> findParArticleTypeList(){
		String hql = "select new " + entity.getName() + "(id,value)" + "from " + entity.getName();
		return super.findListByHql(hql);
	}
}
