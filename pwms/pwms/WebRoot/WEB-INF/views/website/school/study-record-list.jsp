<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${type}</title>
<%@ include file="../path.jsp" %>
<link href="res/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="res/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
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
		<a class="maincolor" href="../index.html">首页</a>
		<span class="c-999 en">&gt;</span><a class="maincolor" href="school">网上党校</a>
		<span class="c-999 en">&gt;</span>${type}
		</nav>
	</div>
	<div class="row c1 ml-20 mt-10 mr-20">
	<%@ include file="siderbar.jsp"%>
	<div class="col-xs-12 col-sm-10">
		<div class="row c1 ml-10">
			<div class="panel panel-danger radius">
				<div class="panel-header">${type}</div>
				<div class="panel-body">
					<div class="row cl">
		<table width="98%" align="center" class="col-xs-12 col-sm-12 table table-border table-bordered table-hover">
			<tbody>
			<tr class="title">
			  <th class="text-c">课程</th>
			  <th class="text-c" width="20%">开始时间</th>
			  <th class="text-c" width="20%">结束时间</th>
			  <th class="text-c" width="20%">时长（分钟）</th>
			</tr>
		    <tr class="text-c">
		      <td class="splittd">关键在党，关键在人</td>
			  <td>2016-1-21 20:50:00</td>
			  <td>2016-1-21 20:58:00</td>
			  <td>8</td>
		    </tr>
		    <tr class="text-c">
		      <td class="splittd">关键在党，关键在人</td>
			  <td>2016-1-21 20:50:00</td>
			  <td>2016-1-21 20:58:00</td>
			  <td>8</td>
		    </tr>
		    <tr class="text-c">
		      <td class="splittd">关键在党，关键在人</td>
			  <td>2016-1-21 20:50:00</td>
			  <td>2016-1-21 20:58:00</td>
			  <td>8</td>
		    </tr>
		    <tr class="text-c">
		      <td class="splittd">关键在党，关键在人</td>
			  <td>2016-1-21 20:50:00</td>
			  <td>2016-1-21 20:58:00</td>
			  <td>8</td>
		    </tr>
		    <tr class="text-c">
		      <td class="splittd">关键在党，关键在人</td>
			  <td>2016-1-21 20:50:00</td>
			  <td>2016-1-21 20:58:00</td>
			  <td>8</td>
		    </tr>
		    <tr class="text-c">
		      <td class="splittd">关键在党，关键在人</td>
			  <td>2016-1-21 20:50:00</td>
			  <td>2016-1-21 20:58:00</td>
			  <td>8</td>
		    </tr>
		    <tr class="text-c">
		      <td class="splittd">关键在党，关键在人</td>
			  <td>2016-1-21 20:50:00</td>
			  <td>2016-1-21 20:58:00</td>
			  <td>8</td>
		    </tr>
		    <tr class="text-c">
		      <td class="splittd">关键在党，关键在人</td>
			  <td>2016-1-21 20:50:00</td>
			  <td>2016-1-21 20:58:00</td>
			  <td>8</td>
		    </tr>
			</tbody>
	</table>
    				</div>
				</div>
		</div>
		</div>
	</div>
	</div>
</div>
<%@ include file="../bottom.jsp" %>
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script>
<script type="text/javascript">
$(document).ready(function() { 
	$(".upright-menu li").each(function(){
		if($(this).find("a").text() == $("title").text()){
			$(this).attr("class","current");
		}
	});
});
</script>
</body>
</html>