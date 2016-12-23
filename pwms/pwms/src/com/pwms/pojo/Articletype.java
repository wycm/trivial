package com.pwms.pojo;

import java.util.ArrayList;
import java.util.List;

public class Articletype {
    private Integer id;

    private String value;

    private Articletype pArticletype;
    
    private List<Articletype> cArticletype;
    
    private String linkname;
    
    private List<NoticeTheroyContruction> articles = new ArrayList<NoticeTheroyContruction>();
    
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
        this.value = value == null ? null : value.trim();
    }

    public Articletype getpArticletype() {
		return pArticletype;
	}

	public void setpArticletype(Articletype pArticletype) {
		this.pArticletype = pArticletype;
	}

	public String getLinkname() {
        return linkname;
    }

    public void setLinkname(String linkname) {
        this.linkname = linkname == null ? null : linkname.trim();
    }

	public List<NoticeTheroyContruction> getArticles() {
		return articles;
	}

	public void setArticles(List<NoticeTheroyContruction> articles) {
		this.articles = articles;
	}

	public List<Articletype> getcArticletype() {
		return cArticletype;
	}

	public void setcArticletype(List<Articletype> cArticletype) {
		this.cArticletype = cArticletype;
	}
}