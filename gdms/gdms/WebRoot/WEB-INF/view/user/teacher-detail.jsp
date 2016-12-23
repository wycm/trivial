<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common-path.jsp" %>
<html>
<head>
<%@ include file="../common-header.jsp" %>
</head>
<body>
<div class="cl pd-20" style=" background-color:#5bacb6">
  <img class="avatar size-XL l" src="res/images/user.png">
  <dl style="margin-left:80px; color:#fff">
    <dt><span class="f-18"><c:out value="${ user.name }"></c:out></span> <span class="pl-10 f-12">类型：
	      	<c:if test="${user.haveTeacherPermission() }">导师</c:if> <c:if test="${user.haveDirectorPermission() }">系主任</c:if><c:if test="${user.haveLeaderPermission() }">院长</c:if>
</span></dt>
    <dd class="pt-10 f-12" style="margin-left:0"><c:out value="${ user.introduction }"></c:out></dd>
  </dl>
</div>
<div class="pd-20">
  <table class="table table-border table-bordered">
    <tbody>
      <tr class="text-c">
        <th>专业：</th>
        <td><c:out value="${ user.major }"></c:out></td>
      </tr>
      <tr class="text-c">
        <th>职称：</th>
        <td><c:out value="${ user.jobtitle }"></c:out></td>
      </tr>
      <tr class="text-c">
        <th>手机号码：</th>
        <td><c:out value="${ user.phoneNumber }"></c:out></td>
      </tr>
      <tr class="text-c">
        <th>可被选择数量：</th>
        <td><c:out value="${ user.amount }"></c:out></td>
      </tr>
    </tbody>
  </table>
</div>
<script type="text/javascript" src="res/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="res/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script>
</body>
</html>