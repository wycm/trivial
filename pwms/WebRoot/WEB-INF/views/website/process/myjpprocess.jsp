<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>入党流程</title>
<%@ include file="../path.jsp" %>
<link href="res/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="res/website/style/base.css" rel="stylesheet" type="text/css" />
<link href="res/website/style/style1.css" rel="stylesheet" type="text/css" />
<link href="res/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="../header.jsp"%>
<div class="page-main pb-20">
<div class="nav radius">
	<nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i>
	<a class="maincolor" href="/pwms">首页</a>
	<span class="c-999 en">&gt;</span><a class="maincolor" href="process">入党流程</a>
	<span class="c-999 en">&gt;</span>我的流程
</nav>
</div>
<div class="jpprocess-wrapper">
	<div class="seven steps">
		  <span class="step" step="1">1.递交入党申请</span>
		  <span class="step" step="2">2.团员推优</span>
		  <span class="step" step="3">3.入党积极分子</span>
		  <span class="step" step="4">4.参加党校学习</span>
		  <span class="step" step="5">5.成为发展对象</span>
		  <span class="step" step="6">6.成为预备党员</span>
		  <span class="step" step="7">7.转为正式党员</span>
	</div>
	<div class="row c1 mt-40 ml-20 mr-20">
		<c:forEach items="${userProcessList}" var="item">
			<div class="step-detail" con="${item.processId}" style="display:none">
				<div class="row cl mt-10">
						<div class="col-xs-12 col-sm-1 text-right">
						进度：
						</div>
						<div class="col-xs-12 col-sm-11">
							
						</div>
				</div>
				<div class="row cl mt-10">
						<div class="col-xs-12 col-sm-1 text-right">
						姓名：
						</div>
						<div class="col-xs-12 col-sm-11">
							${sessionScope.user.name}
						</div>
				</div>
				<div class="row cl mt-10">
						<div class="col-xs-12 col-sm-1 text-right">
						学号：
						</div>
						<div class="col-xs-12 col-sm-11">
							${sessionScope.user.stuOrJobid}
						</div>
				</div>
				<div class="row cl mt-10">
						<div class="col-xs-12 col-sm-1 text-right">
						通过时间：
						</div>
						<div class="col-xs-12 col-sm-11">
							${item.dateline}
						</div>
				</div>
				<div class="row cl mt-10">
						<div class="col-xs-12 col-sm-1 text-right">
						成绩：
						</div>
						<div class="col-xs-12 col-sm-11">
							${item.grade}
						</div>
				</div>
				<div class="row cl mt-10">
						<div class="col-xs-12 col-sm-1 text-right">
						感悟：
						</div>
						<div class="col-xs-12 col-sm-11">
							${item.feeling}
						</div>
				</div>
				<div class="row cl mt-10">
						<div class="col-xs-12 col-sm-1 text-right">
						说明：
						</div>
						<div class="col-xs-12 col-sm-11">
							${item.explain}
						</div>
				</div>
			</div>
		</c:forEach>
</div>
</div>
</div>
<%@ include file="../bottom.jsp" %>
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script>
<script type="text/javascript">
var process = new Array("递交入党申请","团员推优","入党积极分子","参加党校学习","成为发展对象","成为预备党员","转为正式党员");
var jdCount = ${userProcessList.size()};//已完成的进度数
$(function(){
	//显示当前进度详细信息
	$(".step-detail:last").show();
	var i = 0;
	//设置已完成的进度条
	$("span.step").each(function(){
		if(++i <= jdCount){
			$(this).attr("class","active step");	
		}
	});
	i = 0;
	//设置进度名
	$(".step-detail").each(function(){
		$(this).children().first().find(".col-sm-11").text(process[i++]);
	});
	$(".step.active").mousedown(function(){
		$(".step-detail").each(function(){
			$(this).hide();
		});
		$(this).attr("class","active step");
		var v = $(this).attr("step");
		$("[con='" + v +"']").show();
	});
}); 
</script>
</body>
</html>