<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>chart</title>
<script type="text/javascript" src="${ctx}/static/js/dev/jquery-2.1.1.js" ></script>
<script type="text/javascript" src="${ctx}/static/js/dev/highcharts.js" ></script>
</head>
<body>
	<div id="content">
		<div id="achart" class="chart"></div>
	</div>
	<script type="text/javascript">
		$(function(){
			var _json = {
					credits: {
			        	text: 'by keith',
			        	href: 'http://keith07.github.io'
			        },
			        legend: {
			            layout: 'horizontal',//图例的排列方式 horizontal(水平),vertical(垂直)
			            align: 'center',//图例的水平位置 left/center/right
			            verticalAlign: 'bottom',//图例的垂直位置 top/middle/bottom
			            borderWidth: 0//图例容器的边框宽度，默认是：0
			        }
			};
			var json = {
			        title: {
			            text: 'Monthly Average Temperature',
			        },
			        subtitle: {
			            text: 'Source: WorldClimate.com',
			        },
			        xAxis: {
			            categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun','Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
			        },
			        yAxis: {
			            title: {
			                text: 'Temperature (°C)'
			            }
			        },
			        tooltip: {
			            valueSuffix: '°C'
			        },
			        series: [{
			            name: 'Tokyo1',
			            type: 'column',
			            data: [{y:7.0,name:'sss'}, {y:6.9,name:'name1'}, {y:9.5,name:'name1'}, {y:14.5,name:'name1'}, {y:18.2,name:'name1'}, {y:21.5,name:'name1'}, {y:25.2,name:'name1'}, {y:26.5,name:'name1'}, {y:23.3,name:'name1'}, {y:18.3,name:'name1'}, {y:13.9,name:'name1'}, {y:9.6,name:'name1'}]
			        }, {
			            name: 'New York',
			            data: [{y:-0.2,name:'name1'}, {y:0.8,name:'name1'}, {y:5.7,name:'name1'}, {y:11.3,name:'name1'}, {y:17.0,name:'name1'}, {y:22.0,name:'name1'}, {y:24.8,name:'name1'}, {y:24.1,name:'name1'}, {y:20.1,name:'name1'}, {y:14.1,name:'name1'}, {y:8.6,name:'name1'}, {y:2.5,name:'name1'}]
			        }, {
			            name: 'Berlin',
			            data: [{y:-0.9,name:'name1'}, {y:0.6,name:'name1'}, {y:3.5,name:'name1'}, {y:8.4,name:'name1'}, {y:13.5,name:'name1'}, {y:17.0,name:'name1'}, {y:18.6,name:'name1'}, {y:17.9,name:'name1'}, {y:14.3,name:'name1'}, {y:9.0,name:'name1'}, {y:3.9,name:'name1'}, {y:1.0,name:'name1'}]
			        }, {
			            name: 'London',
			            data: [{y:3.9,name:'name1'}, {y:4.2,name:'name1'}, {y:5.7,name:'name1'}, {y:8.5,name:'name1'}, {y:11.9,name:'name1'}, {y:15.2,name:'name1'}, {y:17.0,name:'name1'}, {y:16.6,name:'name1'}, {y:14.2,name:'name1'}, {y:10.3,name:'name1'}, {y:6.6,name:'name1'}, {y:4.8,name:'name1'}]
			        }]
			    };
			$.extend(json,_json);
			$('#achart').highcharts(json);
		});
	</script>
</body>
</html>