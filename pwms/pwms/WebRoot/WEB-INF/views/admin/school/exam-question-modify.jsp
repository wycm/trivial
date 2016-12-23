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
<script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>考试题目修改</title>
</head>
<body>
<div class="pd-20">
  <form action="admin/school/modifyExamQuestion"  method="post" class="form form-horizontal" id="form-exam-question-modify" enctype="multipart/form-data">
    <div class="row cl">
			<label class="form-label col-3"><span class="c-red">*</span>所属考试：</label>
			<div class="formControls col-5">
			<span class="select-box">
				<select name="examId" class="select">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select>
				</span>
			</div>
	</div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>考试题目：</label>
      <div class="formControls col-5">
      	<textarea id="question" name="question" cols="" rows="" class="textarea" datatype="*1-200" dragonfly="true" nullmsg="问题不能为空！" onKeyUp="textarealength(this,200)"></textarea>
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>选项A：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" placeholder="" id="optionA" value="${examQuestion.optionA}" name="optionA" datatype="*1-200" dragonfly="true" nullmsg="答案不能为空！">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>选项B：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" placeholder="" id="optionB" value="${examQuestion.optionB}" name="optionB" datatype="*1-200" dragonfly="true" nullmsg="答案不能为空！">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>选项C：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" placeholder="" id="optionC" value="${examQuestion.optionC}" name="optionC" datatype="*1-200" dragonfly="true" nullmsg="答案不能为空！">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>选项D：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" placeholder="" id="optionD" value="${examQuestion.optionD}" name="optionD">
      </div>
      <div class="col-4"> </div>
    </div>
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red">*</span>答案：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" placeholder="" id="answer" value="${examQuestion.answer}" name="answer">
      </div>
      <div class="col-4"> </div>
    </div>
	<input type="hidden" name="id" value="${examQuestion.id}">
    <div class="row cl">
      <div class="col-9 col-offset-3">
        <input id="submit" class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;确认修改&nbsp;&nbsp;">
      </div>
    </div>
  </form>
</div>
<script type="text/javascript" src="res/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="res/lib/icheck/jquery.icheck.min.js"></script> 
<script type="text/javascript" src="res/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript" src="res/js/H-ui.js"></script> 
<script type="text/javascript" src="res/js/H-ui.admin.js"></script>
<script type="text/javascript">
$(function(){
	$("#question").val('${examQuestion.question}');
	$("#form-exam-question-modify").Validform({
		tiptype:2,
		callback:function(form){
			form[0].submit();
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
	$("#submit").click(function(){
		$("#form-exam-question-modify").submit();
		window.close();
	});
	/*设置select默认项*/
	var processId = ${exam-question.processId};
	var type = ${exam-question.type};
	$("[name='processId'] [value='" + processId + "']").attr("selected",true);//设置所属流程
	$("[name='type'] [value='" + type + "']").attr("selected",true);//设置课程类型
});
</script>
</body>
</html>