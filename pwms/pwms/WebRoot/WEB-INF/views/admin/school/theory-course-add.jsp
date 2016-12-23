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
<!--[if IE 6]>
<script type="text/javascript" src="res/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>新增理论课程</title>
</head>
<body>
<div class="pd-20">
	<form action="addTheoryCourse" method="post" class="form form-horizontal" id="form-theorycourse-add">
		<div class="row cl">
			<label class="form-label col-2"><span class="c-red">*</span>理论课程标题：</label>
			<div class="formControls col-8">
				<input type="text" class="input-text" value="" placeholder="" id="" name="title" datatype="*1-100" nullmsg="课程标题不能为空">
			</div>
			<div class="col-2">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2">理论课程摘要：</label>
			<div class="formControls col-8">
				<textarea name="summary" cols="" rows="" class="textarea"  placeholder="说点什么...最少输入10个字符" datatype="*1-100" dragonfly="true" nullmsg="摘要不能为空！" onKeyUp="textarealength(this,200)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/200</p>
			</div>
			<div class="col-2">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-2">理论课程内容：</label>
			<div class="formControls col-10"> 
				<script id="editor" type="text/plain" style="width:100%;height:400px;"></script>
				<input type="hidden" name="contents" id="contents"/> 
			</div>
		</div>
		<div class="row cl">
			<div class="col-10 col-offset-2">
				<button onClick="theorycourse_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存并提交审核</button>
				<button onClick="theorycourse_save();" class="btn btn-secondary radius" type="button"><i class="Hui-iconfont">&#xe632;</i> 保存草稿</button>
				<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="res/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="res/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="res/lib/Validform/5.3.2/Validform.min.js"></script> 
<script type="text/javascript" src="res/lib/ueditor/ueditor.config.js"></script> 
<script type="text/javascript" src="res/lib/ueditor/ueditor.all.min.js"> </script> 
<script type="text/javascript" src="res/lib/ueditor/lang/zh-cn/zh-cn.js"></script> 
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script> 
<script type="text/javascript">
$(function(){
	UE.getEditor('editor');
	$("#form-theorycourse-add").Validform({
		tiptype:2,
		callback:function(form){
			form[0].submit();
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
});

function theorycourse_save_submit(){
	$("#contents").val(UE.getEditor('editor').getContent());//提交时，将content内容设置到input中
	$("#form-theorycourse-add").submit();
}
</script>
</body>
</html>