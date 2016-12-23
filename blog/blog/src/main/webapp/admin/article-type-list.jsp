<%@ page contentType="text/html;charst=UTF-8" pageEncoding="UTF-8" %>
<%@include file="common/common-path.jsp"%>
<html ng-app="myApp" ng-controller="articleTypeController">
<head>
    <%@include file="common/common-header.jsp"%>
    <title>title</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
    文章分类管理<span class="c-gray en">&gt;</span>
    文章分类列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" ng-click="add_article_type()" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe604;</i> 添加分类</a>
        </span>
        <span class="r">共有数据：<strong>{{atListSize}}</strong> 条</span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort" name="article-list">
            <thead>
            <tr class="text-c">
                <th width="5%">ID</th>
                <th width="10%">分类名</th>
                <th>linkname</th>
                <th width="15%">父分类</th>
                <th width="10%">操作</th>
            </tr>
            </thead>
            <tbody>
            <tr class="text-c" ng-repeat="at in articleTypeList">
                <td>{{at.id}}</td>
                <td>{{at.value}}</td>
                <td>{{at.linkname}}</td>
                <td>{{at.parArticleType.value}}</td>
                <td class="td-manage">
                    <a style="text-decoration:none" class="ml-5" ng-click="modify_article_type($index)" href="javascript:;" title="修改"><i class="Hui-iconfont">&#xe6e2;</i></a>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<%@include file="common/common-footer.jsp"%>
<%@include file="common/common-script.jsp"%>
<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
<script type="text/javascript" src="res/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<!-- angular -->
<script type="text/javascript">
    var app = angular.module('myApp',[]);
    app.controller('articleTypeController',function ($scope,$http){
        $scope.articleTypeList = ${articleTypeList}
        $scope.atListSize = $scope.articleTypeList.length;
        $scope.add_article_type = function(){
            layer_show('添加文章分类','admin/article-type/add-article-type',500,400);
        }
    });
</script>
<!-- angular结束 -->
<script type="text/javascript">
    $(function() {
        $('.table-sort').dataTable({
            "aaSorting": [[1, "desc"]],//默认第几个排序
            "bStateSave": true,//状态保存
            "aoColumnDefs": [
                {"orderable": false, "aTargets": [1,2,3]}// 制定列不参与排序
            ]
        });
        $('.table-sort tbody').on('click', 'tr', function () {
            if ($(this).hasClass('selected')) {
                $(this).removeClass('selected');
            }
            else {
                table.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }
        });
    });
</script>
</body>
</html>
