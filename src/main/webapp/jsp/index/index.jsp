<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Keith's HOME</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	    
	    <!-- CSS================================================== -->
		<link rel="stylesheet" href="${ctx}/static/css/zerogrid.css">
		<link rel="stylesheet" href="${ctx}/static/css/style.css">
	    <link rel="stylesheet" href="${ctx}/static/css/responsive.css">
		<link rel="stylesheet" href="${ctx}/static/css/responsiveslides.css" />
		
		<link href='${ctx}/static/_img/favicon.ico' rel='icon' type='image/x-icon'/>
		<%@ include file="/WEB-INF/layouts/include_js.jsp" %>
		<script src="${ctx}/static/js/responsiveslides.js"></script>
		<script>
	    $(function () {
	      $("#slider").responsiveSlides({
	        auto: true,
	        pager: false,
	        nav: true,
	        speed: 500,
	        maxwidth: 960,
	        namespace: "centered-btns"
	      });
	    });
	  </script>
	</head>
<body>
	<div class="container">
<!--------------Header--------------->
<header> 
	<div id="logo"><a href=""><img src="${ctx}/static/_img/logo.png"/></a></div>
  <nav>
		<ul class="menu">
			<li><a href="index.html">Home</a></li>
			<li><a href="blog.html">Blog</a></li>
			<li><a href="column2.html">Column 2</a></li>
			<li><a href="column3.html">Column 3</a></li>
		</ul>
		<div class="minimenu"><div>MENU</div>
			<select>
				<option>Home</option>
				<option>Blog</option>
				<option>Gallery</option>
				<option>Contact</option>
				<option>About</option>
			</select>
		</div>
	</nav>
</header>
	
<div class="feature">	
	<div class="rslides_container">
		<ul class="rslides" id="slider">
			<li><img src="${ctx}/static/_img/1.jpg"/></li>
			<li><img src="${ctx}/static/_img/2.jpg"/></li>
			<li><img src="${ctx}/static/_img/3.jpg"/></li>
			<li><img src="${ctx}/static/_img/4.jpg"/></li>
		</ul>
	</div>
</div>	

<!--------------Content--------------->
<section id="content">
	<div class="zerogrid">
		<div class="row block">

			<div class="main-content col08">
				<div class="row">
					<div class="col04 offleft">
						<article>
							<div class="heading">
								<img src="${ctx}/static/_img/thumb1.jpg"/>
								<h2><a href="#">This is Just Going To Be Another Test Post</a></h2>
							</div>
							<div class="content">
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed faucibus, lectus at varius tincidunt, tellus urna molestie ligula, aliquam luctus nisl nisi sed ante. Pellentesque...</p>
							</div>
							<div class="footer">
								<p class="more"><a href="#">Read more >></a></p>
							</div>
						</article>
						<article>
							<div class="heading">
								<img src="${ctx}/static/_img/thumb2.jpg"/>
								<h2><a href="#">This is Just Going To Be Another Test Post</a></h2>
							</div>
							<div class="content">
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed faucibus, lectus at varius tincidunt, tellus urna molestie ligula, aliquam luctus nisl nisi sed ante. Pellentesque...</p>
							</div>
							<div class="footer">
								<p class="more"><a href="#">Read more >></a></p>
							</div>
						</article>
					</div>
					<div class="col04 offright">
						<article>
							<div class="heading">
								<img src="${ctx}/static/_img/thumb3.jpg"/>
								<h2><a href="#">This is Just Going To Be Another Test Post</a></h2>
							</div>
							<div class="content">
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed faucibus, lectus at varius tincidunt, tellus urna molestie ligula, aliquam luctus nisl nisi sed ante. Pellentesque...</p>
							</div>
							<div class="footer">
								<p class="more"><a href="#">Read more >></a></p>
							</div>
						</article>
						<article>
							<div class="heading">
								<img src="${ctx}/static/_img/thumb4.jpg"/>
								<h2><a href="#">This is Just Going To Be Another Test Post</a></h2>
							</div>
							<div class="content">
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed faucibus, lectus at varius tincidunt, tellus urna molestie ligula, aliquam luctus nisl nisi sed ante. Pellentesque...</p>
							</div>
							<div class="footer">
								<p class="more"><a href="#">Read more >></a></p>
							</div>
						</article>
					</div>
				</div>
			</div>
			
			<div class="sidebar col05 offall" style="float:right;">
				<section>
					<div class="heading">Categories</div>
					<div class="content">
						<ul class="list">
							<li><a href="#">Free Html5 Templates</a></li>
							<li><a href="#">Free Css3 Templates</a></li>
							<li><a href="#">Free Responsive Html5 Templates</a></li>
							<li><a href="#">Free Basic Html5 Templates</a></li>
							<li><a href="#">Free Layout Html5 Templates</a></li>
						</ul>
					</div>
				</section>
				<section>
					<div class="heading">Links List</div>
					<div class="content">
					<ul class="list">
						<li><a href="#">Free html5 templates</a></li>
						<li><a href="#">Free css3 menus</a></li>
						<li><a href="#">Free responsive html5 themes</a></li>
						<li><a href="#">Free onepage html5 themes</a></li>
						<li><a href="#">Free animated html5 themes</a></li>
					</ul>
					</div>
				</section>
				<section>
					<div class="heading">Popular Post</div>
					<div class="content">
						<section>
							<img src="${ctx}/static/_img/thumb5.jpg"/>
							<h4><a href="#">Sample post with, links, paragraphs and comments</a></h4>
							<p>Nulla facilisi. Ut fringilla. Suspendisse potenti. Nunc feugiat mi a tellus consequat imperdiet. Vestibulum sapien. Proin quam. Etiam ultrices.</p>
						</section>
						<section>
							<img src="${ctx}/static/_img/thumb6.jpg"/>
							<h4><a href="#">This is Just Going To Be Another Test Post</a></h4>
							<p>Nulla facilisi. Ut fringilla. Suspendisse potenti. Nunc feugiat mi a tellus consequat imperdiet. Vestibulum sapien. Proin quam. Etiam ultrices.</p>
						</section>
						<section>
							<img src="${ctx}/static/_img/thumb7.jpg"/>
							<h4><a href="#">This Is Going To Be A Decent Length Title With Little Text</a></h4>
							<p>Nulla facilisi. Ut fringilla. Suspendisse potenti. Nunc feugiat mi a tellus consequat imperdiet. Vestibulum sapien. Proin quam. Etiam ultrices.</p>
						</section>
					</div>
				</section>
			</div>
			<div class="sidebar col03 offall" style="float:right;">
				<section>
					<div class="heading">About us</div>
					<div class="content">
						Free Basic Html5 Templates created More Templates. You can use and modify the template for both personal and commercial use. You must keep all copyright information and credit links in the template and associated files.
					</div>
				</section>
				<section>
					<div class="heading">Archives</div>
					<div class="content">
						<ul class="list">
							<li><a href="#">December 2014</a></li>
							<li><a href="#">November 2014</a></li>
							<li><a href="#">Octover 2014</a></li>
							<li><a href="#">September 2014</a></li>
						</ul>
					</div>
				</section>
				<section>
					<div class="heading">Links List</div>
					<div class="content">
					<ul class="list">
						<li><a href="#">Free html5 templates</a></li>
						<li><a href="#">Free css3 menus</a></li>
						<li><a href="#">Free responsive html5 themes</a></li>
						<li><a href="#">Free onepage html5 themes</a></li>
						<li><a href="#">Free animated html5 themes</a></li>
					</ul>
					</div>
				</section>
			</div>
		</div>
	</div>
</section>
<!--------------Footer--------------->
<footer>
	<div class="zerogrid">
		<div class="row">
			<section class="col-1-3">
				<div class="heading">About us</div>
				<div class="content">
					Free Basic Html5 Templates created More Templates. You can use and modify the template for both personal and commercial use. You must keep all copyright information and credit links in the template and associated files.
				</div>
			</section>
			<section class="col-1-3">
				<div class="heading">Categories</div>
				<div class="content">
					<ul>
						<li><a href="#">Free Html5 Templates</a></li>
						<li><a href="#">Free Css3 Templates</a></li>
						<li><a href="#">Free Responsive Html5 Templates</a></li>
						<li><a href="#">Free Basic Html5 Templates</a></li>
						<li><a href="#">Free Layout Html5 Templates</a></li>
					</ul>
				</div>
			</section>
			<section class="col-1-3">
				<div class="heading">Featured Post</div>
				<div class="content">
					<table border="0px">
						<tr>
							<td><img src="${ctx}/static/_img/thumb5.jpg"/></td>
							<td><img src="${ctx}/static/_img/thumb6.jpg"/></td>
							<td><img src="${ctx}/static/_img/thumb7.jpg"/></td>
						</tr>
						<tr>
							<td><img src="${ctx}/static/_img/thumb6.jpg"/></td>
							<td><img src="${ctx}/static/_img/thumb7.jpg"/></td>
							<td><img src="${ctx}/static/_img/thumb5.jpg"/></td>
						</tr>
					</table>
				</div>
			</section>
		</div>
	</div>
</footer>

<div id="copyright">
	<p>Copyright &copy; 2014.Company name All rights reserved.</p>
</div>
</div>
</body>
</html>