<%@ page contentType="text/html;charst=UTF-8" pageEncoding="UTF-8" %>
<div class="crumb-wrap">
            <ul class="nav nav-tabs">
			   <li
					<c:if test="${currentPage == \"fbwz\"}">
					   class="active"
					</c:if>
			   >
				   <a href="user/add-article">发布文章</a>
			   </li>
			   <li
					   <c:if test="${currentPage == \"wzgl\"}">
						   class="active"
					   </c:if>
			   ><a href="user/article-manage">文章管理</a></li>
			   <li
					   <c:if test="${currentPage == \"plgl\"}">
						   class="active"
					   </c:if>
			   >
			   		<a href="user/comment-manage">评论管理</a>
			   		<c:if test="${sessionScope.user.msgCounts != null && sessionScope.user.msgCounts != 0}">
						<span class="remind"><c:out value="sessionScope.user.msgCounts"/></span>
					</c:if>
			   </li>
			   <li
					   <c:if test="${currentPage == \"grzlsz\"}">>
						   class="active"
					   </c:if>
			   ><a href="user/person-info-setting">个人资料设置</a></li>
			</ul>
</div>
