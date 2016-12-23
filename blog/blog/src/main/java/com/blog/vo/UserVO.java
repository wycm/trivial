package com.blog.vo;


import com.blog.pojo.User;

/**
 * Created by wy on 2016/6/19 0019.
 */
public class UserVO extends User {
    private Integer blogComments;//博客的评论数
	private Integer msgCounts;//博客的消息数
	private Integer articleCounts;//博客文章数
	private Integer blogVisits;//博客访问量

	public Integer getBlogComments() {
		return blogComments;
	}

	public void setBlogComments(Integer blogComments) {
		this.blogComments = blogComments;
	}

	public Integer getMsgCounts() {
		return msgCounts;
	}

	public void setMsgCounts(Integer msgCounts) {
		this.msgCounts = msgCounts;
	}

	public Integer getArticleCounts() {
		return articleCounts;
	}

	public void setArticleCounts(Integer articleCounts) {
		this.articleCounts = articleCounts;
	}

	public Integer getBlogVisits() {
		return blogVisits;
	}

	public void setBlogVisits(Integer blogVisits) {
		this.blogVisits = blogVisits;
	}

	@Override
    public String toString() {
        super.toString();
        return "UserVO{" +
                ", blogComments=" + blogComments +
                ", msgCounts=" + msgCounts +
                ", articleCounts=" + articleCounts +
                '}';
    }
}
