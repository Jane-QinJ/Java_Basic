<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>您已成功退出</center>
	<%session.invalidate(); %>
	<a href="welcome.jsp">return</a>
</body>
</html>