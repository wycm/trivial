<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ include file="../common-path.jsp" %>
<%@ include file="../common-header.jsp" %>
<title>提示</title>
</head>
<body>
	<table class="table table-border table-bg table-bordered">
	<thread>
		<tr class="text-c"><td>阶段号</td><td>内容</td></tr>
	</thread>
	<tbody>
	  <tr class="text-c active"><td>第一阶段</td><td>选择导师</td></tr>
	  <tr class="text-c success"><td>第二阶段</td><td>导师选择</td></tr>
	  <tr class="text-c warning"><td>第三阶段</td><td>选择课题</td></tr>
	  <tr class="text-c danger"><td>第四阶段</td><td>完成作品</td></tr>
	  </tbody>
	</table>
	<div class="row cl mt-20">
		<div class="col-4 col-offset-4">
		我已完成：<br/>
		<c:choose> <c:when test="${isChoiseTeacher}"><span class="c-red">第一阶段：选择导师</span></c:when><c:otherwise><span class="c-333">第一阶段：选择导师</span></c:otherwise></c:choose><br/>
		<c:choose> <c:when test="${isTeacherChoise}"><span class="c-red">第二阶段：导师选择</span></c:when><c:otherwise><span class="c-333">第二阶段：导师选择</span></c:otherwise></c:choose><br/>
		<c:choose> <c:when test="${isChoiseIssue}"><span class="c-red">第三阶段：选择课题</span></c:when><c:otherwise><span class="c-333">第三阶段：选择课题</span></c:otherwise></c:choose><br/>
		</div>
	</div>
</body>
<script type="text/javascript" src="res/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script>
</html>