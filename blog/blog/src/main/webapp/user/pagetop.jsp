<%@ page contentType="text/html;charst=UTF-8" pageEncoding="UTF-8" %>
<div class="pagetop">
	<div class="topinfo">
		<c:choose>
			<c:when test="${sessionScope.user != null}">
				<div id="navmenu">
					<ul>
						<li><a href="user/<c:out value="${sessionScope.user.url}"/>" title="<c:out value="${sessionScope.user.username}"/>的主页">
							<img class="img-circle" src="upload/headpic/<c:out value="${sessionScope.user.headpicname}"/>" width="40px" height="40px">
						</a>
							<ul class="sub-menu" id="hidden-ul" style="display:none;">
								<li><a href="user/add-article">个人中心</a></li>
								<li><a href="user/article-manage">文章管理</a></li>
								<li><a href="user/comment-manage">评论管理</a></li>
								<li><a href="user/person-info-setting">资料设置</a></li>
								<li><a href="user/loginout">注销</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</c:when>
			<c:otherwise>
				<ul class="notlogin">
					<li><a href="register">注册</a></li>
					<li><a href="login">登录</a></li>
				</ul>
			</c:otherwise>
		</c:choose>
	</div>
</div>