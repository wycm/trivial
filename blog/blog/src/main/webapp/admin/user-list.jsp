<%@ page contentType="text/html;charst=UTF-8" pageEncoding="UTF-8" %>
<%@include file="common/common-path.jsp"%>
<html ng-app="myApp" ng-controller="myController">
<head>
    <%@include file="common/common-header.jsp"%>
    <title>用户列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
    用户中心 <span class="c-gray en">&gt;</span>
    用户管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" ng-click="batch_stop()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe631;</i> 批量停用</a>
            <a href="javascript:;" ng-click="batch_start()" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe601;</i> 批量启用</a>
        </span>
        <span class="r">共有数据：<strong>{{users.length}}</strong> 条</span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort" name="user-list">
            <thead>
            <tr class="text-c">
                <th width="25"><input type="checkbox" name="" ng-model="batchState" value="" ng-click="all(batchState)"></th>
                <th width="5%">ID</th>
                <th width="10%">用户名</th>
                <th width="20%">邮箱</th>
                <th>博客地址</th>
                <th width="15%">注册时间</th>
                <th width="10%">用户标识</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr class="text-c" ng-repeat="u in users">
                <td><input type="checkbox" value="{{u.id}}" name="id" ng-model="u.cbState"></td>
                <td>{{u.id}}</td>
                <td>{{u.username}}</td>
                <td>{{u.email}}</td>
                <td><a href="<%=basePath%>user/{{u.id}}" target="_blank"><%=basePath%>user/{{u.id}}</a>{{u.address}}</td>
                <td>{{u.registertime}}</td>
                <td class="td-status">
                    <span class="label {{states[u.throughFlag].class}} radius">{{states[u.throughFlag].value}}</span>
                </td>
                <td class="td-manage">
                    <a style="text-decoration:none" ng-click="toggleState(u)" href="javascript:;" title="{{states[u.throughFlag].manageTitle}}">
                        <i class="Hui-iconfont">
                            <span ng-if="u.throughFlag == 1">
                                &#xe631;
                            </span>
                            <span ng-if="u.throughFlag == 0">
                                &#xe6e1;
                            </span>
                        </i>
                    </a>
                </td>
            </tr>
            </tbody>
            <%--{{users}}--%>
        </table>
    </div>
</div>
<%@include file="common/common-footer.jsp"%>
<%@include file="common/common-script.jsp"%>
<script type="text/javascript" src="res/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
<!-- angular -->
<script type="text/javascript">
    var app = angular.module('myApp',[]);
    app.controller('myController',function ($scope,$http ){
//        $scope.users = [
//            {id:1,username:'卧颜沉默',email:'1057160387@qq.com',address:'北京市 海淀区',registerTime:'2016',throughFlag:'1'},
//            {id:2,username:'卧颜沉默',email:'1057160387@qq.com',address:'北京市 海淀区',registerTime:'2016',throughFlag:'0'},
//            {id:3,username:'卧颜沉默',email:'1057160387@qq.com',address:'北京市 海淀区',registerTime:'2016',throughFlag:'1'}
//        ];
        $scope.users = ${userList};
//        $http.get("admin/getUserList.json").success(function(response){
//            $scope.users = response;
//        })
        $scope.states = [
            {state:0,class:'label-defaunt',value:'停用',manageTitle:'启用',icon:'&#xe6e1;'},
            {state:1,class:'label-success',value:'已启用',manageTitle:'停用',icon:'&#xe631;'}
        ]
        //设置checkbox默认值
        angular.forEach($scope.users, function(data){
            data.cbState = false;
        });
        //审核单个
        $scope.toggleState = function (u) {
            layer.confirm("确认停用?",function(index){
                $http.get("admin/user-list?id=" + u.id)
                        .success(function(response){
                            u.throughFlag = u.throughFlag == 0?1:0;
                            layer.msg("操作成功!",{icon:6,time:1000})
                            layer.close(index);
                        });

            });
        };
        var ids = new Array();
        //全选
        $scope.all = function(state){
            if(state == true){
                angular.forEach($scope.users, function(data){
                    data.cbState = true;
                });
            } else{
                angular.forEach($scope.users, function(data){
                    data.cbState = false;
                });
            }
        }
        //批量停用
        $scope.batch_stop = function () {
            $scope.batch_manage(0);
        }
        //批量启用
        $scope.batch_start = function(){
            $scope.batch_manage(1);
        }
        /**
         *批量管理
         * @param manageFlag 1表示启用，0表示停用
         */
        $scope.batch_manage = function(manageFlag){
            $scope.flag = false;
            angular.forEach($scope.users, function(data){
                if(data.cbState == true){
                    $scope.flag = true;
                    ids.push(data.id);
                }
            });
            if(!$scope.flag){
                layer.msg('至少选择一项',{icon:5,time:1000});
                return ;
            }
            layer.confirm("确认批量" + (manageFlag == 1?'启用?':'停用?'),function(index){
                $http.get("admin/user-list?ids=" + ids).then(function(response){
                    angular.forEach($scope.users, function(data){
                        data.throughFlag = manageFlag;//切换为另一状态
                        data.cbState = 0;
                    });
                    $scope.batchState = 0;//设置checkbox为初始状态
                    layer.msg('操作成功',{icon:6,time:1000});
                    layer.close(index);
                });
            })

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
