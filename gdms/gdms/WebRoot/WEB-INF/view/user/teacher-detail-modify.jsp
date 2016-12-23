<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common-path.jsp" %>
<html>
<head>
<%@ include file="../common-header.jsp" %>
</head>
<body>
<div class="pd-20">
<form action=""  method="post" class="form form-horizontal" id="teacher-detail-modify">
	<div class="row cl">
		<label class="form-label col-3">姓名：</label>
		<div class="formControls col-7">
		<input type="text" class="input-text" value="<c:out value="${ user.name }"></c:out>" placeholder="姓名" name="name" datatype="*2-5" nullmsg="不能为空">
		</div>
		<div class="col-2">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-3">职称：</label>
		<div class="formControls col-7">
		<select class="select" name="jobtitle" size="1">
				<option value="讲师助手" selected="">讲师助手</option>
				<option value="讲师">讲师</option>
				<option value="副教授">副教授</option>
				<option value="教授">教授</option>
			</select>
		</div>
		<div class="col-2">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-3">手机号码：</label>
		<div class="formControls col-7">
		<input type="text" class="input-text" value="<c:out value="${ user.phoneNumber }"></c:out>" placeholder="手机号码" name="phoneNumber" datatype="n11-11" errormsg="号码格式不正确">
		</div>
		<div class="col-2">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-3">可被选数量：</label>
		<div class="formControls col-7">
		<input type="text" class="input-text" value="<c:out value="${ user.amount }"></c:out>" placeholder="可被选数量" name="amount" datatype="n1-3" errormsg="1-3位数字">
		</div>
		<div class="col-2">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-3">个人介绍：</label>
		<div class="formControls col-7">
		<textarea name="introduction" cols="" rows="" class="textarea"  placeholder="个人介绍" dragonfly="true" onKeyUp="textarealength(this,255)"><c:out value="${ user.introduction }"></c:out></textarea>
	        <p class="textarea-numberbar"><em class="textarea-length">0</em>/255</p>
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
<script type="text/javascript" src="res/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="res/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="res/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script>
<script type="text/javascript">
$("#teacher-detail-modify").Validform({
	tiptype:2,
	callback:function(form){
		form[0].submit();
		var index = parent.layer.getFrameIndex(window.name);
		parent.$('.btn-refresh').click();
		parent.layer.close(index);
	}
});

</script>
</body>
</html>