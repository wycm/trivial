package com.blog.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import com.blog.pojo.Article;
import com.blog.pojo.ArticleType;
import com.blog.util.StaticConstants.orderEnum;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ArticleDAO extends BaseDAO<Article>{
	private final Log log = LogFactory.getLog(getClass());
	/**
	 * 插入文章
	 * @param a
	 * @param articletype_id
	 */
	public void insertArticle(Article a,int articletype_id){
		Session session = super.getCurrentSession();
		ArticleType at = (ArticleType)session.get(ArticleType.class, articletype_id);
		a.setArticletype(at);
		try{
			session.merge(a);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//后台管理列表
	public List<Article> findAdminVOList(){
		String hql = "select new com.blog.pojo.Article(id,title,visits,releasetime,user.username,articleType.value) from com.blog.pojo.Article";
		return findListByHql(hql);
	}
	/**
	 * 条件查询文章列表
	 * @param size 文章数量
	 * @param userId 用户id
	 * @param orderProperty 排序属性
	 * @param order 排序方式
     * @return 文章列表
     */
	private List<Article> selectArticle(int size
			, Integer userId
			, String orderProperty
			, orderEnum order){
		String ws = userId == null?"":"where a.user.id=" + userId + " ";
		String hql = "select new com.blog.pojo.Article(id,title,user.id,visits) from com.blog.pojo.Article as a " +
				ws +
				"order by a." + orderProperty + " " + order;
		log.debug("hql:" + hql);
		Query query = super.getCurrentSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(size);
		List<Article> list = query.list();
		return list;
	}

	/**
	 * 获取全站热门文章
	 * @return 文章列表
	 */
	public List<Article> getHotArticleList(){
		return selectArticle(5, null, "visits", orderEnum.desc);
	}
	/**
	 * 获取某个用户的热门文章
	 * @return 文章列表
	 */
	public List<Article> getHotArticleList(Integer uid){
		return selectArticle(5, uid, "visits", orderEnum.desc);
	}

	/**
	 * 获取最新文章
	 * @return 5篇最新文章列表
	 */
	public List<Article> getLatestArticleList(){
		return selectArticle(5, null, "id", orderEnum.desc);
	}
	/**
	 * 获取某个用户最新文章
	 * @return 5篇最新文章列表
	 */
	public List<Article> getLatestArticleList(Integer userId){
		return selectArticle(5, userId, "id", orderEnum.desc);
	}
	/**
	 * 随机获取文章
	 * @param userId 用户id(如果为null则全站查询)
	 * @return 5篇随机文章列表
	 */
	public List<Article> getRandomArticleList(Integer userId){
		Session session = super.getCurrentSession();//得到一个Session对象
		String ws = userId == null?"":" where a.user.id=" + userId + " ";
		//获取所有文章id
		Query query = session.createQuery("select new com.blog.pojo.Article(id) from com.blog.pojo.Article as a" + ws);
		List<Article> list = query.list();
		Collections.shuffle(list);//将list顺序打乱
		int size = list.size() <= 5?list.size():5;
		if(size == 0){
			//没有文章
			return new ArrayList<Article>();
		}
		else {
			Integer[] ids = new Integer[size];
			for (int i = 0; i < size; i++) {
				ids[i] = list.get(i).getId();
			}
			query = session.createQuery("select new com.blog.pojo.Article(id,title,user.id,visits) from com.blog.pojo.Article as a where a.id in(:idList)");
			query.setParameterList("idList", ids);
			list = query.list();
			return list;
		}
	}
	/**
	 * 获取数据库中文章数量
	 * @return 文章数量
	 */
	public int getArticleCount(){
		return findCount("select count(*) from com.blog.pojo.Article as a");
	}

	/**
	 * 根据hql获取count
	 * @param hql
	 * @return
     */
	public int findCount(String hql){
		Session session = super.getCurrentSession();//得到一个Session对象
		Query query = session.createQuery(hql);
		int count = ((Number)query.uniqueResult()).intValue();
		return count;
	}
	public List<Article> search(String value){
		Session session = super.getCurrentSession();//得到一个Session对象
		String hql="from com.blog.pojo.Article as a where a.title like ? or a.content like ?";
		Query query = session.createQuery(hql); 
		query.setString(0,"%"+value+"%");
		query.setString(1,"%"+value+"%");
		List list=query.list(); 
		return list;
	}
}