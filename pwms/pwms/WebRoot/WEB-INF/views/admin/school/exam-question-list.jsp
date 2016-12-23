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
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<script type="text/javascript" src="lib/PIE_IE678.js"></script>
<![endif]-->
<link href="res/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="res/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="res/css/style.css" rel="stylesheet" type="text/css" />
<link href="res/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>考试题目列表</title> 
</head> 
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 考试题目管理 <span class="c-gray en">&gt;</span> 考试题目列表 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> <a class="btn btn-primary radius" onclick="exam_question_add('批量添加考试题目','admin/school/exam-question-add.html')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 批量添加考试题目</a></span> <span class="r">共有数据：<strong><c:out value="${fn:length(eqList)}"></c:out> </strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th>ID</th>
					<th>examId</th>
					<th>问题</th>
					<th>选项A</th>
					<th>选项B</th>
					<th>选项C</th>
					<th>选项D</th>
					<th>答案</th>
					<th width="120">操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${eqList}" var="item">
				<tr class="text-c">
					<td><input type="checkbox" value="${item.id}" name="id"></td>
					<td>${item.id}</td>
					<td>${item.examId}</td>
					<td>${item.question}</td>
					<td>${item.optionA}</td>
					<td>${item.optionB}</td>
					<td>${item.optionC}</td>
					<td>${item.optionD}</td>
					<td>${item.answer}</td>
					<td class="f-14 td-manage"><a style="text-decoration:none" class="ml-5" onClick="exam_question_edit('考试题目修改','admin/school/exam-question-modify/${item.id}','800','500')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="exam_question_del(this,${item.id})" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
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
$(document).ready(function() {
	$('.table-sort').dataTable();
});
/*考试题目-添加*/
function exam_question_add(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*考试题目-编辑*/
function exam_question_edit(title,url,w,h){
	
	layer_show(title,url,w,h);
}
/*考试题目-删除*/
function exam_question_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type:"POST",
			url:"admin/school/examQuestionDelete?id=" + id,
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