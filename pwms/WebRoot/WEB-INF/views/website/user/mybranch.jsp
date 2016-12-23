<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户详细信息</title>
<%@ include file="../path.jsp" %>
<link href="res/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="res/website/style/base.css" rel="stylesheet" type="text/css" />
<link href="res/website/style/style1.css" rel="stylesheet" type="text/css" />
<link href="res/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="../header.jsp"%>
<div class="page-main">
	<div class="nav radius">
		<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i>
		<a class="maincolor" href="../index.html">首页</a>
		<span class="c-999 en">&gt;</span>我的支部
		</nav>
	</div>
	<div class="branch">
		<div class="panel panel-danger radius">
				<div class="panel-header">支部信息</div>
				<div class="panel-body">
					<div class="row cl font-bold">
						<div class="col-1"></div>
				      <label class="form-label col-1">支部名称：</label>
				      <div class="formControls col-2">
				      		${branch.branchName}
				      </div>
    					<div class="col-1"></div>
				      <label class="form-label col-1" >支部负责人：</label>
				      <div class="formControls col-2">
				      		王洋
				      </div>
    					<div class="col-1"></div>
				      <label class="form-label col-1" >联系电话：</label>
				      <div class="formControls col-2">
				      		13088280860
				      </div>
    				</div>
				</div>
		</div>
	</div>
	<div class="branch">
		<div class="panel panel-danger radius">
				<div class="panel-header">支部成员</div>
				<div class="panel-body">
					<div class="row cl">
					<c:forEach items="${bmList}" var="item">
				      <label class="form-label col-2">${item.user.name}</label>
				    </c:forEach>
    				</div>
				</div>
		</div>
	</div>
</div>
<%@ include file="../bottom.jsp" %>
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script>
<script type="text/javascript">
$(function(){
	$("#form-reward-punish-add").Validform({
		tiptype:2,
		callback:function(form){
			form[0].submit();
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
	$("#submit").click(function(){
		$("#form-reward-punish-add").submit();
		window.close();
	});
});
</script>
</body>
</html>