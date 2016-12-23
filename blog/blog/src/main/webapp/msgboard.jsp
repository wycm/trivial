<%@ taglib prefix="height" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charst=UTF-8" pageEncoding="UTF-8" %>
<html> 
<head>
		<%@ include file="path.jsp" %>
		<title>留言板</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="shortcut icon" href="file/pic/blog.ico"/>
		<script type="text/javascript" src="file/js/jquery.min.js"></script>
		<script type="text/javascript" src="file/js/jquery_cmhello.js"></script>
   		<script src="file/js/message.js"></script>
   		<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   		<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
   		<link href="file/css/style.css" rel="stylesheet" type="text/css">
   		<link rel="stylesheet" type="text/css" href="file/css/login.css" /> 
		<style type="text/css">
			body {background: #606060;}
			.name-font{font-size:12px;color:red;}
			.href-font{font-size:16px}
			.href-time{color:rgb(153,153,153);}
			a.page{text-decoration:underline;}
			.buttom a:link {
				color:white;
				text-decoration:underline;
				}
			.buttom	a:visited {
				color:white;
				text-decoration:none;
				}
			.buttom	a:hover {
				color:red;
				text-decoration:none;
				}
			.buttom	a:active {
				color:blue;
				text-decoration:none;
				}
		</style>
</head>  
<body>
<%@ include file="header.jsp" %>
<div id="wrapper" class="clearfix">
		<div class="gap"></div>
			<div id="breadcrumbs" class="con_box clearfix">
				<div class="bcrumbs"><strong><a href="./index" title="返回首页">home</a></strong>
				<a rel="category tag">留言板</a>
				</div>
			</div>
 		<div id="art_container clearfix">
		<div class="showmessage">
	<ul class="left-right-clear">
	<c:forEach items="${parMsgs}" var="item">
		<c:if test="${item.throughFlag==1}">
			<li class="ds-post">
			<div class="ds-post-self"  message-id="<c:out value="${item.id}"/>">
				<div class="ds-avatar">
					<a href="user/<c:out value="${item.user.url}"/>"><img src="upload/headpic/<c:out value="${item.user.headpicname}"/>" alt="picture"></a>
				</div>
				<div class="ds-comment-body">
					<div class="ds-comment-header">
						<a class="ds-user-name ds-highlight" data-qqt-account="" href="http://t.qq.com/zouzijian" onclick="this.href='http://yangqq.duoshuo.com/user-url/?user_id=2302622';" rel="nofollow" target="_blank" data-user-id="2302622">
							<c:out value="${item.user.username}"/>
						</a>
					</div>
					<div class="ds-comment-content">
						<p></p>
						<pre><c:out value="${item.content}"/></pre>
						<p></p>
					</div>
					<div class="ds-comment-footer ds-comment-actions"><span class="ds-time" title="<c:out value="${item.time}"/>"><c:out value="${item.time}"/></span>
				<a class="ds-post-reply" id="<c:out value="${item.id}"/>" href="javascript:void(0);" onclick="reply(this)">
					<span class="ds-icon ds-icon-reply"></span>回复
				</a>
				<a  class="ds-post-likes" href="javascript:void(0);" message-id="<c:out value="${item.id}"/>" onclick="light(this)">
					<span class="ds-icon ds-icon-like"></span>顶(<h id="light-count_<c:out value="${item.light}"/>"><c:out value="${item.light}"/></h>)
				</a>
				</div>
					<div class="ds-post-self" style="display:none" id="<c:out value="${item.id}"/>">
				<div class="ds-avatar">
				<c:choose>
				<c:when test="${sessionScope.user == null}">
					<img src="upload/headpic/default_head.jpg">
				</c:when>
				<c:otherwise>
					<a href="user/<c:out value="${sessionScope.user.url}"/>"><img src="upload/headpic/<c:out value="${sessionScope.user.headpicname}"/>"/></a>
				</c:otherwise>
				</c:choose>
				</div>
				<div class="ds-comment-body">
					<div class="ds-comment-header">
					<form method="post" action="AddMessageServlet">
						<input type="hidden" name="parent_id" value="<c:out value="${item.id}"/>">
						<input type="hidden" name="reply_id" value="<c:out value="${item.id}"/>">
						<p><input type="hidden" id="username" name="username" value="" size="22" tabindex="1" onblur="validateUsername(this)"><label></label><label id="username-hint" style="color:red;"></label></p>
						<p><input type="hidden" id="email" name="email" value="" size="22" tabindex="1" onblur="validateEmail(this)"><label></label><label id="email-hint" style="color:red;"></label></p>
						<c:choose>
						<c:when test="${sessionScope.user == null}">
							<textarea readonly="readonly" id="textarea" name="textarea" class="form-control" placeholder="你还没有登录，请登录后留言" onblur="validateTextarea(this)"></textarea>
						</c:when>
						<c:otherwise>
							<textarea id="textarea" name="textarea" class="form-control" placeholder="说点什么吧…" onblur="validateTextarea(this)"></textarea>
						</c:otherwise>
						</c:choose>
						<p></p>
						<p><input name="reply-submit" class="comment-reply-button"  type="button" name="submit" value="回复" onclick="submitReply(this)"/>
						<label id="textarea-hint" style="color:red;"></label></p>
					</form>
					</div>
				</div>
			</div>
			
			<div class="ds-post-self"  comment-id="">
		<c:if test="%{chiMessages!=null}">
			<c:forEach items="${item.chiMessages}" var="item">
			<c:if test="%{throughFlag==1}">
				<div class="ds-avatar">
					<a href="user/<c:out value="${item.user.url}"/>"><img src="upload/headpic/<c:out value="${item.user.headpicname}"/>" alt="picture"></a>
				</div>
				<div class="ds-comment-body">
					<div class="ds-comment-header">
						<a class="ds-user-name ds-highlight" rel="nofollow" target="_blank">
						<c:out value="${item.user.username}"/>
						</a>
						&nbsp&nbsp回复&nbsp&nbsp
						<a class="ds-user-name ds-highlight" rel="nofollow" target="_blank">
						<c:out value="${item.replyMessage.user.username}"/>
						</a>
					</div>
					<p><pre><c:out value="${item.content}"/></pre></p>
					<div class="ds-comment-footer ds-comment-actions">
					<span class="ds-time" datetime="2014-04-11T15:46:13+08:00" title="">
						<c:out value="${item.time}"/>
					</span>
				<a class="ds-post-reply" id="" href="javascript:void(0);" onclick="reply(this)">
					<span class="ds-icon ds-icon-reply"></span>回复
				</a>
				<a  class="ds-post-likes" href="javascript:void(0);" message-id="<c:out value="${item.id}"/>" onclick="light(this)">
					<span class="ds-icon ds-icon-like"></span>顶(<h><c:out value="${item.light}"/></h>)
				</a>
				</div>
			<div class="ds-post-self" style="display:none">
				<div class="ds-avatar">
					<c:choose>
					<c:when test="${sessionScope.user == null}">
					<img src="upload/headpic/default_head.jpg">
					</c:when>
					<c:otherwise>
						<a href="user/<c:out value="${sessionScope.user.url}"/>"><img src="upload/headpic/<c:out value="${sessionScope.user.headpicname}"/>"></a>
					</c:otherwise>
					</c:choose>
				</div>
				<div class="ds-comment-body">
					<div class="ds-comment-header">
					<form method="post" action="AddMessageServlet">
						<input type="hidden" name="parent_id" value="<c:out value="${item.parMessage.id}"/>">
						<input type="hidden" name="reply_id" value="$<c:out value="${item.id}"/>">
						<p><input type="hidden"  name="username" value="" size="22" tabindex="1" onblur="validateUsername(this)"><label></label><label id="reply-username-hint" style="color:red;"></label></p>
						<p><input type="hidden"  name="email" value="" size="22" tabindex="1" onblur="validateEmail(this)"><label></label><label id="reply-email-hint" style="color:red;"></label></p>
						<c:choose>
						<c:when test="${sessionScope.user == null}">
							<textarea readonly="readonly" id="textarea" name="textarea" class="form-control" placeholder="你还没有登录，请登录后留言" onblur="validateTextarea(this)"></textarea>
						</c:when>
						<c:otherwise>
							<textarea id="textarea" name="textarea" class="form-control" placeholder="说点什么吧…" onblur="validateTextarea(this)"></textarea>
						</c:otherwise>
						</c:choose>
						<p></p>
						<p><input class="comment-reply-button" comment-id="<c:out value="${item.id}"/>" name="reply-submit"  type="button" value="回复" onclick="submitReply(this)"/>
						<label id="textarea-hint" style="color:red;"></label></p>
					</form>
					</div>
				</div>
			</div>
				</div>
				</c:if>
				</c:forEach>
		</c:if>
			</div>
				</div>
			</div> 
		</li>
		</c:if>
	</c:forEach>
	<li class="ds-post" id="messageboard">
		<div class="ds-post-self">
				<div class="ds-avatar">
					<c:choose>
					<c:when test="${sessionScope.user != null}">
						<a href="user/<c:out value="${sessionScope.user.url}"/>"><img src="upload/headpic/<c:out value="${sessionScope.user.headpicname}"/>"/></a>
					</c:when>
					<c:otherwise>
						<img src="upload/headpic/default_head.jpg">
					</c:otherwise>
					</c:choose>
				</div>
				<div class="ds-comment-body">
					<div class="ds-comment-header">
					<form method="post" action="AddMessageServlet">
						<p><input type="hidden" id="message-username" name="username" value="" size="22" tabindex="1"><label></label><label id="message-username-hint" style="color:red;"></label></p>
						<p><input type="hidden" id="message-email" name="email" value="" size="22" tabindex="1"><label></label><label id="message-email-hint" style="color:red;"></label></p>
						<c:choose>
						<c:when test="${sessionScope.user == null}">
							<textarea readonly="readonly" id="message-textarea" name="textarea" class="form-control" placeholder="你还没有登录，请登录后留言"></textarea>
						</c:when>
						<c:otherwise>
							<textarea id="message-textarea" name="textarea" class="form-control" placeholder="说点什么吧…"></textarea>
						</c:otherwise>
						</c:choose>
						<p></p>
						<p><input name="submit" class="comment-reply-button" id="message-button" type="button" name="submit" value="提交留言"/></p>
						<label id="message-textarea-hint" style="color:red;"></label></p>
					</form>
					</div>
				</div>
			</div>
	</li>
	</ul>
</div>
 			
<%@ include file="./sider.jsp" %>
</div> 
</div>
<%@ include file="./bottom.jsp"%>  
<div style="height:height:50px;">
</div>
</body>
</html>