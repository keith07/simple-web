<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title><sitemesh:write property='title'/></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/style.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/theme.blue.css" />
<%@ include file="/WEB-INF/static/include_js.jsp" %>
<sitemesh:write property='head'/>
</head>
<body>
	<div id="northDiv">
		<ul id="mainMenu" class="menu float-ul">
			<li class="current"><a href="#" onclick="">概览</a></li>
			<li><a href="#" onclick="">列表</a></li>
			<li><a href="#" onclick="">设置</a></li>
		</ul>
	</div>
	<div id="center">
		<div id="leftDiv">
			<ul id="leftMenu" class="menu">
				<li class="active"><a href="#"><i class="fa fa-home"></i>Home </a></li>
				<li><a href="#"><i class="fa fa-glass"></i>Events </a></li>
				<li><a href="#"><i class="fa fa-file-image-o"></i>Gallery </a><!-- <span class="jquery-accordion-menu-label">12</span> --></li>
				<li><a href="#" class="hasSub"><i class="fa fa-cog"></i>Services </a>
					<ul class="submenu">
						<li><a href="#">Web Design </a></li>
						<li><a href="#">Hosting </a></li>
						<li><a href="#" class="hasSub">Design </a>
							<ul class="submenu">
								<li><a href="#">Graphics </a></li>
								<li><a href="#">Vectors </a></li>
								<li><a href="#">Photoshop </a></li>
								<li><a href="#">Fonts </a></li>
							</ul>
						</li>
						<li><a href="#">Consulting </a></li>
					</ul>
				</li>
				<li><a href="#"><i class="fa fa-home"></i>系统管理 </a></li>
				<li><a href="#" class="hasSub"><i class="fa fa-suitcase"></i>Portfolio </a>
					<ul class="submenu">
						<li><a href="#">Web Design </a></li>
						<li><a href="#">Graphics </a><span class="jquery-accordion-menu-label">10 </span></li>
						<li><a href="#">Photoshop </a></li>
						<li><a href="#">Programming </a></li>
					</ul>
				</li>
				<li><a href="#"><i class="fa fa-user"></i>About </a></li>
				<li><a href="#"><i class="fa fa-envelope"></i>Contact </a></li>
			</ul>
		</div>
		<div id="mainContent">
			<sitemesh:write property='body'/>
		</div>
		<div id="rightDiv"></div>
	</div>
	<div id="southDiv"></div>
</body>
<script type="text/javascript">
$(document).ready(function () {
	$("#leftMenu").foldingMenu();
	$("#myTable").tablesorter({theme:'blue',widgets:['zebra']});
});
</script>
</html>