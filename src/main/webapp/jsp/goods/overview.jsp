<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/static/includes.jsp" %>
</head>
<body ng-app="goodsApp">
	<div class="ibox-title">
		<button id="goodsAdd" class="btn btn-primary " type="button"><i class="glyphicon glyphicon-plus"></i>&nbsp;添加</button>
	</div>
	<div class="ibox-content wrapper">
		<div class="ibox">
			<div class="ibox-title">
				<span>商品信息</span>
			</div>
			<div class="ibox-content" style="min-height:735px">
				<table id="myTable" ng-controller="goodsController" class="table table-striped table-bordered table-hover dataTables"> 
					<thead>
						<tr>
							<th>商品名称</th>
							<th>关键词</th>
							<th>商品简介</th>
							<th class="sorter-false">操作</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="goods in goodses">
							<td>{{goods.name}}</td>
							<td>{{goods.keyWord}}</td>
							<td>{{goods.selfDescribe}}</td>
							<td>
								<div class="btn-group">
									<button data-toggle="dropdown" class="btn btn-primary btn-sm dropdown-toggle">操作<span class="caret"></span></button>
									<ul class="dropdown-menu">
										<li><a href="${ctx}/goods/{{goods.sid}}">修改</a></li>
										<li><a href="#" ng-click="del(goods)">删除</a></li>
									</ul>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	var app = angular.module('goodsApp',[]);
	app.controller('goodsController',function($scope,$http){
		$scope.goodses=JSON.parse('${goodses}');
		$scope.del = function(item){
			if(confirm("really delete?")){
				$http({method:'DELETE',url:'${ctx}/goods/'+item.sid})
				.success(function(){
					alert("delete success");
					$scope.goodses.splice(item,1);
				}).error(function(){
					alert("delete failed");
				});
			}
		}
	});
	$(document).ready(function () {
// 		$("#myTable").tablesorter({theme:'blue',widgets:['zebra']});
		$('.dataTables').dataTable();
		$("#goodsAdd").on('click',function(){
			window.location.href='${ctx}/goods/0';
		});
	});
	</script>
</body>
</html>