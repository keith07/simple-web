<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<%@ include file="/WEB-INF/layouts/include_js.jsp" %>
</head>
<body>
	<div class="form" id="loginWrap">
		<form action="${ctx}/main/doLogin" method="post">
			<div class="field">
				<span class="label">userName:</span>
				<input type="text" id="userName" name="userName">
			</div>
			<div class="field">
				<span class="label">userPass:</span>
				<input type="password" id="userPass" name="userPass">
			</div>
			<div>
				<input type="submit" name="submit" value="submit">
				<input type="reset" name="reset" value="reset">
				<input type="button" value="regist" onclick="regist()">
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function regist(){
			window.location = window._ctx_ + '/main/regist';
		}
	</script>
</body>
</html>