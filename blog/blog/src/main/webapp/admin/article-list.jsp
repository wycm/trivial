<%@ page contentType="text/html;charst=UTF-8" pageEncoding="UTF-8" %>
<%@include file="common/common-path.jsp"%>
<html  ng-app="myApp" ng-controller="myController">
<head>
    <%@include file="common/common-header.jsp"%>
    <title>title</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
    文章中心 <span class="c-gray en">&gt;</span>
    文章管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" ng-click="batch_del()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
        </span>
        <span class="r">共有数据：<strong>88</strong> 条</span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort" name="article-list">
            <thead>
            <tr class="text-c">
                <th width="5%"><input id="" name="ids" type="checkbox" ng-model="batchState" ng-click="all(batchState)"></th>
                <th width="5%">ID</th>
                <th width="10%">所属栏目</th>
                <th>标题</th>
                <th width="8%">点击</th>
                <th width="8%">作者</th>
                <th width="15%">更新时间</th>
                <th width="10%">操作</th>
            </tr>
            </thead>
            <tbody>
            <tr class="text-c" ng-repeat="a in articleList" ng-show="a.showFlag == 1">
                <td><input type="checkbox" value="1" name="id" ng-model="a.cbState"></td>
                <td>{{a.id}}</td>
                <td>{{a.articleType.value}}</td>
                <td>{{a.title}}</td>
                <td>{{a.visits}}</td>
                <td>{{a.user.username}}</td>
                <td>{{a.releasetime}}</td>
                <td class="td-manage">
                    <a style="text-decoration:none" class="ml-5" ng-click="article_del($index)" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
                </td>
            </tr>
            </tbody>
        </table>
        <%--{{articleList}}--%>
    </div>
</div>
<%@include file="common/common-footer.jsp"%>
<%@include file="common/common-script.jsp"%>
<script type="text/javascript" src="res/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
<!-- angular -->
<script type="text/javascript">
    var app = angular.module('myApp',[]);
    app.controller('myController',function ($scope,$http){
        $scope.articleList = ${articleList};
        //设置checkbox默认值
        $scope.i = 0;
        angular.forEach($scope.articleList, function (data) {
            data.cbState = false;
            data.showFlag = 1;//设置表格行默认显示
            data.index = ($scope.i)++;//设置索引
        });
        //删除单个元素
        $scope.article_del = function(index){
            layer.confirm('确认删除?',function(){
                $http.get("admin/article/delete?ids=" + $scope.articleList[index].id)
                        .success(function(response){
                            $scope.articleList[index].showFlag = 0;//隐藏
                            layer.msg("删除成功!",{icon:6,time:1000})
                        }).error(function (response) {
                            layer.msg("删除失败!",{icon:5,time:1000})
                });
            })
        }
        //全选
        $scope.all = function(state){
            if(state == true){
                angular.forEach($scope.articleList, function(data){
                    data.cbState = true;
                });
            } else{
                angular.forEach($scope.articleList, function(data){
                    data.cbState = false;
                });
            }
        }

        //批量删除
        $scope.batch_del = function(){
            var delIndexArray = new Array();
            var ids = new Array();
            $scope.flag = false;
            angular.forEach($scope.articleList, function(data){
                if(data.cbState == true){
                    $scope.flag = true;
                    ids.push(data.id);
                    delIndexArray.push(data.index);
                }
            });
            if(!$scope.flag){
                layer.msg('至少选择一项',{icon:5,time:1000});
                return ;
            }
            layer.confirm('确认批量删除?',function() {
                $http.get("admin/article/delete?ids=" + ids).success(function (response) {
                    var i = 0;
                    for (i = delIndexArray.length - 1; i >= 0; i--) {
                        $scope.articleList[delIndexArray[i]].showFlag = 0;//隐藏
                    }
                    layer.msg('操作成功', {icon: 6, time: 1000});
                }).error(function(response){
                    layer.msg('删除失败', {icon: 5, time: 1000});
                });
            });
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
                {"orderable": false, "aTargets": [0,2,3]}// 制定列不参与排序
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
