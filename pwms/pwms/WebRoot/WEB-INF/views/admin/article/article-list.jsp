<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>文章列表</title> 
</head> 
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 文章管理 <span class="c-gray en">&gt;</span> 文章列表 <a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="javascript:;" onclick="batchDelArticle()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> <a class="btn btn-primary radius" onclick="article_add('添加文章','admin/article/article-add.html')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加文章</a></span> <span class="r">共有数据：<strong>54</strong> 条</span> </div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="80">ID</th>
					<th>标题</th>
					<th width="80">分类</th>
					<th width="80">来源</th>
					<th width="120">更新时间</th>
					<th width="75">浏览次数</th>
					<th width="120">操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${aList}" var="item">
				<tr class="text-c">
					<td><input type="checkbox" value="${item.id}" name="id"></td>
					<td>${item.id}</td>
					<td><a href="${item.articletype.pArticletype.linkname}/${item.articletype.linkname}/${item.id}.html" target="_blank">${item.title}</a></td>
					<td>
						<a href="${item.articletype.pArticletype.linkname}/${item.articletype.linkname}/list.html" target="_blank">${item.articletype.value}</a>
					</td>
					<td>admin</td>
					<td>${item.dateline}</td>
					<td>21212</td>
					<td class="f-14 td-manage"><a style="text-decoration:none" class="ml-5" onClick="article_edit('文章修改','admin/article/article-modify?id=${item.id}','10001')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none" class="ml-5" onClick="article_del(this,${item.id})" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<script type="text/javascript" src="res/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="res/lib/layer/1.9.3/layer.js"></script> 
<script type="text/javascript" src="res/lib/My97DatePicker/WdatePicker.js"></script> 
<script type="text/javascript" src="res/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script>
<script type="text/javascript">
$('.table-sort').dataTable();
/*文章-添加*/
function article_add(title,url,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*文章-编辑*/
function article_edit(title,url,id,w,h){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}
/*文章-删除*/
function article_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type:"POST",
			url:"admin/article/delete?id=" + id,
			success:function(msg){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
	        },
			error:function(msg){
				layer.msg('删除失败!',{icon:1,time:1000});
			}
		});
	}); 
} 
function batchDelArticle(){
	var idList = new Array();
	$("[name='id']").each(function(){
		if($(this).is(":checked")){
			idList.push($(this).val());
		}
	});
	if(idList.length == 0){
		layer.msg('未选择文章',{icon:1,time:1000});
		return ;
	}
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type:"POST",
			url:"admin/article/batchDelete",
			dataType:"text",
			data:{"idList":idList},
			success:function(msg){
				for(var i = 0;i < idList.length;i++){
					$(":input[value='" + idList[i] + "']").parent().parent().remove();
					
				}
				layer.msg('批量删除成功!',{icon:1,time:1000});
				
	        },
			error:function(msg){
				layer.msg('删除失败!',{icon:2,time:3000});
			}
		});
	});
}
</script> 
</body>
</html>