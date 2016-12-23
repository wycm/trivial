<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../path.jsp" %>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,video_course-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="../lib/html5.js"></script>
<script type="text/javascript" src="../lib/respond.min.js"></script>
<script type="text/javascript" src="../lib/PIE_IE678.js"></script>
<![endif]-->
<link href="res/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="res/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="res/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>所有课程列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页  <span class="c-gray en">&gt;</span> 支部管理 <span class="c-gray en">&gt;</span> 支部列表<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> <a href="javascript:;" onclick="video_course_add('添加视频课程','admin/school/video-course-add.html','','400')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加视频课程</a></span> <span class="r">共有数据：<strong><c:out value="${fn:length(courseList)}"></c:out></strong> 条</span> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="80">ID</th>
				<th width="100">课程名称</th>
				<th width="200">课程学习所需时间（单位：分钟）</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${courseList}" var="item"> 
			<tr class="text-c">
				<td><input type="checkbox" value="${item.id}" name=""></td>
				<td>${item.id}</td>
				<td>${item.title}</td>
				<td>${item.explian}</td>
				<td class="td-manage">
					<a title="课程修改" href="javascript:;" onclick="video_course_edit('课程修改','admin/school/video-course-modify/${item.id}','4','','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</div>
<script type="text/javascript" src="res/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="res/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="res/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script> 
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable();
});
/*视频课程-添加*/
function video_course_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*视频课程-查看*/
function video_course_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*视频课程-编辑*/
function video_course_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*视频课程-删除*/
function video_course_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}
</script> 
</body>
</html>