<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<%@ include file="/WEB-INF/static/includes.jsp"%>
</head>
<body>
	<div class="middle-box text-center loginscreen  animated fadeInDown">
		<div>
			<div>
				<h1 class="logo-name">H+</h1>
			</div>
			<h3>欢迎使用 H+</h3>
			<form class="m-t" role="form" action="${ctx}/main/doLogin" method="post">
				<div class="form-group">
					<input type="text" id="userName" name="userName" class="form-control" 
						placeholder="用户名" required="">
				</div>
				<div class="form-group">
					<input type="password" id="userPass" name="userPass" class="form-control" 
						placeholder="密码" required="">
				</div>
				<button type="submit" class="btn btn-primary block full-width m-b">登录</button>
				<p class="text-muted text-center">
					<a href="login.html#"><small>忘记密码了？</small></a> | <a
						href="${ctx}/main/regist">注册一个新账号</a>
				</p>

			</form>
		</div>
	</div>
	<script type="text/javascript">
		function regist(){
			window.location = window._ctx_ + '/main/regist';
		}
	</script>
</body>
</html>