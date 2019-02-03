<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退出登录</title>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<%
		session.invalidate();
	%>
	<div class="container">
		<div class="row">
			<div class="jumbotron">
				<p style="text-align: center" class="text-primary small">您已成功退出</p>
			</div>
		</div>
	</div>
	<div class="text-align:center;">
		<a href="welcome.jsp">欢迎继续购买</a>
	</div>
</body>
</html>