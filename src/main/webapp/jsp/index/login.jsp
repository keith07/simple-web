<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/WEB-INF/layouts/include_js.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
<meta name="description" content="">
<meta name="author" content="">
<!-- STYLESHEETS -->
<!--[if lt IE 9]><script src="js/flot/excanvas.min.js"></script><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script><![endif]-->
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/cloud-admin.css">
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/font-awesome/css/font-awesome.min.css">
<!-- FONTS -->
<!-- 	<link href='http://fonts.useso.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'> -->
</head>
<body class="login">
	<!-- PAGE -->
	<section id="page">
		<!-- HEADER -->
		<header>
			<!-- NAV-BAR -->
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<div id="logo">
							<a href="index.html"><img src="${ctx}/static/_img/logo/logo-alt.png" height="40" alt="logo name" /></a>
						</div>
					</div>
				</div>
			</div>
			<!--/NAV-BAR -->
		</header>
		<!--/HEADER -->
		<!-- LOGIN -->
		<section id="login" class="visible">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<div class="login-box-plain">
							<h2 class="bigintro">Sign In</h2>
							<div class="divide-40"></div>
							<form role="form" action="${ctx}/main/doLogin" method="post">
								<div class="form-group">
									<label for="name">User</label>
									<i class="fa fa-user"></i>
									<input type="text" name="userName" value="${userName}" class="form-control required" data-msg-required="请输入用户名地址" id="userName">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password</label>
									<i class="fa fa-lock"></i>
									<input type="password" value="${userPass}" class="form-control required" name="userPass" id="userPass">
								</div>
								<label id="loginError" class="error">${errorMsg}</label>
								<div class="form-actions">
									<label class="checkbox">
										<input type="checkbox" class="uniform" value=""> Remember me
									</label>
									<button type="submit" class="btn btn-danger">Submit</button>
								</div>
							</form>
							<!-- SOCIAL LOGIN -->
							<div class="divide-20"></div>
							<div class="center">
								<strong>Or login using your social account</strong>
							</div>
							<div class="divide-20"></div>
							<div class="social-login center">
								<a class="btn btn-primary btn-lg"><i class="fa fa-facebook"></i></a>
								<a class="btn btn-info btn-lg"><i class="fa fa-twitter"></i></a>
								<a class="btn btn-danger btn-lg"><i class="fa fa-google-plus"></i></a>
							</div>
							<!-- /SOCIAL LOGIN -->
							<div class="login-helpers">
								<a href="#">Forgot Password?</a><br>
								Don't have an account with us? <a href="${ctx}/main/regist">Register now!</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!--/LOGIN -->
		<!-- REGISTER -->
		<section id="register">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<div class="login-box-plain">
							<h2 class="bigintro">Register</h2>
							<div class="divide-40"></div>
							<form role="form">
								<div class="form-group">
									<label for="exampleInputName">Full Name</label>
									<i class="fa fa-font"></i>
									<input type="text" class="form-control" id="exampleInputName">
								</div>
								<div class="form-group">
									<label for="exampleInputUsername">Username</label>
									<i class="fa fa-user"></i>
									<input type="text" class="form-control" id="exampleInputUsername">
								</div>
								<div class="form-group">
									<label for="exampleInputEmail1">Email address</label>
									<i class="fa fa-envelope"></i>
									<input type="email" class="form-control" id="exampleInputEmail1">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Password</label>
									<i class="fa fa-lock"></i>
									<input type="password" class="form-control" id="exampleInputPassword1">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword2">Repeat Password</label>
									<i class="fa fa-check-square-o"></i>
									<input type="password" class="form-control" id="exampleInputPassword2">
								</div>
								<div class="form-actions">
									<label class="checkbox">
										<input type="checkbox" class="uniform" value="">
										I agree to the <a href="#">Terms of Service</a> and <a href="#">Privacy Policy</a>
									</label>
									<button type="submit" class="btn btn-success">Sign Up</button>
								</div>
							</form>
							<!-- SOCIAL REGISTER -->
							<div class="divide-20"></div>
							<div class="center">
								<strong>Or register using your social account</strong>
							</div>
							<div class="divide-20"></div>
							<div class="social-login center">
								<a class="btn btn-primary btn-lg"><i class="fa fa-facebook"></i></a>
								<a class="btn btn-info btn-lg"> <i class="fa fa-twitter"></i></a>
								<a class="btn btn-danger btn-lg"><i class="fa fa-google-plus"></i></a>
							</div>
							<!-- /SOCIAL REGISTER -->
							<div class="login-helpers">
								<a href="#" onclick="swapScreen('login');return false;"> Back to Login</a> <br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!--/REGISTER -->
		<!-- FORGOT PASSWORD -->
		<section id="forgot">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<div class="login-box-plain">
							<h2 class="bigintro">Reset Password</h2>
							<div class="divide-40"></div>
							<form role="form">
								<div class="form-group">
									<label for="exampleInputEmail1">Enter your Email address</label>
									<i class="fa fa-envelope"></i>
									<input type="email" class="form-control" id="exampleInputEmail1">
								</div>
								<div class="form-actions">
									<button type="submit" class="btn btn-info">Send Me Reset Instructions</button>
								</div>
							</form>
							<div class="login-helpers">
								<a href="#" onclick="swapScreen('login');return false;">Back to Login</a><br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- FORGOT PASSWORD -->
	</section>
	<!--/PAGE -->
	<!-- JAVASCRIPTS -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- CUSTOM SCRIPT -->
	<script src="${ctx}/static/js/script.js"></script>
	<script>
		$(document).ready(function() {		
			App.setPage("login");  //Set current page
			App.init(); //Initialise plugins and elements
			$("form").validate();
			$(".form-control").bind('change',function(){
				if($('#loginError').text())
					$('#loginError').text('');
			});
		});
		function swapScreen(id) {
			$('.visible').removeClass('visible animated fadeInUp');
			$('#'+id).addClass('visible animated fadeInUp');
		}
	</script>
	<!-- /JAVASCRIPTS -->
</body>
</html>