<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="head_all">
  <div class="head">
    <div class="head_left"></div>
    <div class="head_right">
      <div class="head_sear">
       <div class="head_sear_top">
       	<c:choose>
       		<c:when test="${sessionScope.user == null}">
	        	<a href="register.html">注册</a>
	        	<span>|</span>
	        	<a href="login.html">登录</a>
        	</c:when>
        	<c:otherwise>
        		<font color="yellow">${sessionScope.user.name},欢迎登录</font>
	        	<span>|</span>
	        	<a href="user/logout.html">注销</a>
        	</c:otherwise>
        </c:choose>
        	<span>|</span>
        	<a href="admin/index.html">后台登录</a>
        </div>
        <div class="head_sear_bot">
          <div class="head_sear_con">
            <input name="" type="text" class="head_sear1" />
            &nbsp;
            <input type="image" src="res/website/images/search1.png" />
            
          </div>
        </div>
      </div>
    </div>
  </div>
  <table border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td>
   <div id="navmenu" class="menu">
<ul>
<li><a class="current" href="index.html">首页</a>

</li>
<li><a class="current" href="school">网上党校</a>
		<ul>
			<li> <a href="school/llkc/list.html">理论课程</a></li>
			<li> <a href="school/spkc/list.html">视频课程</a></li>
			<li> <a href="school/xxjl/list.html">学习记录</a></li>
			<li> <a href="school/zxks/list.html">在线考试</a></li>
			<li> <a href="school/cjcx/list.html">成绩查询</a></li>
		</ul>
</li>
<li><a class="current" href="notice">通知公告</a>
		<ul>
			<li> <a href="notice/hdtz/list.html">活动通知</a></li>
			<li> <a href="notice/sqrdx/list.html">申请人党校</a></li>
			<li> <a href="notice/jjfzdx/list.html">积极分子党校</a></li>
			<li> <a href="notice/ybdydx/list.html">预备党员党校</a></li>
			<li> <a href="notice/dxgg/list.html">党校公告</a></li>
			<li> <a href="notice/xw/list.html">新闻</a></li>
		</ul>
</li>
<li><a class="current" href="party">党建专项</a>
		<ul>
			<li> <a href="party/zyjs/list.html">中央精神</a></li>
			<li> <a href="party/qzlx/list.html">群众路线</a></li>
			<li> <a href="party/zgm/list.html">中国梦</a></li>
		</ul>
</li>
<li><a class="current" href="theory">理论学习</a>
		<ul>
			<li> <a href="theory/lljd/list.html">理论经典</a></li>
		</ul>
</li>
<li><a class="current" href="impdoc">重要文件</a>
		<ul>
			<li> <a href="impdoc/dswx/list.html">党史文献</a></li>
			<li> <a href="impdoc/gzzd/list.html">规则制度</a></li>
			<li> <a href="impdoc/jddd/list.html">经典导读</a></li>
			<li> <a href="impdoc/cyws/list.html">常用文书</a></li>
			<li> <a href="impdoc/rdbd/list.html">入党必读</a></li>
			<li> <a href="impdoc/xtsc/list.html">系统手册</a></li>
		</ul>
</li>
<li><a class="current" href="process">入党流程</a>
 <ul>
	<li><a href="process/jpprocess.html">入党流程</a></li>  
	<li><a href="process/myprocess.html">我的流程</a></li>  
</ul>
</li>
<li><a class="current" href="user/mybranch.html">个人中心</a>
	<ul> 
		<li><a href="user/mybranch.html">我的支部</a></li>  
		<li><a href="user/userdetail-add.html">添加详细信息</a></li>  
	</ul>
</li>

<div class="clear"> </div>
</div>
      </td>
    </tr>
  </table>
</div>
<!-- <script src="res/website/js/jquery-1.8.3.min.js" type="text/javascript"></script> -->
<script src="res/lib/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
  	$("#navmenu ul li:has(ul)").hover(function() {
        $(this).children("a").css({
            color: "white"
        });
        if ($(this).find("li").length > 0) {
            $(this).children("ul").stop(true, true).slideDown(100);
        }
    }, function() {
        $(this).children("a").css({
            color: "wheat"
        });
        $(this).children("ul").stop(true, true).slideUp("fast");
    }); 
});
</script>