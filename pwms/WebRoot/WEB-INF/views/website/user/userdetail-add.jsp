<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户详细信息</title>
<%@ include file="../path.jsp" %>
<link href="res/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="res/website/style/base.css" rel="stylesheet" type="text/css" />
<link href="res/website/style/style1.css" rel="stylesheet" type="text/css" />
<link href="res/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="../header.jsp"%>
<div class="page-main">
<div class="nav radius">
	<nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i>
	<a class="maincolor" href="../index.html">首页</a>
	<span class="c-999 en">&gt;</span>添加详细信息
</nav>
</div>
<div class="page-wrapper">
	<div class="pd-20">
  <form action=""  method="post" class="form form-horizontal" id="form-reward-punish-add">
    <div class="row cl">
      <label class="form-label col-1">姓名：</label>
      <div class="formControls col-2">
        <input type="text" class="input-text radius" value="" placeholder="姓名" id="card" name="card" datatype="*11-16" nullmsg="不能为空" errormsg="格式不正确">
      </div>
      <div class="col-1"> </div>
      <label class="form-label col-1">学号：</label>
      <div class="formControls col-2">
        <input type="text" class="input-text radius" value="" placeholder="学号" id="card" name="card" datatype="*11-16" nullmsg="不能为空" errormsg="格式不正确">
      </div>
      <div class="col-1"> </div>
      <label class="form-label col-1">班级：</label>
      <div class="formControls col-2">
        <input type="text" class="input-text radius" value="" placeholder="学号" id="card" name="card" datatype="*11-16" nullmsg="不能为空" errormsg="格式不正确">
      </div>
      <div class="col-1"> </div>
    </div>
    <div class="filling"></div>
    <div class="row cl">
      <label class="form-label col-1">性别：</label>
      <div class="formControls col-3 skin-minimal mt-4">
        <div class="radio-box">
        	<input type="radio" name="sex" value="男"/>
          <label for="sex-1" class="">男</label>
        </div>
        <div class="radio-box">
        	<input type="radio" name="sex" value="女"/>
          <label for="sex-2">女</label>
        </div>
      </div>
      <label class="form-label col-1">民族：</label>
      <div class="formControls col-2">
        <input type="text" class="input-text radius" value="" placeholder="民族" id="card" name="card" datatype="*11-16" nullmsg="不能为空" errormsg="格式不正确">
      </div>
      <div class="col-1"> </div>
      <label class="form-label col-1">籍贯：</label>
      <div class="formControls col-2">
        <input type="text" class="input-text radius" value="" placeholder="籍贯" id="card" name="card" datatype="*11-16" nullmsg="不能为空" errormsg="格式不正确">
      </div>
      <div class="col-1"> </div>
    </div>
    <div class="filling"></div>
    <div class="row cl">
	      <label class="form-label col-1">出生日期：</label>
	      <div class="formControls col-2">
			<input type="text" name="outDate" onfocus="WdatePicker()" id="datemin" class="input-text Wdate">
	      </div>
	      <div class="col-1"> </div>
	      <label class="form-label col-1">职务：</label>
	      <div class="formControls col-2">
	        <input type="text" class="input-text radius" value="" placeholder="职务" id="card" name="card" datatype="*11-16" nullmsg="不能为空" errormsg="格式不正确">
	      </div>
	      <div class="col-1"> </div>
	      <label class="form-label col-1">申请时间：</label>
	      <div class="formControls col-2">
			<input type="text" name="outDate" onfocus="WdatePicker()" id="datemin" class="input-text Wdate">
	      </div>
	      <div class="col-1"> </div>
    </div>
    <div class="filling"></div>
    <div class="row cl">
	      <label class="form-label col-1">电话号码：</label>
	      <div class="formControls col-2">
	        <input type="text" class="input-text radius" value="" placeholder="电话号码" id="card" name="card" datatype="*11-16" nullmsg="不能为空" errormsg="格式不正确">
	      </div>
	      <div class="col-1"> </div>
	      <label class="form-label col-1">联系人：</label>
	      <div class="formControls col-2">
	        <input type="text" class="input-text radius" value="" placeholder="联系人" id="card" name="card" datatype="*11-16" nullmsg="不能为空" errormsg="格式不正确">
	      </div>
	      <div class="col-1"> </div>
	      <label class="form-label col-1">培养时间：</label>
	      <div class="formControls col-2">
	      	<input type="text" name="outDate" onfocus="WdatePicker()" id="datemin" class="input-text Wdate">
	      </div>
    </div>
    <div class="filling"></div>
    <div class="row cl">
			<label class="form-label col-1">培养教育：</label>
			<div class="formControls col-10">
				<textarea name="" cols="" rows="" class="textarea" placeholder="说点什么...最少输入10个字符" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onkeyup="textarealength(this,50)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/50</p>
			</div>
	</div>
	<div class="row cl">
			<label class="form-label col-1">考察意见：</label>
			<div class="formControls col-10">
				<textarea name="" cols="" rows="" class="textarea" placeholder="说点什么...最少输入10个字符" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onkeyup="textarealength(this,255)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/255</p>
			</div>
	</div>
	<div class="filling"></div>
	<div class="row cl">
	      <label class="form-label col-1">转正时间：</label>
	      <div class="formControls col-2">
	      	<input type="text" name="outDate" onfocus="WdatePicker()" id="datemin" class="input-text Wdate">
	      </div>
	      <div class="col-1"> </div>
	      <label class="form-label col-1">入党时间：</label>
	      <div class="formControls col-2">
	      	<input type="text" name="outDate" onfocus="WdatePicker()" id="datemin" class="input-text Wdate">
	      </div>
	      <div class="col-1"> </div>
	      <label class="form-label col-1">积极分子时间：</label>
	      <div class="formControls col-2">
	      	<input type="text" name="outDate" onfocus="WdatePicker()" id="datemin" class="input-text Wdate">
	      </div>
    </div>
    <div class="filling"></div>
    <div class="row cl">
	      <label class="form-label col-1">党课成绩：</label>
	      <div class="formControls col-2">
	        <input type="text" class="input-text radius" value="" placeholder="党课成绩" id="card" name="card" datatype="*11-16" nullmsg="不能为空" errormsg="格式不正确">
	      </div>
	      <div class="col-1"> </div>
	      <label class="form-label col-1">地址：</label>
	      <div class="formControls col-2">
	        <input type="text" class="input-text radius" value="" placeholder="地址" id="card" name="card" datatype="*11-16" nullmsg="不能为空" errormsg="格式不正确">
	      </div>
	      <div class="col-1"> </div>
	      <label class="form-label col-1">邮箱：</label>
	      <div class="formControls col-2">
	      	<input type="text" class="input-text radius" value="" placeholder="邮箱" id="card" name="card" datatype="*11-16" nullmsg="不能为空" errormsg="格式不正确">
	      </div>
    </div>
    <div class="filling"></div>
    <div class="row cl">
			<label class="form-label col-1">备注：</label>
			<div class="formControls col-10">
				<textarea name="" cols="" rows="" class="textarea" placeholder="说点什么...最少输入10个字符" datatype="*10-100" dragonfly="true" nullmsg="备注不能为空！" onkeyup="textarealength(this,255)"></textarea>
				<p class="textarea-numberbar"><em class="textarea-length">0</em>/255</p>
			</div>
	</div>
	<div class="filling"></div>
    <div class="row cl">
      <div class="formControls col-10 col-offset-1">
        <input id="submit" class="btn btn-primary radius size-L btn-block" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
      </div>
    </div>
  </form>
</div>
</div>
</div>
<%@ include file="../bottom.jsp" %>
<script type="text/javascript" src="res/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="res/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="res/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script>
<script type="text/javascript" src="<%=basePath%>res/lib/My97DatePicker/WdatePicker.js"></script> 
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
	});
});
</script>
</body>
</html>