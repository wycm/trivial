<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
<%@ include file="path.jsp" %>
<link href="res/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="res/website/style/base.css" rel="stylesheet" type="text/css" />
<link href="res/website/style/style1.css" rel="stylesheet" type="text/css" />
<link href="res/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="res/website/js/js.js"></script>
</head>
<body>
<%@ include file="header.jsp"%>
<div class="register-main">
<div class="nav radius">
	<nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i>
	<a class="maincolor" href="/">首页</a>
	<span class="c-999 en">&gt;</span>注册
</nav>
</div>
<div class="register-wrapper">
	<div class="pd-20">
  <form action=""  method="post" class="form form-horizontal" id="form-reward-punish-add">
    <div class="row cl">
      <label class="form-label col-3"></label>
      <div class="formControls col-5">
        <input type="text" class="input-text radius size-L" value="" placeholder="请输入身份证号码" id="idcard" name="idcard" datatype="idcard" nullmsg="身份证不能为空" errormsg="身份证格式不正确">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="filling"></div>
    <div class="row cl">
      <label class="form-label col-3 "></label>
      <div class="formControls col-5">
        <input type="text" class="input-text radius size-L" value="" placeholder="请输入学号" id="stuid" name="stuid"  datatype="stuid" nullmsg="学号不能为空" errormsg="学号格式不正确">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="filling"></div>
    <div class="row cl">
      <label class="form-label col-3"></label>
      <div class="formControls col-5">
        <input type="text" class="input-text radius size-L" value="" placeholder="请输入姓名" id="name" name="name" datatype="*2-5" nullmsg="姓名不能为空" errormsg="姓名格式不正确">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="filling"></div>
    <div class="row cl">
      <label class="form-label col-3"></label>
      <div class="formControls col-5">
        <input type="text" class="input-text radius size-L" value="" placeholder="请输入6~16位密码" id="password" name="password" datatype="*6-16" nullmsg="密码不能为空" errormsg="密码在6~16位之间">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="filling"></div>
    <div class="row cl">
      <label class="form-label col-3"></label>
      <div class="formControls col-5">
        <input type="text" class="input-text radius size-L" value="" placeholder="请再输入一次密码" id="password" name="password" datatype="*6-16" recheck="password" nullmsg="请再输入一次密码" errormsg="您两次输入的密码不一致">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="filling"></div>
    <div class="row cl">
      <div class="formControls col-5 col-offset-3">
        <input id="submit" class="btn btn-primary radius size-L btn-block" type="submit" value="&nbsp;&nbsp;注册&nbsp;&nbsp;">
      </div>
    </div>
    <div class="filling"></div>
  </form>
</div>
</div>
</div>
<%@ include file="bottom.jsp" %>
<script type="text/javascript" src="res/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="res/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="res/lib/Validform/5.3.2/Validform.min.js"></script>
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