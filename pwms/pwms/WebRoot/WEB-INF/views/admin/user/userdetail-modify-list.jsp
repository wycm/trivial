<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../path.jsp" %>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
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
<title>用户信息修改管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页  <span class="c-gray en">&gt;</span> 用户信息修改管理 <span class="c-gray en">&gt;</span> 用户信息修改列表<a class="btn btn-success radius r mr-20" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="pd-20">
	<div class="text-c"> 日期范围：
		<input type="text" onfocus="WdatePicker({maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}'})" id="datemin" class="input-text Wdate" style="width:120px;">
		-
		<input type="text" onfocus="WdatePicker({minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})" id="datemax" class="input-text Wdate" style="width:120px;">
		<input type="text" class="input-text" style="width:250px" placeholder="输入会员名称、电话、邮箱" id="" name="">
		<button type="submit" class="btn btn-success radius" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜用户</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"><a href="user/exportxls" class="btn btn-primary radius">导出用户详细信息记录表</a> <a href="javascript:;" onclick="member_add('添加奖惩登记记录','admin/user/reward-punish-add.html','','510')" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe600;</i> 添加</a></span> <span class="r">共有数据：<strong>88</strong> 条</span> </div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="80">ID</th>
				<th width="100">姓名</th>
				<th width="100">学号</th>
				<th width="90">民族</th>
				<th width="150">籍贯</th>
				<th width="130">类型</th>
				<th width="70">状态</th>
				<th width="200">审核信息</th>
				<th width="100">详细信息</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${udmList}" var="item"> 
			<tr class="text-c">
				<td><input type="checkbox" value="1" name=""></td>
				<td>${item.id}</td>
				<td><u style="cursor:pointer" class="text-primary" onclick="member_show('${item.name}','user-show/${item.userId}','10001','360','400')">${item.name}</u></td>
				<td>${item.studentId}</td>
				<td>${item.nation}</td>
				<td>${item.nativePlace}</td>
				<td>
				<c:choose>  
				   <c:when test="${userinfo.type == 1}">  
				      	积极分子
				   </c:when>  
				   <c:otherwise> 
				     	党员
				   </c:otherwise>  
				</c:choose>
				</td>
				<td class="td-status"><span class="label label-success radius">
					<c:choose>  
				   <c:when test="${userinfo.auditingFlag == 0 || userinfo.auditingFlag == null}">  
				      	待审核
				   </c:when>  
				   <c:otherwise> 
				     	已审核
				   </c:otherwise>  
				</c:choose>
				</span></td>
				<td>
					<div class="row cl">
				      <div class="formControls col-5" style="width:100%">
				        <textarea style="width:100%;height:50px" name="msg" cols="" rows="" class="textarea"  placeholder="说明" dragonfly="true" onKeyUp="textarealength(this,50)"></textarea>
				        <p class="textarea-numberbar"><em class="textarea-length">0</em>/50</p>
				      </div>
				    </div>
				</td>

				<td><u style="cursor:pointer" class="text-primary" onclick="member_add('${item.name}','userdetail-modify-show/${item.id}','500','')">查看详细信息</u></td>
				<td class="td-manage">
					<a style="text-decoration:none" onClick="auditing_fail(this,${item.id})" href="javascript:;" title="审核不通过"><i class="Hui-iconfont">&#xe6dd;</i></a>
					<a style="text-decoration:none" onClick="auditing_through(this,${item.id})" href="javascript:;" title="审核通过"><i class="Hui-iconfont">&#xe6e1;</i></a>
					<a title="删除" href="javascript:;" onclick="member_del(this,${item.id})" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</div>
<script type="text/javascript" src="res/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="res/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="res/lib/laypage/1.2/laypage.js"></script> 
<script type="text/javascript" src="res/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script> 
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable();
});
/*用户-添加*/
function member_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*审核-不通过*/
function auditing_fail(obj,id){
	layer.confirm('确认要拒绝通过吗？',function(index){
		var message = $(obj).parents("tr").find("[name='msg']").val();
		$.ajax({
			type:"POST",
			url:"admin/user/userdetail-modify/" +id +"/0?msg=" + message,
			success:function(msg){
				layer.msg('已拒绝通过!',{icon: 5,time:1000});
				$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已拒绝通过</span>');
            }
		});
	});
}

/*审核-通过*/
function auditing_through(obj,id){
	layer.confirm('确认要审核通过吗？',function(index){
		var message = $(obj).parents("tr").find("[name='msg']").val();
		$.ajax({
			type:"POST",
			url:"admin/user/userdetail-modify/" +id +"/1?msg=" + message,
			success:function(msg){
				layer.msg('已通过!',{icon: 6,time:1000});
				$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已通过</span>');
            }
		});
	});
}
/*用户-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}
/*密码-修改*/
function change_password(title,url,id,w,h){
	layer_show(title,url,w,h);	
}
/*用户-删除*/
function member_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
        $.ajax({
            type:"DELETE",
            url:"user/rewOrPun/" + id,
            success:function(msg){
            	layer.msg('已删除!',{icon:1,time:1000});
            }
        });
	});
}
</script> 
</body>
</html>