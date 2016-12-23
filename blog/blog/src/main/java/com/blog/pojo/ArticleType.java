package com.blog.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * ArticleType entity. @author MyEclipse Persistence Tools
 */
@Entity(name="article_type")
public class ArticleType implements java.io.Serializable {
	// Fields
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	@Column
	private String value;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="pid")
	private ArticleType parArticleType;
	@Column
	private String linkname;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "articleType")
	private Set<Article> articles = new HashSet<Article>(0);
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "parArticleType")
	private Set<ArticleType> chiArticleTypes = new HashSet<ArticleType>(0);

	// Constructors

	/** default constructor */
	public ArticleType() {
	
	}
	public ArticleType(Integer id, String value){
		this.id = id;
		this.value = value;
	}
	//后台文章类型管理
	public ArticleType(Integer id, String value, String linkname,  String pValue){
		this.id = id;
		this.value = value;
		this.linkname = linkname;
		ArticleType at = new ArticleType();
		at.setValue(pValue);
		this.parArticleType = at;
	}
	public ArticleType(Integer id, String value, ArticleType parArticleType,
					   String linkname, Set articles, Set chiArticleTypes) {
		super();
		this.id = id;
		this.value = value;
		this.parArticleType = parArticleType;
		this.linkname = linkname;
		this.articles = articles;
		this.chiArticleTypes = chiArticleTypes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ArticleType getParArticleType() {
		return parArticleType;
	}

	public void setParArticleType(ArticleType parArticleType) {
		this.parArticleType = parArticleType;
	}

	public String getLinkname() {
		return linkname;
	}

	public void setLinkname(String linkname) {
		this.linkname = linkname;
	}

	public Set getArticles() {
		return articles;
	}

	public void setArticles(Set articles) {
		this.articles = articles;
	}

	public Set getChiArticleTypes() {
		return chiArticleTypes;
	}

	public void setChiArticleTypes(Set chiArticleTypes) {
		this.chiArticleTypes = chiArticleTypes;
	}
}