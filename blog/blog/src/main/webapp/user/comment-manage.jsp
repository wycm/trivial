<%@ page contentType="text/html;charst=UTF-8" pageEncoding="UTF-8" %>
<html>
 <head>
     <%@ include file="../path.jsp" %>
  	<title>
        <c:choose>
  		<c:when test="${sort!=null&&sort!=\"all\"}">
                待审核的评论
        </c:when>
        <c:otherwise>
               	全部评论
        </c:otherwise>
        </c:choose>
  	</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="shortcut icon" href="file/pic/blog.ico"/>
	<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
	<script type="text/javascript" src="file/js/jquery_cmhello.js"></script>
	<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
   <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
   <link href="file/css/style.css" rel="stylesheet" type="text/css">
   <link rel="stylesheet" type="text/css" href="file/css/common.css"/>
	<link rel="stylesheet" type="text/css" href="file/css/main.css"/>
	<script src="admin/js/comment-manage.js"></script>
	<style >
   		#user-all{
			width:100%;
			height:auto;
			background: url(file/pic/skin/<c:out value="${sessionScope.user.bloginfo.background}"/>) repeat;
		}
   </style>
</head>
<body style="background:#464646;">
	<%@ include file="./pagetop.jsp" %>
	<div id="user-all">
	<div id="user-header">
		<div id="blog_title"> 
            <h2>
                <a href="u/<c:out value="${sessionScope.user.id}"/>"><c:out value="${sessionScope.user.username}"/> 的博客</a></h2>
            <h3><c:out value="${sessionScope.user.bloginfo.intro}"/></h3>
            <div class="clear">
            </div>
        </div>
	</div>
	<div id="wrapper" class="clearfix">
	<div class="gap"></div>
	<div id="breadcrumbs" class="con_box clearfix">
				<div class="bcrumbs"><strong><a href="index" title="返回首页">home</a></strong>
				<a href="<c:out value="${sessionScope.user.id}"/>"><c:out value="${sessionScope.user.username}"/></a>
				<a>个人中心</a>
				<a>评论管理</a>
                    <c:choose>
				<c:when test="${sort!=null&&sort!=\"all\"}">
                       <a>待审核的评论</a>       
                </c:when>
                <c:otherwise>
                	<a>全部评论</a>
                </c:otherwise>
                    </c:choose>
				</div>
	</div> 
   <div id="art_container clearfix"> 
    <div id="user_art_main" class="fl"> 
    	<div class="main-wrap">
    	<div class="gap"></div>
		<%@include file="navigation.jsp"%>
        <div class="search-wrap">
            <div class="search-content">
                <form action="CommentManage" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择分类:</th>
                            <td>
                                <select name="sort" id="">
                                    <option value="all">全部评论</option>
                                    <option value="notauditing"
                                    <c:if test="${sort!=null&&sort!=\"all\"}">
                                    	selected="selected"
                                    </c:if>
                                    >待审核评论</option>
                                </select>
                            </td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a id="messageBatchThrough" href="javascript:void(0)">批量通过</a>
                        <a id="messageBatchDel" href="javascript:void(0)">批量删除</a>
                        <a id="updateOrd" href="./CommentManage.jsp<c:if test="${sort!=null&&sort!=\"all\"}">?sort</c:if>">刷新</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input id="allMessageChoose" name="" type="checkbox"></th>
                            <th width="8%">评论人</th>
                            <th>评论内容</th>
                            <th width="18%">评论时间</th>
                            <th width="12%">通过状态</th>
                            <th width="12%">审核状态</th>
                            <th width="25%">操作</th>
                        </tr>
                         <c:forEach items="${commentList}" var="item">
                        <tr id="tr_<c:out value="${item.id}"/>">
                            <td class="tc"><input name="messageIds" value="<c:out value="${item.id}"/>" type="checkbox"></td>
                            <td><c:out value="${item.user.username}"/></td>
                            <td><c:out value="${item.content}"/></td>
                            <td><c:out value="${item.time}"/></td>
                            <td id="tr_<c:out value="${item.id}"/>-through"><c:out value="${item.throughFlag}"/></td>
                            <td id="tr_<c:out value="${item.id}"/>-auditing"><c:out value="${item.auditingFlag}"/></td>
                            <td>
                                <a class="link-auditing-success" href="javascript:void(0)" onclick="auditing(<c:out value="${item.id}"/>,1);">审核通过</a>
                                <a class="link-auditing-failure" href="javascript:void(0)" onclick="auditing(<c:out value="${item.id}"/>,0);">审核失败</a>
                                <a class="link-del" href="javascript:void(0)" onclick="deleteMessage(<c:out value="${item.id}"/>);">删除</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                    <div class="list-page" rows=""></div> 
                </div>
            </form>
        </div>
    </div>
    </div> 
   </div> 
</div>
<%@ include file="../bottom.jsp" %>
</div>
</body>
</html>