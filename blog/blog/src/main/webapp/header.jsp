<%@ page contentType="text/html;charst=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div id="header">
   <div id="header_inner"> 
    <strong class="logo"> <a href="index" class="png_bg" title="卧颜沉默">卧颜沉默</a> </strong> 
    <div class="header_bg png_bg"></div> 
    <div class="toplinks">
     <div id="_userlogin">
         <c:choose>
             <c:when test="${sessionScope.user == null}">
              <a href="user/login" title="用户登录">登录</a>
              <span>|</span>
                <a href="user/register" title="注册">注册</a>
                <span>|</span>
                <a href="admin/login.jsp" title="注册">管理员登录</a>
              </c:when>
              <c:otherwise>
                <a href="user/loginout" title="注销">注销</a>
                <span>|</span>
                <a href="admin/login.jsp" title="注册">管理员登录</a>
              </c:otherwise>
         </c:choose>
     </div> 
     <div id="top_nav"> 
      <form name="formsearch" method="get" action="serach"> 
       <div class="form clearfix"> 
        <label for="s"></label> 
        <input type="text" name="q" class="search-keyword"  onfocus="if (this.value == '请输入关键字进行搜索') {this.value = '';}" onblur="if (this.value == '') {this.value = '请输入关键字进行搜索';}" value="请输入关键字进行搜索"/> 
        <button type="submit" class="select_class">搜索</button> 
       </div> 
      </form> 
     </div> 
    </div> 
    <div id="navmenu"> 
     <ul> 
      <li><a href="index">网站首页</a></li>
         <c:forEach items="${applicationScope.headerAndSider.parArticletypes}" var="item">
	      <li><a href="article/category/${item.linkname}">${item.value}</a>
	       <ul class="sub-menu">
	        <c:if test="${item.chiArticleTypes!=null}">
        		<c:forEach items="${item.chiArticleTypes}" var="item1">
	        		<li><a href="article/category/${item1.linkname}">${item1.value}</a></li>
	        	</c:forEach>
	        </c:if>
	       </ul>
	       </li>
         </c:forEach>
      <li>
      	<a href="msgboard">留言板</a>
      </li> 
     </ul> 
    </div> 
    <div class="clearfix"></div> 
   </div> 
  </div> 