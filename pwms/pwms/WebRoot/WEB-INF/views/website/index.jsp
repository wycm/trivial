<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${tzggList == null}">
	<!--   -->
	<c:redirect url="/index.html"/>
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>党务管理系统</title>
<%@ include file="path.jsp" %>
<link href="res/website/style/base.css" rel="stylesheet" type="text/css" />
<link href="res/website/style/style1.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="res/website/style/normalize.css" />
<link rel="stylesheet" type="text/css" href="res/website/style/set2.css" />
<style type="text/css">
#tableDiv{
border:1px gray dashed;
}
#table1 td{
padding-left:11px;
padding-bottom:10px;
}
</style>
</head>
<body>
<%@ include file="header.jsp"%>
<script src="res/website/js/jquery.cycle.js" type="text/javascript"></script>
<script src="res/website/js/jquery.luara.0.0.1.min.js"></script>
<div class="main_all">
<div class="news">
  <div class="news_left">
    <div class="news_move">
				 <div class="example">
					<ul>
						<li><img src="upload/img/1.jpg"/></li>
						<li><img src="upload/img/2.jpg"/></li>
						<li><img src="upload/img/3.jpg"/></li>
						<li><img src="upload/img/gcd.jpg"/></li>
					</ul>
					<ol>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
					</ol>
				</div>
				<script>
				$(function(){
					$(".example").luara({width:"310",height:"245",interval:4000,selected:"seleted"});

				});
				</script>

	</div>
    <div class="news_list_a">
    	<div class="news_left_title">
   <div class="index_tab_top">
        <ul class="index_tab_list">
          <li class="press"><a href="#"><img src="res/website/images/icon.gif" /> 新闻</a></li>
        </ul>
        <div class="news_more"><a href="news.html"><img src="res/website/images/more.gif" border="0" /></a></div>
      </div>
 </div>
    	
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <c:forEach items="${xwList}" var="item">
        <tr>
          <td width="20"><a href="#"></a><img src="res/website/images/dot1.png" width="20" height="23" /> <a href="#"></a></td>
          <td align="left" class="index_table_size">
			<a title="${item.title}" href="${item.articletype.pArticletype.linkname}/${item.articletype.linkname}/${item.id}.html">${item.title}</a>
			</td>
          <td width="24" align="center" class="public_color1">${item.dateline}</td>
        </tr>
        </c:forEach>
      </table>
    </div>
  </div>
  <div class="news_list_a">
    	<div class="news_left_title">
   <div class="index_tab_top">
        <ul class="index_tab_list">
          <li class="press"><a href="#"><img src="res/website/images/icon.gif" />党校公告</a></li>
        </ul>
        <div class="news_more"><a href="news.html"><img src="res/website/images/more.gif" border="0" /></a></div>
      </div>
 </div>
    	
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <c:forEach items="${dxggList}" var="item">
        <tr>
          <td width="20"><a href="#"></a><img src="res/website/images/dot1.png" width="20" height="23" /> <a href="#"></a></td>
          <td align="left" class="index_table_size">
			<a title="${item.title}" href="${item.articletype.pArticletype.linkname}/${item.articletype.linkname}/${item.id}.html">${item.title}</a>
			</td>
          <td width="24" align="center" class="public_color1">${item.dateline}</td>
        </tr>
        </c:forEach>
      </table>
    </div>
  </div>



<div class="news">
  <div class="news1">
    <div class="news1_title">
      <div class="news1_title_text">通知公告</div>
      <div  class="news_more"><a href="notice"><img src="res/website/images/more.gif" border="0" /></a></div>
    </div>
    <div class="news_pic"><img src="res/website/images/pic1.png" /></div>
    <div class="news_list">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      	<c:forEach items="${tzggList}" var="item"> 
        <tr>
          <td width="20"><img src="res/website/images/5.png" width="11" height="11" /></td>
          <td align="left" class="index_table_size">
          <a title="${item.title}" href="${item.articletype.pArticletype.linkname}/${item.articletype.linkname}/${item.id}.html">${item.title}</a>
          </td>
          <td width="24" align="center" class="public_color1">${item.dateline}</td>
        </tr>
        </c:forEach>
      </table>
    </div>
  </div>
  <div class="news2">
    <div class="news1_title">
      <div class="news1_title_text">党建专项</div>
      <div  class="news_more"><a href="party"><img src="res/website/images/more.gif" border="0" /></a></div>
    </div>
    <div class="news_pic"><img src="res/website/images/pic2.png" width="290" height="99" /></div>
    <div class="news_list">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      	<c:forEach items="${djzxList}" var="item"> 
        <tr>
          <td width="20"><img src="res/website/images/5.png" width="11" height="11" /></td>
          <td align="left" class="index_table_size">
			<a title="${item.title}" href="${item.articletype.pArticletype.linkname}/${item.articletype.linkname}/${item.id}.html">${item.title}</a>
		  </td>
		  <td width="24" align="center" class="public_color1">${item.dateline}</td>
        </tr>
       </c:forEach>
      </table>
    </div>
  </div>
  <div class="news3">
    <div class="news1_title">
      <div class="news1_title_text">理论学习</div>
      <div  class="news_more"><a href="#"><img src="res/website/images/more.gif" border="0" /></a></div>
    </div>
    <div class="news_pic"><img src="res/website/images/pic3.png" width="290" height="99" /></div>
    <div class="news_list">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      	<c:forEach items="${llxxList}" var="item"> 
        <tr>
          <td width="20"><a href="#"></a><img src="res/website/images/1.png" /> <a href="#"></a></td>
          <td align="left" class="index_table_size">
			<a title="${item.title}" href="${item.articletype.pArticletype.linkname}/${item.articletype.linkname}/${item.id}.html">${item.title}</a>
		</td>
		<td width="24" align="center" class="public_color1">${item.dateline}</td>
        </tr>
       </c:forEach>
      </table>
    </div>
  </div>
  </div>
  <div class="news">
  <div class="news1">
    <div class="news1_title">
      <div class="news1_title_text"> 重要文件</div>
      <div  class="news_more"><a href="#"><img src="res/website/images/more.gif" border="0" /></a></div>
    </div>
    <div class="news_pic"><img src="res/website/images/pic1.png" /></div>
    <div class="news_list">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      	<c:forEach items="${zywjList}" var="item">
        <tr> 
          <td width="20"><a href="#"></a><img src="res/website/images/1.png" /> <a href="#"></a></td>
          <td align="left" class="index_table_size">
          	<a title="${item.title}" href="${item.articletype.pArticletype.linkname}/${item.articletype.linkname}/${item.id}.html">${item.title}</a>
          </td>
          <td width="24" align="center" class="public_color1">${item.dateline}</td>
        </tr>
        </c:forEach>
      </table>
    </div>
  </div>
  <div class="news2">
    <div class="news1_title">
      <div class="news1_title_text">入党流程</div>
      <div  class="news_more"><a href="#"><img src="res/website/images/more.gif" border="0" /></a></div>
    </div>
    <div class="news_pic"><img src="res/website/images/pic2.png" width="290" height="99" /></div>
    <div class="news_list">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="20"><a href="#"></a><img src="res/website/images/1.png" /></td>
          <td align="left" class="index_table_size"><a href="process/jpprocess.html" title="入党流程">入党流程</a></td>
          <td width="24" align="center" class="public_color1">2016-03-09</td>
        </tr>
      </table>
    </div>
  </div>
  <div class="news3">
    <div class="news1_title">
      <div class="news1_title_text">理论课程</div>
      <div  class="news_more"><a href="#"><img src="res/website/images/more.gif" border="0" /></a></div>
    </div>
    <div class="news_pic"><img src="res/website/images/pic3.png" width="290" height="99" /></div>
    <div class="news_list">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <c:forEach items="${tcList}" var="item">
        <tr>
          <td width="20"><a href="#"></a><img src="res/website/images/1.png" /></td>
          <td align="left" class="index_table_size"><a href="school/llkc/${item.id}/course.html">${item.title}</a></td>
          <td width="24" align="center" class="public_color1">${item.dateline}</td>
        </tr>
        </c:forEach>
      </table>
    </div>
  </div>
  
  
</div>
<%@ include file="bottom.jsp" %>
</div>
</body>
</html>
