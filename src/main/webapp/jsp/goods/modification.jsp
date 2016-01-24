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
	<div class="ibox-title">
		<button id="back" class="btn btn-primary " type="button"><i class="glyphicon glyphicon-chevron-left"></i>返回列表</button>
	</div>
	<div class="ibox-content">
		<form name="form" class="form-horizontal" ng-submit="processForm()">
			<input ng-model="goods.sid" type="hidden">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="goodsName">商品名称：</label>
				<div class="col-sm-10">
					<input ng-model="goods.name" name="goodsName" type="text" class="form-control"
						 ng-minlength="3" required name-validation ng-value="ccc">
					<span class="error" ng-show="form.goodsName.$error.required ">不能为空</span>
					<span class="error" ng-show="form.goodsName.$error.minlength ">长度不足3位</span>
					<span class="error" ng-show="form.goodsName.$error.exist ">已存在</span>
				</div>
			</div>
			<div class="hr-line-dashed"></div>
			<div class="form-group">
				<label  class="col-sm-2 control-label" title="通过空格分割">关键词：</label>
				<div class="col-sm-10">
					<input ng-model="goods.keyWord" class="form-control" name="keyWord" type="text">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">商品简介：</label>
				<div class="col-sm-10">
					<input ng-model="goods.selfDescribe" class="form-control" name="describe" type="text">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-2">
					<button class="btn btn-primary" ng-disabled="form.$invalid" type="submit">保存内容</button>
					<button class="btn btn-white reset" type="button" ng-click="resetWithCancel()">取消</button>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		var app = angular.module('goodsAddApp',[]);
		app.controller('goodsController',function($scope,$http){
			$scope.goods=JSON.parse('${goods}');
			//拷贝一份，用于重置
			$scope.initValue=angular.copy($scope.goods);
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
			$scope.resetWithCancel = function(e) {
				//重置为编辑前的值
				$scope.goods=angular.copy($scope.initValue);
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
		$(document).ready(function(){
			$('#back').on('click',function(){
				window.location.href='${ctx}/goods/list';
			});
		})
	</script>
</body>
</html>