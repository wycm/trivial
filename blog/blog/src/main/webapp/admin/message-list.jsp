<%@ page contentType="text/html;charst=UTF-8" pageEncoding="UTF-8" %>
<%@include file="common/common-path.jsp"%>
<html ng-app="myApp" ng-controller="messageController">
<head>
    <%@include file="common/common-header.jsp"%>
    <title>title</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
    留言管理<span class="c-gray en">&gt;</span>
    留言管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" ng-click="batch_del()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
            <a href="javascript:;" ng-click="batch_not_through()" class="btn btn-danger radius"><i class="Hui-iconfont">&#xe6e0;</i> 批量不通过</a>
            <a href="javascript:;" ng-click="batch_through()" class="btn btn-primary radius"><i class="Hui-iconfont">&#xe6e1;</i> 批量通过</a>
        </span>
        <span class="r">共有数据：<strong>88</strong> 条</span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort" name="message-list">
            <thead>
            <tr class="text-c">
                <th width="5%"><input id="" name="ids" type="checkbox" ng-model="batchState" ng-click="all(batchState)"></th>
                <th width="5%">ID</th>
                <th width="10%">用户</th>
                <th>留言内容</th>
                <th width="15%">留言时间</th>
                <th width="5%">通过状态</th>
                <th width="5%">审核状态</th>
                <th width="10%">操作</th>
            </tr>
            </thead>
            <tbody>
            <tr class="text-c" ng-repeat="m in messageList" ng-show="m.showFlag == 1">
                <td><input type="checkbox" value="1" name="id" ng-model="m.cbState"></td>
                <td>{{m.id}}</td>
                <td>{{m.username}}</td>
                <td>{{m.content}}</td>
                <td>{{m.time}}</td>
                <td>
                    <span class="label {{throughStates[m.throughFlag].class}} radius">{{throughStates[m.throughFlag].value}}</span>
                </td>
                <td>
                    <span class="label {{auditingStates[m.auditingFlag].class}} radius">{{auditingStates[m.auditingFlag].value}}</span>
                </td>
                <td class="td-manage">
                    <a style="text-decoration:none" ng-click="toggleState(m)" href="javascript:;" title="{{throughStates[m.throughFlag].manageTitle}}">
                        <i class="Hui-iconfont">
                            <span ng-if="m.throughFlag == 1">
                                &#xe631;
                            </span>
                            <span ng-if="m.throughFlag == 0">
                                &#xe6e1;
                            </span>
                        </i>
                    </a>
                    <a style="text-decoration:none" class="ml-5" ng-click="message_del($index)" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
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
    app.controller('messageController',function ($scope,$http){
        //设置checkbox默认值
        $scope.throughStates = [
            {state:0,class:'label-defaunt',value:'未通过',manageTitle:'审核通过',icon:'&#xe6e1;'},
            {state:1,class:'label-success',value:'已通过',manageTitle:'审核失败',icon:'&#xe631;'}
        ];
        $scope.auditingStates = [
            {state:0,class:'label-deaunt',value:'待审核'},
            {state:1,class:'label-success',value:'已审核'}
        ];
        $scope.messageList = ${messageList};
        angular.forEach($scope.messageList, function (data) {
            data.cbState = false;
            data.showFlag = 1;//设置表格行默认显示
        });
        //删除
        $scope.message_del = function(index){
            layer.confirm("确认删除?",function(){
                $http.get("admin/message/delete?ids=" + $scope.messageList[index].id)
                        .success(function(response){
                            $scope.messageList[index].showFlag = 0;
                            layer.msg("删除成功!",{icon:6,time:1000})
                        });
            })
        }
        $scope.toggleState = function(c){
            layer.confirm("确认" + (c.throughFlag == 0?'审核通过':'审核不通过') + '?',function(index){
                $scope.resultFlag  = c.throughFlag == 0?1:0;
                $http.get("admin/message/auditing?ids=" + c.id + "&throughFlag=" + $scope.resultFlag)
                        .success(function(response){
                            c.throughFlag = $scope.resultFlag;
                            c.auditingFlag = 1;
                            layer.msg("操作成功!",{icon:6,time:1000})
                            layer.close(index);
                        });

            });
        };
        //全选
        $scope.all = function(state){
            if(state == true){
                angular.forEach($scope.messageList, function(data){
                    data.cbState = true;
                });
            } else{
                angular.forEach($scope.messageList, function(data){
                    data.cbState = false;
                });
            }
        }
        //批量审核通过
        $scope.batch_through = function(){
            $scope.batch_manage(1);
        };
        //批量审核不通过
        $scope.batch_not_through = function(){
            $scope.batch_manage(0);
        }
        //批量管理
        $scope.batch_manage = function(manageFlag){
            $scope.checkedFlag = false;
            var ids = new Array();
            angular.forEach($scope.messageList, function(data){
                if(data.cbState == true){
                    ids.push(data.id);
                    $scope.checkedFlag = true;
                }
            });
            if(!$scope.checkedFlag){
                layer.msg('至少选中一项',{icon:5,time:1000});
                return false;
            }
            layer.confirm('确认批量审核' +　(manageFlag == 0?'不':'') + '通过?',function(index){
                $http.get("admin/message/auditing?ids=" + ids + "&throughFlag=" + manageFlag)
                        .success(function(response){
                    angular.forEach($scope.messageList, function(data){
                        if(data.cbState == true){
                            data.throughFlag = manageFlag;//切换为另一状态
                            data.cbState = 0;
                        }
                    });
                    $scope.batchState = 0;//设置checkbox为初始状态
                    layer.msg("操作成功!",{icon:6,time:1000})
                    layer.close(index);
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
