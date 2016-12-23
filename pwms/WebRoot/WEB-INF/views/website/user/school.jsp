<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>课程，考试</title>
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
	<div class="nav">
		<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i>
		<a class="maincolor" href="../index.html">首页</a>
		<span class="c-999 en">&gt;</span>网上党校
		</nav>
	</div>
	<div class="course">
		<div class="panel panel-danger radius">
				<div class="panel-header">课程信息</div>
				<div class="panel-body">
					<div class="row cl font-bold">
						<div class="col-1"></div>
				      <label class="form-label col-1">课程名称：</label>
				      <div class="formControls col-2">
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
	<div class="course">
		<div class="panel panel-danger radius">
				<div class="panel-header">课程内容</div>
				<div class="panel-body">
					<div class="row cl">
				      	<div id="example_video_1" class="video-js vjs-default-skin vjs-controls-enabled vjs-has-started vjs-playing vjs-user-inactive" style="width: 640px; height: 264px;"><video id="example_video_1_html5_api" class="vjs-tech" preload="none" poster="http://video-js.zencoder.com/oceans-clip.png" data-setup="{}">
    <source src="http://video-js.zencoder.com/oceans-clip.mp4" type="video/mp4">
    <source src="http://video-js.zencoder.com/oceans-clip.webm" type="video/webm">
    <source src="http://video-js.zencoder.com/oceans-clip.ogv" type="video/ogg">
    <!-- Tracks need an ending tag thanks to IE9 -->
    <!-- Tracks need an ending tag thanks to IE9 -->
  </video><div></div><div class="vjs-poster" tabindex="-1" style="display: none; background-image: url(&quot;http://video-js.zencoder.com/oceans-clip.png&quot;);"></div><div class="vjs-text-track-display"></div><div class="vjs-loading-spinner" style="display: block;"></div><div class="vjs-big-play-button" role="button" aria-live="polite" tabindex="0" aria-label="play video"><span aria-hidden="true"></span></div><div class="vjs-control-bar"><div class="vjs-play-control vjs-control  vjs-playing" role="button" aria-live="polite" tabindex="0"><div class="vjs-control-content"><span class="vjs-control-text">Pause</span></div></div><div class="vjs-current-time vjs-time-controls vjs-control"><div class="vjs-current-time-display" aria-live="off"><span class="vjs-control-text">Current Time </span>0:00</div></div><div class="vjs-time-divider"><div><span>/</span></div></div><div class="vjs-duration vjs-time-controls vjs-control"><div class="vjs-duration-display" aria-live="off"><span class="vjs-control-text">Duration Time </span>0:00</div></div><div class="vjs-remaining-time vjs-time-controls vjs-control"><div class="vjs-remaining-time-display" aria-live="off"><span class="vjs-control-text">Remaining Time </span>-0:00</div></div><div class="vjs-progress-control vjs-control"><div role="slider" aria-valuenow="NaN" aria-valuemin="0" aria-valuemax="100" tabindex="0" class="vjs-progress-holder vjs-slider" aria-label="video progress bar" aria-valuetext="0:00"><div class="vjs-load-progress"><span class="vjs-control-text">Loaded: 0%</span></div><div class="vjs-play-progress" style="width: 1.41%;"><span class="vjs-control-text">Progress: 0%</span></div><div class="vjs-seek-handle vjs-slider-handle" aria-live="off" style="left: 0%;"><span class="vjs-control-text">0:00</span></div></div></div><div class="vjs-fullscreen-control vjs-control " role="button" aria-live="polite" tabindex="0"><div class="vjs-control-content"><span class="vjs-control-text">Fullscreen</span></div></div><div class="vjs-volume-control vjs-control"><div role="slider" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" tabindex="0" class="vjs-volume-bar vjs-slider" aria-label="volume level" aria-valuetext="100%"><div class="vjs-volume-level" style="width: 100%;"><span class="vjs-control-text"></span></div><div class="vjs-volume-handle vjs-slider-handle" style="left: 100%;"><span class="vjs-control-text">00:00</span></div></div></div><div class="vjs-mute-control vjs-control" role="button" aria-live="polite" tabindex="0"><div><span class="vjs-control-text">Mute</span></div></div><div class="vjs-subtitles-button vjs-menu-button vjs-control " role="button" aria-live="polite" tabindex="0" aria-haspopup="true" aria-label="Subtitles Menu"><div class="vjs-control-content"><span class="vjs-control-text">Subtitles</span></div><div class="vjs-menu"><ul class="vjs-menu-content"><li class="vjs-menu-item vjs-selected" role="button" aria-live="polite" tabindex="0" aria-selected="true">subtitles off</li><li class="vjs-menu-item" role="button" aria-live="polite" tabindex="0" aria-selected="false">English</li></ul></div></div><div class="vjs-captions-button vjs-menu-button vjs-control " role="button" aria-live="polite" tabindex="0" aria-haspopup="true" aria-label="Captions Menu"><div class="vjs-control-content"><span class="vjs-control-text">Captions</span></div><div class="vjs-menu"><ul class="vjs-menu-content"><li class="vjs-menu-item vjs-selected" role="button" aria-live="polite" tabindex="0" aria-selected="true">captions off</li><li class="vjs-menu-item" role="button" aria-live="polite" tabindex="0" aria-selected="false">English</li></ul></div></div><div class="vjs-chapters-button vjs-menu-button vjs-control " role="button" aria-live="polite" tabindex="0" aria-haspopup="true" aria-label="Chapters Menu" style="display: none;"><div class="vjs-control-content"><span class="vjs-control-text">Chapters</span></div><div class="vjs-menu"><ul class="vjs-menu-content"></ul><li class="vjs-menu-title">Chapters</li></div></div></div></div>
    				</div>
				</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script>
<script src="http://vjs.zencdn.net/5.0/video.min.js"></script>
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