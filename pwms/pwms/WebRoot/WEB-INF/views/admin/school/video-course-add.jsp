<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../path.jsp" %>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,member-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="../lib/html5.js"></script>
<script type="text/javascript" src="../lib/respond.min.js"></script>
<script type="text/javascript" src="../lib/PIE_IE678.js"></script>
<![endif]-->
<link href="res/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="res/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="res/lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="res/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link href="res/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>添加课程</title>
</head>
<body>
<div class="pd-20">
  <form action="admin/school/addCourse"  method="post" class="form form-horizontal" id="form-course-add" enctype="multipart/form-data">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>课程名称：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" name="title" id="title" datatype="*" nullmsg="请输入课程名称！">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>完成课程学时（单位：分钟）：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="" placeholder="" id="explain" name="explian"  datatype="*1-3" nullmsg="不能为空">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>所属流程：</label>
			<div class="formControls col-5">
			<span class="select-box">
				<select name="processId" class="select">
					<option value="1">提交入党流程</option>
					<option value="2">提交入党流程</option>
					<option value="3">入党积极分子</option>
					<option value="4">参加党校学习</option>
					<option value="5">成为发展对象</option>
					<option value="6">成为预备党员</option>
					<option value="7">转为正式党员</option>
				</select>
				</span>
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>课程类型：</label>
			<div class="formControls col-5"> <span class="select-box">
				<select name="type" class="select">
					<option value="1">积极分子</option>
					<option value="2">党员</option>
					<option value="3">都有</option>
				</select>
				</span>
			</div>
	</div>
	<div class="row cl">
      <label class="form-label col-3">课程文件：</label>
      <div class="formControls col-5"> <span class="btn-upload form-group">
        <input class="input-text upload-url" type="text" name="uploadfile-2" id="uploadfile-2" readonly="" datatype="*" nullmsg="请添加附件！" style="width:200px">
        <a href="javascript:void();" class="btn btn-primary radius upload-btn"><i class="Hui-iconfont"></i> 浏览文件</a>
        <input type="file" multiple="" name="file" class="input-file" accept=".mp4,.avi">
        </span> </div>
      <div class="col-4"> <span class="Validform_checktip"></span></div>
    </div>
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input id="submit" class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
      </div>
    </div>
  </form>
</div>
<script type="text/javascript" src="res/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="res/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="res/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="res/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="res/lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	$("#form-course-add").Validform({
		tiptype:2,
		callback:function(form){
			form[0].submit();
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
	$("#submit").click(function(){
		$("#form-course-add").submit();
		window.close();
	});
});
</script>
</body>
</html>