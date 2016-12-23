<%@ page contentType="text/html;charst=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div id="sider" class="fr">
     <div class="clear"></div>
	<c:if test="${sessionScope.user != null}">
   		<div class="con_box userinfo_box clearfix">
     		<div class="userinfo">
				    <div class="head pub-style ">
				    	<div class="user_img">
				    	<a href="user/${sessionScope.user.id}" title="我的博客">
				    	<img class="img-rounded img-thumbnail" src="upload/headpic/${sessionScope.user.headpicname}" width="80px" height="80px">
				    	</a>
				    	</div>
				    	<div class="username">
				    		<label style="font-size:18px;">${sessionScope.user.username}</label>
				    		<p><a href="user/CommentManage?sort" class="notice">消息(<span msgtype="notice">${sessionScope.user.msgCounts}</span>)</a> | 
				    		<a href="user/loginout" class="logout">退出</a>
				    		</p>
				    	</div>
				    </div>
				    <div class="bloginfo pub-style">
				    		<ul class="clearfix">
				    			<li class="fl">博客文章：<span msgtype="level">${sessionScope.user.articleCounts}</span></li>
				    			<li class="fl">博客访问：<span msgtype="pv">${sessionScope.user.blogVisits}</span></li>
				    			<li class="fl">博客评论：<span msgtype="userpoint">${sessionScope.user.blogComments}</span></li>
				    			<li class="fl">博客年龄：<span msgtype="num">0</span></li>
				    		</ul>
				    </div>
				    <div class="shortcut pub-style">
				    	<button type="button" class="btn btn-success" onclick="window.open('user/ReleaseArticle')">发表文章</button>
				    	<button type="button" class="btn btn-success" onclick="window.open('user/ArticleManage')">文章管理</button>
				    	<button type="button" class="btn btn-success" onclick="window.open('user/CommentManage')">评论管理</button>
				    </div>
   			</div>
   		</div>
   		</c:if>
     	<div class="con_box htabs_art clearfix"> 
		<ul class="cooltab_nav sj_nav clearfix">
			<li><a href="#" class="active" title="new_art" >最新文章</a></li>
			<li><a href="#" title="hot_art">热门文章</a></li>
			<li><a href="#" title="rand_art">随机推荐</a></li>
		</ul>   
		<div id="new_art" class="com_cont" style="display: block;">   
			<ul>
				<c:forEach items="${applicationScope.headerAndSider.latestArticles}" var="item">
					<%@ include file="sider-article-list.jsp" %>
				</c:forEach>
			</ul>
		</div>
        <div id="hot_art" class="com_cont" style="display: none;">
    		<ul>
				<c:forEach items="${applicationScope.headerAndSider.hotArticles}" var="item">
				<%@ include file="sider-article-list.jsp" %>
				</c:forEach>
			</ul>
		</div>
		<div id="rand_art" class="com_cont" style="display: none;">
			<ul>
				<c:forEach items="${applicationScope.headerAndSider.randomArticles}" var="item">
				<%@ include file="sider-article-list.jsp" %>
				</c:forEach>
			</ul>
		</div>
	</div>
<script type="text/javascript">
 		$(document).ready(function(){
 			//设置随机颜色标签
 			$(".tagcloudy a").each(function(){
			var rgbColor ="#" + Math.round(Math.random() * 255).toString(16) + Math.round(Math.random() * 255).toString(16) + Math.round(Math.random() * 255).toString(16);
			var randomSize = Math.round(Math.random() * 6) + 12 + "px";
			var styleAttr = "color:" + rgbColor + ";" + "font-size:" + randomSize +";";
			$(this).attr("style",styleAttr);
 			});
		});
</script>
     <div class="con_box hot_box"> 
      <h3>热门标签</h3>
      <ul class="tagcloudy"><li>
		  <c:forEach items="${applicationScope.headerAndSider.hotTags}" var="item">
			  <a href="article/tag/${item.value}" title="包含  ${item.value}  标签文章">${item.value}</a>
		  </c:forEach>
	  </li></ul>
     </div> 
     <div class="con_box hot_box"> 
      <h3>最新留言</h3> 
      <div class="readers clearfix"> 
      			<ul>
			<c:forEach items="${applicationScope.headerAndSider.latestMsgs}" var="item">
				<li>
					<a href="user/${item.user.id}" title="<c:out value="${item.content}"/>">
					${item.user.username}:<br>
					</a>
					<c:choose>
					<c:when test="${fn:length(item.content) >= '19'}">
							<c:out value="${fn:substring(item.content,0,18)}"/>...
					</c:when>
					<c:otherwise>
							<c:out value="${item.content}"/>
					</c:otherwise>
					</c:choose>
				</li>
			</c:forEach>
			</ul>
      </div> 
     </div> 
     <div class="con_box hot_box">
		<h3>最新评论</h3>
		<div class="r_comments">
			<ul>
				<c:forEach items="${applicationScope.headerAndSider.latestComments}" var="lcitem">
				<li>
					<a href="user/${lcitem.user.id}" title="${lcitem.user.username}的主页">
					${lcitem.user.username}
					</a>:<br>
					<a href="article/${lcitem.article.id}" title="发表在： ${lcitem.article.title}">
						<c:choose>
							<c:when test="${fn:length(lcitem.content) >= '19'}">
								<c:out value="${fn:substring(lcitem.content,0,18)}"/>...
							</c:when>
							<c:otherwise>
								<c:out value="${lcitem.content}"/>
							</c:otherwise>
						</c:choose>
					</a>
				</li>
				</c:forEach>
			</ul>
		</div>				
	</div>
     <div class="hcms_rollbox"></div> 
     <div id="rollstart"></div> 
    </div>