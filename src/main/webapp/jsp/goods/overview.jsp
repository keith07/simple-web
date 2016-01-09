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
	<a href="${ctx}/goods/0">添加</a>
	<table id="myTable" ng-controller="goodsController"> 
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
					<a href="${ctx}/goods/{{goods.sid}}">修改</a>
					<a href="#" ng-click="del(goods)">删除</a>
				</td>
			</tr>
		</tbody>
	</table>
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
		$("#myTable").tablesorter({theme:'blue',widgets:['zebra']});
		
	});
	</script>
</body>
</html>