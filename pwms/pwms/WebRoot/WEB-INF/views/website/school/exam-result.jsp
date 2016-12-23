<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>网上党校-考试结束</title>
<%@ include file="../path.jsp" %>
<link href="res/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="res/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="res/website/style/base.css" rel="stylesheet" type="text/css" />
<link href="res/website/style/style1.css" rel="stylesheet" type="text/css" />
<link href="res/lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
<style type="text/css">
*{margin:0;padding:0;word-wrap:break-word;}
body{
	font:12px/1.75 "瀹嬩綋", arial, sans-serif,'DejaVu Sans','Lucida Grande',Tahoma,'Hiragino Sans GB',STHeiti,SimSun,sans-serif;
	background:url(res/website/images/bg_a1.jpg) repeat-x center top;
}
a{color:#333;text-decoration:none;float:none;}
a:hover{text-decoration:underline;}
a img{border:none;} 
div,ul,li,p,form{padding: 0px; margin: 0px;list-style-type: none;}
em{font-style: normal;font-weight: normal;}
table {padding: 0px; margin: 0px auto;list-style-type: none;}
dt,dl,dd {padding: 0px; margin: 0px;list-style-type: none;}
form{margin:0px;padding:0px;}
tr {padding: 0px; margin: 0px;list-style-type: none;}
h1 {
	color:#F00;
    display: block;
    font-size: 2em;
    -webkit-margin-before: 0.67em;
    -webkit-margin-after: 0.67em;
    -webkit-margin-start: 0px;
    -webkit-margin-end: 0px;
    font-weight: bold;
}
h2 {
    display: block;
    font-size: 1.5em;
    -webkit-margin-before: 0.83em;
    -webkit-margin-after: 0.83em;
    -webkit-margin-start: 0px;
    -webkit-margin-end: 0px;
    font-weight: bold;
}
h3,h4{padding:0px; font-size:14px; font-weight:bold;}
.clear {clear:both;height:0px; overflow:hidden;}
.line{margin:8px;height:1px;font-size:0;border-top:1px solid #E5E5E5;margin-top:8px;}

* html, * html body {
background:url(res/website/images/bg_a1.jpg) repeat-x center top;
background-attachment:fixed;
height:100%;
}
* html { overflow:hidden;}
* html body { overflow:auto;}
* html #loading {
bottom:auto;
position:absolute;
right:0;
top: 0%;
left: 0%;
width:100%;
background-color: #E5E5E5;
z-index:1001;
height:expression(eval(document.documentElement.clientHeight));
}

#loading{
	position:fixed;
	top: 0%;
	left: 0%;
	width:100%;
	height:100%;
	background-color: #E5E5E5;
	z-index:1001;
	_height:500px;
}
.grapa{
	background:url(res/website/images/loadingbg.jpg) no-repeat top;
	width: 337px;
	height:97px;
	margin:100px auto 0px auto;
}
.graph {
	width:2px;
	margin-left:19px;
	margin-right:18px;
	margin-top:36px;
	height:46px;
	background-image: url(res/website/images/loading.jpg);
	background-repeat: no-repeat;
	background-position: left bottom;
}
.grapa #txt{
	text-align:right;
	float:right;
	left: 530px;
	width:40px;
	margin-top:13px;
	margin-right:20px;
	font-family:"Arial";
	font-size:13px;
}

.kchd { width:950px; margin:0 auto; height:90px;}
.kclogo {
	float:left;
	width:400px;
	margin-left: 20px;
}
.kctopr {
	float:right;
	width:400px;
	font-size: 14px;
	color: #004566;
	margin-top: 30px;
	margin-right: 15px;
}
.dbt{ margin-top:15px;
	}
.ztbg { margin:0;background:url(res/website/images/bg_a2.jpg) repeat-x center bottom;}
.ztbf1{
	width:950px;
	margin:0 auto;
	background-color:#FFFFFF;
	border-top: 1px solid #CCC;
	border-left:1px solid #CCC;
	border-right:1px solid #CCC;
}
.ztbf2{
	width:950px;
	margin:0 auto;
	background-color:#FFFFFF;
	border-left:1px solid #CCC;
	border-right:1px solid #CCC;
	border-bottom:1px solid #CCC;
}
.dibu{ padding-bottom:10px;}
.sjbf{ width:900px; margin:0 auto;}
.st{ width:860px; margin:0 auto;}
.sttm{
	color:#B50000;
	font-size:14px;
	margin-top:5px;
}
.stxx{ color:#000000; font-size:14px; padding-left:25px;}
.stda{
	font-size:14px;
	padding-left:15px;
	border: 1px solid #FFF;
}
.stda_bj{
	font-size:14px;
	padding-left:15px;
	background-color:#FF0;
	border: 1px solid #FC0;
}
.st_zq{
	font-size:14px;
	padding-left:15px;
	background-color:#d6ebc2;
	color:#6fac35;
	border: #6fac35 1px solid;
}
.st_cw{
	font-size:14px;
	padding-left:15px;
	background-color:#ffe2db;
	color:#cc3300;
	border: #cc3300 1px solid;
}

.zts1{ float:left; width:195px;}
.zts2{
	float:left;
	width:550px;
	background-image: url(http://dx.jgjy.gov.cn/images/xinb/d_1_bg.jpg);
	background-position: center top;
	background-repeat: repeat-x;
	font-size: 20px;
	line-height: 92px;
	color: #DC0E13;
	font-weight: bold;
	padding-left:124px;
}
.zts3{ float:right; width:81px;}
.ztl{ width:360px; float:left; margin-left:15px;}
.zjr { font-size:16px; color:#996600;font-weight: bold;}
.zjrjj {font-size:14px;}
.ztr{
	width:545px;
	float:right;
	border-left-width: 1px;
	border-left-style: dashed;
	border-left-color: #000000;
	margin-right: 15px;
}
.jybt { margin-left:20px;font-size:16px; color:#996600;font-weight: bold;}
.jynr { margin-left:10px; height:450px;overflow-y:scroll; font-size:14px; line-height:150%; padding-right:10px;}

.cj_z {width:880px; margin:0 auto;}
.cjbg { width:500px; height:500px; margin:20px auto;}
.cjbg_t { margin-left:70px;}

.exam_button{cursor:pointer;margin-top:3px;margin-bottom:2px;PADDING-RIGHT: 0px;PADDING-LEFT: 0px;FONT-SIZE: 18px;PADDING-BOTTOM: 0px;PADDING-TOP: 0px;FONT-FAMILY: "榛戜綋" color: #000;width:135px;border:0px;height:40px;background-image:url(res/website/images/btn_2.gif)}

.foot{background:url(res/website/images/bg_a3.jpg) repeat-x center top;}
.copyright{width:950px;margin:0px auto; padding-top:10px;text-align:center;line-height:24px;}
</style> 
<script src="res/lib/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
</head>
<body>
<%@ include file="../header.jsp" %>
<!-- 顶部结束 -->
<div class="clear"></div>
<!--内容页主体开始-->
<div class="ztbf1">
	<div class="zts1"><img src="res/website/images/d_11.jpg"></div>
	<div class="zts2">&nbsp;</div>
	<div class="zts3"><img src="res/website/images/d_2.jpg"></div>
</div>
<div class="clear"></div>
<div class="ztbg">
<div class="ztbf2 dibu">
<div class="cjbg">
<div><span style="float:left"><h1>成绩报告：</h1></span><span style="float:right; margin-top:5px;"><h2>你的总得分：<font color=red>${grade}</font> 分</h2></span></div>
<div class="line clear"></div>
<div class="cjbg_t"><h4>其中，单选题答对　<font color=red>${aqCount}</font>　题！</h4></div>
<div class="line clear"></div>
<div>　　本页面将在　<span id=CD style="color:red;">60</span>　秒后关闭！可以到成绩中心查看成绩！</div>
<script type="text/javascript"> 
var tt=60;
var crd;
crd=setInterval(function(){tt=tt-1;$('#CD').text(tt);if(tt<1){clearInterval(crd);window.close(this);}},1000);

</script>
</div>
</div>
<div style="height:2px;"></div>
</div>
<!--内容页主体结束-->
<div class="clear"></div>
<div class="foot">
<div class="copyright">四川理工学院经管学院党支部　版权所有<br/></div>
</div>
<script type="text/javascript"> 
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-21978991-1']);
  _gaq.push(['_setDomainName', '.jgjy.gov.cn']);
  _gaq.push(['_trackPageview']);
  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
</script>
</body>
</html>
