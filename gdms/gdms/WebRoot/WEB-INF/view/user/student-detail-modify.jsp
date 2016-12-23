<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common-path.jsp" %>
<html>
<head>
<%@ include file="../common-header.jsp" %>
</head>
<body>
<div class="pd-20">
<form action=""  method="post" class="form form-horizontal" id="student-detail-modify">
	<div class="row cl">
		<label class="form-label col-3">姓名：</label>
		<div class="formControls col-7">
		<input type="text" class="input-text" value="<c:out value="${ user.name }"></c:out>" placeholder="姓名" name="name" datatype="s2-5" errormsg="姓名不合法">
		</div>
		<div class="col-2">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-3">年级：</label>
		<div class="formControls col-7">
		<select class="select" name="grade" size="1">
				<option value="2013" selected="">2013</option>
				<option value="2014">2014</option>
				<option value="2015">2015</option>
				<option value="2016">2016</option>
				<option value="2017">2017</option>
				<option value="2018">2018</option>
				<option value="2019">2019</option>
			</select>
		</div>
		<div class="col-2">
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-3">专业:</label>
		<div class="formControls col-7">
			<select class="select" name="major">
				<option value="软件工程">软件工程</option>
			    <option value="网络工程">网络工程</option>
			    <option value="计算机科学与技术">计算机科学与技术</option>
                <option value="电子商务">电子商务</option>
			</select>
		</div>
	</div>
	<div class="row cl">
		<label class="form-label col-3">班级:</label>
		<div class="formControls col-7">
			<select class="select" name="userClass">
				<option value="卓越">卓越</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
			</select>
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
<script type="text/javascript" src="res/lib/layer/1.9.3/layer.js"></script>
<script type="text/javascript" src="res/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script>
<script type="text/javascript">
$("#student-detail-modify").Validform({
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