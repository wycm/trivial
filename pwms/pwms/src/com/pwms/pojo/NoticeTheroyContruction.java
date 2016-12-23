package com.pwms.pojo;

import java.util.Date;

public class NoticeTheroyContruction {
    private Integer id;

    private String title;

    private String summary;

    private Date dateline;

    private Integer userId;

    private String contents;
    
    private Articletype articletype;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Date getDateline() {
        return dateline;
    }

    public void setDateline(Date dateline) {
        this.dateline = dateline;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }
    
    public Articletype getArticletype() {
		return articletype;
	}

	public void setArticletype(Articletype articletype) {
		this.articletype = articletype;
	}

	public String toString(){
    	String json = "{"+"\"id\":"+ id + ","+
    		"\"title\": \""+ title +"\" ,"+
    		"\"summary\": \""+ summary +"\" ,"+
    		"\"dateline\": \""+ dateline +"\" ,"+
    		"\"userId\": \""+ userId +"\" ,"+
    		"\"type\": \""+ "" +"\" ,"+
    		"\"contents\": \""+ contents +"\"}";
    	return json;
    }
}