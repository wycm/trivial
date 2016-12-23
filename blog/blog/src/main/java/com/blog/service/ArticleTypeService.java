package com.blog.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.blog.dao.ArticleTypeDAO;
import com.blog.pojo.Article;
import com.blog.pojo.ArticleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleTypeService extends BaseService<ArticleType>{
	@Autowired
	private ArticleTypeDAO articleTypeDAO;

	public ArticleTypeDAO getArticleTypeDAO() {
		return articleTypeDAO;
	}

	public void setArticleTypeDAO(ArticleTypeDAO articleTypeDAO) {
		this.articleTypeDAO = articleTypeDAO;
	}
	public void insertArticleType(ArticleType at){
		articleTypeDAO.save(at);
	}
	/**
	 * 获取所有子分类
	 * @return
	 */
	public List<ArticleType> getAllChildrenArticleType(){
		return articleTypeDAO.getAllChildrenArticleType();
	}
	/**
	 * 通过linkName获取Articletype
	 * @param linkName
	 * @return
	 */
	public ArticleType getArticletype(String linkName){
		return articleTypeDAO.findByProperty("linkname", linkName).get(0);
	}
	/**
	 * 根据pid获取所有子分类
	 * @param pid 父id
	 * @return
	 */
	public List<ArticleType> getChildrenArticleType(int pid){
		return articleTypeDAO.getChildrenArticleType(pid);
	}
	/**
	 * 获取所有父分类
	 * @return
	 */
	public List<ArticleType> getAllParentArticleType(){
		return articleTypeDAO.getAllParentArticleType();
	}
	/**
	 * 通过id查询ArticleType
	 * @param id
	 * @return
	 */
	public ArticleType getArticleType(int id){
		return articleTypeDAO.findById(id);
	}
	public ArticleType getArticleType(String linkeName){
		return articleTypeDAO.findByProperty("linkname", linkeName).get(0);
	}
	public Set<ArticleType> findArticleByArticleType(String linkname){
		Set<ArticleType> set = articleTypeDAO.findByProperty("linkname", linkname).get(0).getArticles();
		return set;
	}
	public void removeArticle(Article a){
		ArticleType at = a.getArticleType();
		at.getArticles().remove(a);
		articleTypeDAO.update(at);
	}
	public List<ArticleType> findAdminVOList(){
		return articleTypeDAO.findAdminVOList();
	}
	public List<ArticleType> findParArticleTypeList(){
		return articleTypeDAO.findParArticleTypeList();
	}
	public void insertArticleType(int pid, String value){
		ArticleType at = new ArticleType();
		at.setValue(value);
		at.setLinkname(value);
		ArticleType pat = new ArticleType();
		pat.setId(pid);
		at.setParArticleType(pat);
		save(at);
	}
}
