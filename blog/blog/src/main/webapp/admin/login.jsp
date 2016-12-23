<%@ page contentType="text/html;charst=UTF-8" pageEncoding="UTF-8" %>
<%@include file="common/common-path.jsp"%>
<html>
<head>
  <%@include file="common/common-header.jsp"%>
  <link href="res/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
  <title>梦想博客后台管理系统</title>
</head>
<body>
<%
  String number=request.getParameter("id");
  String password=request.getParameter("password");
  if(number!=null&&password!=null){
    if(number.equals("admin")&&password.equals("admin")){
      session.setAttribute("admin", "");
      response.sendRedirect("index");
      return;
    }
    else{
      response.sendRedirect("login.jsp");
      return;
    }
  }
%>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" action="admin/login.jsp" method="post">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input id="" name="id" type="text" placeholder="账户" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input id="" name="password" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <label for="online">
            <input type="checkbox" name="online" id="online" value="">
            使我保持登录状态</label>
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">Copyright 梦想博客 by H-ui.admin.v2.3</div>
<%@include file="common/common-script.jsp"%>
</body>
</html>
