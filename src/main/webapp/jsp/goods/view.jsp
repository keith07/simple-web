<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/WEB-INF/static/includes.jsp" %>
</head>
<body ng-app="goodsApp" >
	<div ng-controller="goodsController">
		<span>1{{goods.name}}</span>
		<span>1{{goods.keyWord}}</span>
	</div>
	<script type="text/javascript">
	var app = angular.module('goodsApp',[]);
	app.controller('goodsController',function($scope,$http){
		$scope.goods=JSON.parse('${goods}');
	});
	</script>
</body>
</html>