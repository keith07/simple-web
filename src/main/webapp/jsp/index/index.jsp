<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>test</title>
</head>
<body>
			<table id="myTable"> 
				<thead>
					<tr>
						<th>Account #</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Age</th>
						<th>Total</th>
						<th>Discount</th>
						<th>Difference</th>
						<th>Date</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>A42b</td>
						<td>Peter</td>
						<td>Parker</td>
						<td>28</td>
						<td>$9.99</td>
						<td>20.9%</td>
						<td>+12.1</td>
						<td>Jul 6, 2006 8:14 AM</td>
					</tr>
					<tr>
						<td>A255</td>
						<td>Bruce</td>
						<td>Jones</td>
						<td>33</td>
						<td>$13.19</td>
						<td>25%</td>
						<td>+12</td>
						<td>Dec 10, 2002 5:14 AM</td>
					</tr>
					<tr>
						<td>A33</td>
						<td>Clark</td>
						<td>Evans</td>
						<td>18</td>
						<td>$15.89</td>
						<td>44%</td>
						<td>-26</td>
						<td>Jan 12, 2003 11:14 AM</td>
					</tr>
					<tr>
						<td>A1</td>
						<td>Bruce</td>
						<td>Almighty</td>
						<td>45</td>
						<td>$153.19</td>
						<td>44.7%</td>
						<td>+77</td>
						<td>Jan 18, 2001 9:12 AM</td>
					</tr>
					<tr>
						<td>A102</td>
						<td>Bruce</td>
						<td>Evans</td>
						<td>22</td>
						<td>$13.19</td>
						<td>11%</td>
						<td>-100.9</td>
						<td>Jan 18, 2007 9:12 AM</td>
					</tr>
					<tr>
						<td>A42a</td>
						<td>Bruce</td>
						<td>Evans</td>
						<td>22</td>
						<td>$13.19</td>
						<td>11%</td>
						<td>0</td>
						<td>Jan 18, 2007 9:12 AM</td>
					</tr>
				</tbody>
			</table>
<script type="text/javascript">
$(document).ready(function () {
	$("#leftMenu").foldingMenu();
	$("#myTable").tablesorter({theme:'blue',widgets:['zebra']});
});
</script>
</body>
</html>