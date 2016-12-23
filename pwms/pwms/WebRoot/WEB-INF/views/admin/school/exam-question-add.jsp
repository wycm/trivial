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
<script type="text/javascript" src="res/lib/html5.js"></script>
<script type="text/javascript" src="res/lib/respond.min.js"></script>
<script type="text/javascript" src="res/lib/PIE_IE678.js"></script>
<![endif]-->
<link href="res/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="res/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="res/lib/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="res/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<link href="res/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="res/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>新增考试题目</title>
</head>
<body>
<div class="pd-20">
	<form action="admin/school/addExamQuestion" method="post" class="form form-horizontal" id="form-examquestion-add">
		
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>所属考试：</label>
			<div class="formControls col-2"> <span class="select-box">
				<select name="examId" class="select">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
		<label class="form-label col-2">题目格式：</label>
		<div class="formControls col-8">
			<img src="res/images/eq_example.png">
		</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2">考试题目：</label>
			<div class="formControls col-8">
				<textarea style="height:400px;" name="parseQuestion" cols="30" rows="30" class="textarea"  placeholder="请按照以上格式批量添加考试题目！" datatype="*10-1000" dragonfly="true" nullmsg="题目不能为空！" onKeyUp="textarealength(this,1000)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/1000</p>
			</div>
			<div class="col-2">
			</div>
		</div>
		<div class="row cl">
			<div class="col-10 col-offset-2">
				<button onClick="examquestion_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存并提交</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="res/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script> 
<script type="text/javascript">
</script>
</body>
</html>