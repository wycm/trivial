<%@ page contentType="text/html;charst=UTF-8" pageEncoding="UTF-8" %>
<html>
 <head>
	 <%@ include file="../path.jsp" %>
  	<title><c:out value="${userSider.user.username}"/> 的主页</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="shortcut icon" href="file/pic/blog.ico"/>
	<script type="text/javascript" src="file/js/jquery.min.js"></script>
	<script type="text/javascript" src="file/js/mynavmenu.js"></script>
	<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
   <link href="file/css/style.css" rel="stylesheet" type="text/css">
	<style >
   		#user-all{
			width:100%;
			height:auto;
			background: url(file/pic/skin/<c:out value="${userSider.user.bloginfo.background}"/>) repeat;
		}
   </style>
</head>
<body style="background:#464646;">
	<%@ include file="./pagetop.jsp" %>
	<div id="user-all">
	<div id="user-header">
		<div id="blog_title">
            <h2>
                <a href="user/<c:out value="${userSider.user.url}"/>"><c:out value="${userSider.user.username}"/> 的博客</a></h2>
            <h3><c:out value="${userSider.user.bloginfo.intro}"/></h3>
            <div class="clear">
            </div>
        </div>
	</div>
	<div id="wrapper" class="clearfix">
	<div class="gap"></div>
	<div id="breadcrumbs" class="con_box clearfix">
				<div class="bcrumbs"><strong><a href="<%=request.getContextPath() %>/index" title="返回首页">home</a></strong>
				<a><c:out value="${userSider.user.username}"/> 的全部文章</a>
				</div>
	</div> 
   <div id="art_container clearfix"> 
    <div id="art_main" class="fl"> 
<c:forEach items="${userSider.user.articles}" var="item">
    <%@ include file="../articleintro.jsp" %>
 </c:forEach>
    </div> 
    <!-- art_main end--> 
     <%@ include file="./sider.jsp" %>
   </div> 
</div>
<%@ include file="../bottom.jsp" %>
</div>
</body>
</html>