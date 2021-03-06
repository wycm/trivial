<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../common-path.jsp"%>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="res/lib/html5.js"></script>
<script type="text/javascript" src="res/lib/respond.min.js"></script>
<script type="text/javascript" src="res/lib/PIE_IE678.js"></script>
<![endif]-->
<link href="res/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="res/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="res/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet"
	type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="res/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>新增通知公告</title>
</head>
<body>
${msg}
	<div class="pd-20">
		<!--  -->
		<form action="notice/add-notice" method="post"
			class="form form-horizontal" id="form-article-add">
			<div class="row cl">
				<label class="form-label col-2"><span class="c-red">*</span>标题：</label>
				<div class="formControls col-8">
					<input type="text" class="input-text" value="" placeholder="" id=""
						nullmsg="标题不能为空" datatype="*1-50" errormsg="不能超过50个字符" name="subject" size="45">
				</div>
				<div class="col-2"></div>
			</div>
			<div class="row cl">
				<label class="form-label col-2"><span class="c-red">*</span>类型：</label>
				<div class="formControls col-2">
					<span class="select-box"> <select name="type" nullmsg="类型不能为空" class="select">
							<c:if test="${user.haveTeacherPermission()}">
								<option value="1">导师公告</option>
							</c:if>
							<c:if test="${user.haveDirectorPermission()}">
								<option value="2">系公告</option>
							</c:if>
							<c:if test="${user.haveLeaderPermission()}">
								<option value="3">院公告</option>
							</c:if>
					</select>
					</span>
				</div>
			</div>

			<div class="row cl">
				<label class="form-label col-2">内容：</label>
				<div class="formControls col-10">
					<script id="editor" type="text/plain"
						style="width:100%;height:400px;"></script>
					<input type="hidden" name="text" id="contents" />
				</div>
			</div>
			<div class="row cl">
				<div class="col-10 col-offset-2">
					<button onClick="article_save_submit();"
						class="btn btn-primary radius">
						<i class="Hui-iconfont">&#xe632;</i> 保存并提交审核
					</button>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="res/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="res/lib/layer/1.9.3/layer.js"></script>
	<script type="text/javascript" src="res/lib/Validform/5.3.2/Validform.min.js"></script>
	<script type="text/javascript" src="res/lib/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="res/lib/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" src="res/lib/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript" src="res/js/H-ui.js"></script>
	<script type="text/javascript" src="res/js/H-ui.admin.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#form-article-add").Validform({
			tiptype:2,
			callback:function(form){
				form[0].submit();
				var index = parent.layer.getFrameIndex(window.name);
				parent.$('.btn-refresh').click();
				parent.layer.close(index);
			}
		});
	});
		$(function() {
			window.console = window.console || (function(){ 
				var c = {}; c.log = c.warn = c.debug = c.info = c.error = c.time = c.dir = c.profile = c.clear = c.exception = c.trace = c.assert = function(){}; 
				return c; 
				})(); 
			UE.getEditor('editor');
		});
		function article_save_submit() {
			$("#contents").val(UE.getEditor('editor').getContent());//提交时，将content内容设置到input中
			$("#form-article-add").submit();
		}
	</script>
</body>
</html>