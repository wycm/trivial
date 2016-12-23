<%@ page contentType="text/html;charst=UTF-8" pageEncoding="UTF-8" %>
<%@include file="common/common-path.jsp"%>
<html ng-app="myApp" ng-controller="addArticleTypeController">
<head>
    <%@include file="common/common-header.jsp"%>
    <title>title</title>
</head>
<body>
<div class="pd-20">
    <form action="admin/article-type/add-article-type" method="post" class="form form-horizontal" id="add-article-type" name="form">
    <div class="row cl">
        <label class="form-label col-xs-3"><span class="c-red">*</span>父类型：</label>
        <div class="formControls col-xs-6"> <span class="select-box">
				<select name="pid" class="select" ng-model="pid">
                        <option  ng-repeat="at in articleTypeList" value="{{at.id}}">{{at.value}}</option>
                </select>
				</span>
        </div>
        <div class="col-xs-3"></div>
    </div>
    <div class="row cl">
        <label class="form-label col-xs-3"><span class="c-red">*</span>文章类型：</label>
        <div class="col-xs-6">
            <input type="text" class="input-text" name="atValue" datatype="*1-5" errormsg="1-5个字符" nullmsg="不能为空">
        </div>
        <div class="col-xs-3">
        </div>
    </div>
    <div class="pt-20 row cl">
        <div class="col-xs-3"></div>
        <div class="col-xs-6">
            <input type="submit" class="btn btn-block btn-primary" id="submit" ng-disabled="form.atValue.$invalid" ng-click="submit_data()" value="提交"/>
        </div>
    </div>
        </form>
</div>
<%@include file="common/common-script.jsp"%>
<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
<script type="text/javascript" src="res/lib/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript">
    var app = angular.module('myApp',[]);
    app.controller('addArticleTypeController',function ($scope,$http){
        $scope.articleTypeList = ${articleTypeList};
        $scope.atListSize = $scope.articleTypeList.length;
        $scope.submit_data = function(){
                layer.msg('点击提交按钮');
        }
    });
</script>
<script type="text/javascript">
    $(function(){
        $("#add-article-type").Validform({
            tiptype:2,
            callback:function(form){
                form[0].submit();
                var index = parent.layer.getFrameIndex(window.name);
                parent.$('.btn-refresh').click();
                parent.layer.close(index);
            }
        });
    });
</script>
</body>
</html>
