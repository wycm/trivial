<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>影像课程|${course.title}</title>
<%@ include file="../path.jsp" %>
<link href="res/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="res/website/style/base.css" rel="stylesheet" type="text/css" />
<link href="res/website/style/style1.css" rel="stylesheet" type="text/css" />
<link href="res/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link href="http://vjs.zencdn.net/5.0/video-js.min.css" rel="stylesheet" />
</head>
<body>
<%@ include file="../header.jsp"%>
<div class="page-main">
	<div class="nav radius">
		<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i>
		<a class="maincolor" href="../index.html">首页</a>
		<span class="c-999 en">&gt;</span><a class="maincolor" href="school">网上党校</a>
		<span class="c-999 en">&gt;</span>视频课程
		</nav>
	</div>
	<div class="main-container">
	<div class="left-side radius">
		<ul class="upright-menu">
			<li class="current"> <a href="school/spkc/list.html"">视频课程</a></li>
		</ul>
	</div>
	<div class="main-box">
		<div class="panel panel-danger radius">
				<div class="panel-header">课程信息</div>
				<div class="panel-body">
					<div class="row cl font-bold">
				      <label class="form-label col-1.5">课程名称：</label>
				      <div class="formControls col-2.5">
				      		马克思主义学习
				      </div>
    					<div class="col-1"></div>
				      <label class="form-label col-1" >课程组：</label>
				      <div class="formControls col-2">
				      		王洋的课程组
				      </div>
    					<div class="col-1"></div>
				      <label class="form-label col-1" >发布人：</label>
				      <div class="formControls col-2">
				      		王洋
				      </div>
    				</div>
				</div>
		</div>
	</div>
	<div class="main-box">
		<div class="panel panel-danger radius">
				<div class="panel-header">课程内容</div>
				<div class="panel-body">
					<div class="row cl">
				      	<video id="video-test" class="video-js vjs-default-skin" controls preload="none" width="818" height="450"
						      poster="upload/img/gcd.jpg"
						      data-setup="{}">
						    <source src="${course.summary}" type='video/mp4' />
						</video>
						<div class="row cl mt-20">
						<div class="row radius text-c" style="border: 0px solid #DBDBDB;">
							<input id="stop-study" class="btn btn-primary radius btn-block size-XL" type="button" value="停止本次学习"/>
						</div>
						</div>
    				</div>
				</div>
		</div>
	</div>
	</div>
</div>
<%@ include file="../bottom.jsp" %>
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script>
<script src="http://vjs.zencdn.net/5.0/video.min.js"></script>
<script type="text/javascript">
var seconds = 0;
var t;
var myPlayer = videojs("video-test");//获取video对象
var timedCount = function(){
	if(seconds == 0){//第一次点击开始时提示用户
		alert("欢迎进入本次课程学习,请认真学习，若学习完毕，请点击下方'停止本次学习'按钮，否则该学习时间不会被记录");
	}
	t = window.setTimeout("timedCount();",1000);
	seconds++;
	/* alert("学习时间" + seconds + "s"); */
};
var stopCount = function(){//暂停时停止计时
	clearTimeout(t);	
};
myPlayer.volume(0.5);//音量设置0.5
myPlayer.on("play",timedCount);//绑定播放按钮
myPlayer.on("pause",stopCount);//绑定暂停按钮
myPlayer.on('timeupdate', function () {  
    // 如果 currentTime() === duration()，则视频已播放完毕
    if (myPlayer.duration() != 0 && myPlayer.currentTime() === myPlayer.duration()) {
            // 播放结束,停止计时
            stopCount();
        }
    });
$("#stop-study").click(function(){
	myPlayer.pause();
	if(confirm("本次学习了" + seconds + "s,点击确定关闭该页面,点击取消继续学习！")){
		window.close(); 	
	}
});
</script>
</body>
</html>