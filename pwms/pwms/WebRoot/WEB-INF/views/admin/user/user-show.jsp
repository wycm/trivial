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
<script type="text/javascript" src="res/html5.js"></script>
<script type="text/javascript" src="res/respond.min.js"></script>
<script type="text/javascript" src="res/PIE_IE678.js"></script>
<![endif]-->
<link href="res/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="res/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="res/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]--><title>用户信息查看</title>
</head>
<body>
<div class="cl pd-20" style=" background-color:#5bacb6">
  <img class="avatar size-XL l" src="res/images/user.png">
  <dl style="margin-left:80px; color:#fff">
    <dt><span class="f-18">${userinfo.name}</span> <span class="pl-10 f-12">类型：
	<c:choose>  
	   <c:when test="${userinfo.type == 1}">  
	      	积极分子
	   </c:when>  
	   <c:otherwise> 
	     	党员
	   </c:otherwise>  
	</c:choose> 
</span></dt>
    <dd class="pt-10 f-12" style="margin-left:0">这家伙很懒，什么也没有留下</dd>
  </dl>
</div>
<div class="pd-20">
  <table class="table">
    <tbody>
    	<tr>
        <th class="text-r">学号：</th>
        <td>${userinfo.studentId}</td>
      </tr>
      <tr>
        <th class="text-r" width="80">性别：</th>
        <td>${userinfo.sex}</td>
      </tr>
      <tr>
        <th class="text-r">手机：</th>
        <td>${userinfo.phone}</td>
      </tr>
      <tr>
        <th class="text-r">邮箱：</th>
        <td>${userinfo.email}</td>
      </tr>
      <tr>
        <th class="text-r">地址：</th>
        <td>${userinfo.address}</td>
      </tr>
      <tr>
        <th class="text-r">出身日期：</th>
        <td>${userinfo.birthday}</td>
      </tr>
    </tbody>
  </table>
</div>
<script type="text/javascript" src="res/js/jquery.min.js"></script> 
<script type="text/javascript" src="res/js/H-ui.js"></script>
<script type="text/javascript" src="res/js/H-ui.admin.js"></script>
</body>
</html>