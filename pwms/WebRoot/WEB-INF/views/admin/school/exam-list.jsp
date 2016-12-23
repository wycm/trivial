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
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,exam-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="res/lib/html5.js"></script>
<script type="text/javascript" src="res/lib/respond.min.js"></script>
<script type="text/javascript" src="res/lib/PIE_IE678.js"></script>
<![endif]-->
<link href="res/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="res/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="res/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>所有考试列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页  <span class="c-gray en">&gt;</span> 党校管理 <span class="c-gray en">&gt;</span> 考试列表<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> <a href="javascript:;" onclick="exam_add('添加考试','admin/school/exam-add.html','','400')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加考试</a></span> <span class="r">共有数据：<strong><c:out value="${fn:length(examList)}"></c:out></strong> 条</span> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="80">ID</th>
				<th width="100">考试名称</th>
				<th width="200">单个题的分值</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${examList}" var="item"> 
			<tr class="text-c">
				<td><input type="checkbox" value="${item.id}" name=""></td>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.singleScore}</td>
				<td class="td-manage">
					<a title="考试修改" href="javascript:;" onclick="exam_edit('考试修改','admin/school/exam-modify/${item.id}','4','','510')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>
					<a style="text-decoration:none" class="ml-5" onClick="exam_del(this,${item.id})" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
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
/*考试-添加*/
function exam_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*考试-查看*/
function exam_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*考试-编辑*/
function exam_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*考试-删除*/
function exam_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type:"POST",
			url:"admin/school/examDelete?id=" + id,
			success:function(msg){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
	        },
			error:function(msg){
				layer.msg('删除失败!',{icon:1,time:2000});
			}
		});
	});
}
</script> 
</body>
</html>