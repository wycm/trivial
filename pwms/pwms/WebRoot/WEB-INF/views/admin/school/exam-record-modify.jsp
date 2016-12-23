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
<title>考试成绩修改</title>
</head>
<body>
<div class="pd-20">
  <form action="admin/school/modifyExamRecord"  method="post" class="form form-horizontal" id="form-exam-modify" enctype="multipart/form-data">
    <div class="row cl">
      <label class="form-label col-3"><span class="c-red"></span>成绩：</label>
      <div class="formControls col-5">
        <input type="text" class="input-text" value="${examRecord.score}" name="score" id="score" datatype="*" nullmsg="请输入考试成绩！">
      </div>
      <div class="col-4"> </div>
    </div>
	<input type="hidden" name="id" value="${examRecord.id}">
	<input type="hidden" name="id" value="${examRecord.examId}">
	<input type="hidden" name="id" value="${examRecord.userId}">
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
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	$("#form-exam-modify").Validform({
		tiptype:2,
		callback:function(form){
			form[0].submit();
			var index = parent.layer.getFrameIndex(window.name);
			parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
	$("#submit").click(function(){
		$("#form-exam-modify").submit();
		window.close();
	});
	/*设置select默认项*/
	var ss = ${exam.singleScore};
	$("[name='singleScore'] [value='" + ss + "']").attr("selected",true);//设置所属流程
});
</script>
</body>
</html>