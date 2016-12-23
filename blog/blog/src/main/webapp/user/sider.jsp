<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charst=UTF-8" pageEncoding="UTF-8" %>
<div id="sider" class="fr"> 
     <div class="clear"></div>
     <div class="con_box hot_box"> 
      <h3>个人资料</h3> 
      <div class="readers clearfix"> 
      		<div class="person-info">
      			<div class="headpic">
      			<a href="user/<c:out value="${userSider.user.url}"/>" title="<c:out value="${userSider.user.username}"/>的主页">
					<img class="img-rounded" src="upload/headpic/<c:out value="${userSider.user.headpicname}"/>" width="120px" height="120px">
				</a>
				<strong><c:out value="${userSider.user.username}"/></strong>
				</div>
				<div class="blog-intro">
					<ul>
						<li>博客访问：<c:out value="${userSider.user.bloginfo.visits}"/></li>
						<li>博客文章：<c:out value="TODO"/></li>
						<li>博客评论：<c:out value="${userSider.blogComments}"/></li>
					</ul>
				</div>
      		</div>
      </div> 
     </div>
          <div class="con_box hot_box"> 
          	<div class="person-info">
      <h3>阅读排行</h3> 
      <div class="readers clearfix"> 
      			<ul>
			<c:forEach items="${userSider.userHotArticles}" var="item">
					<li>
					<a href="article/<c:out value="${item.id}" />" title="<c:out value="${item.title}" />" class="title">
						<c:choose>
							<c:when test="${fn:length(item.title)>'17'}">
								${fn:substring(item.title,0 ,16 )}...
							</c:when>
							<c:otherwise>
								${item.title}
							</c:otherwise>
						</c:choose>
					</a>
 				<div class="visits">
 					(<c:out value="${item.visits}"/>)
 				</div>
				</li>
			</c:forEach>
			</ul>
      </div> 
      	</div>
     </div> 
     <div class="con_box hot_box">
		<h3>最新评论</h3>
		<div class="r_comments">
			<ul>
				<c:forEach items="${userSider.userLatestComments}" var="item">
				<li>
					<a href="article/<c:out value="${item.article.id}" />" title="发表在： <c:out value="${item.article.title}" />">
						<c:choose>
							<c:when test="${fn:length(item.article.title) > '19'}">
								<c:out value="${fn:substring(item.article.title,0 ,18 )}"/>...
							</c:when>
							<c:otherwise>
								<c:out value="${item.article.title}"/>
							</c:otherwise>
						</c:choose>
					</a>
					<br>
					<a href="user/<c:out value="${userSider.user.url}" />" title="发表在： <c:out value="${item.article.title}" />">
						<c:out value="${item.user.username}" />
					</a>:
					<c:out value="${item.content}" /><br>
				</li>
				</c:forEach>
			</ul>
		</div>				
	</div>
	<div class="con_box hot_box">
		<h3>随机推荐</h3>
		<div class="r_comments">
			<ul>
				<c:forEach items="${userSider.userRandomArticles}" var="item">
				<li>
					<a href="article/<c:out value="${item.id}" />" title="<c:out value="${item.title}" />" class="title">
						<c:choose>
							<c:when test="${fn:length(item.title)>'19'}">
								${fn:substring(item.title,0 ,18 )}...
							</c:when>
							<c:otherwise>
								${item.title}
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