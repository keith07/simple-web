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
<body ng-app="goodsAddApp" ng-controller="goodsController">
	<a href="${ctx}/goods/list" >返回列表</a>
	<form name="form" ng-submit="processForm()">
		<input ng-model="goods.sid" type="hidden">
		<div class="row">
			<label for="goodsName">商品名称：</label>
			<input ng-model="goods.name" name="goodsName" type="text" ng-minlength="3" required name-validation>
			<span class="error" ng-show="form.goodsName.$error.required ">不能为空</span>
			<span class="error" ng-show="form.goodsName.$error.minlength ">长度不足3位</span>
			<span class="error" ng-show="form.goodsName.$error.exist ">已存在</span>
		</div>
		<div class="row">
			<label title="通过空格分割">关键词：</label>
			<input ng-model="goods.keyWord" name="keyWord" type="text">
		</div>
		<div class="row">
			<label>商品简介：</label>
			<input ng-model="goods.selfDescribe" name="describe" type="text">
		</div>
		
		<input type="submit" ng-disabled="form.$invalid" value="提交">
	</form>
	<script type="text/javascript">
		var app = angular.module('goodsAddApp',[]);
		app.controller('goodsController',function($scope,$http){
			$scope.goods=JSON.parse('${goods}');
			$scope.processForm = function(isValid){
				$http({
					method:'POST',
					url:'save',
					data:$.param($scope.goods),
					headers:{ 'Content-Type': 'application/x-www-form-urlencoded' }
				}).success(function(data){
					console.log(data);
					if(!data.success){
						$scope.errorName = data.errors.name;
					}else{
						$scope.message = data.message;
						alert("保存成功");
						window.location.href='${ctx}/goods/list';
					}
				})
			};
		});
		//后台校验名称是否重复
		app.directive('nameValidation', function($http) {
			return {
				require : 'ngModel',
				link : function(scope,elm,attrs,ctrl){
					elm.bind('focusout',function(){
						$http({method:'POST',url:"exists",data:elm.val()}).
						success(function(data,status,headers,config){
							ctrl.$setValidity('exist',!data);
						})
					})
				}
			}
		});
	</script>
</body>
</html>