<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common-path.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../common-header.jsp" %>
<title>修改密码</title>
</head>
<body>
<div class="pd-20">
	<form action=""  method="post" class="form form-horizontal" id="modify-password">
	<div class="row cl">
		<label class="form-label col-3"><span class="c-red">*</span>原密码：</label>
		<div class="formControls col-7">
		<input type="password" class="input-text" value="" placeholder="原密码" name="oldPassword" datatype="*5-18" errormsg="密码至少6个字符,最多18个字符！">
		</div>
		<div class="col-2">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-3"><span class="c-red">*</span>新密码：</label>
		<div class="formControls col-7">
		<input type="password" class="input-text" value="" placeholder="新密码" name="password" datatype="*6-18" nullmsg="密码至少6个字符,最多18个字符！">
		</div>
		<div class="col-2">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-3"><span class="c-red">*</span>重复密码：</label>
		<div class="formControls col-7">
		<input type="password" class="input-text" value="" placeholder="重复密码" name="repeatPassword" datatype="*6-18" nullmsg="密码至少6个字符,最多18个字符！">
		</div>
		<div class="col-2">
		</div>
	</div>
	<div class="pt-20 row cl">
	<div class="col-3"></div>
		<div class="col-7">
			<input type="submit" class="btn btn-block btn-primary" name="submit" value="确认修改"/>		
		</div>
	</div>
	</form>
</div>
</body>
<script type="text/javascript" src="res/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="res/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="res/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="res/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script>
<script type="text/javascript">
$("#modify-password").Validform({
	tiptype:2,
	callback:function(form){
		form[0].submit();
		var index = parent.layer.getFrameIndex(window.name);
		parent.$('.btn-refresh').click();
		parent.layer.close(index);
	}
});
</script>
</html>