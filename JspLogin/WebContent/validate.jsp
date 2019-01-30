<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		session.setAttribute("user", username);
		
		if ("qin".equals(username) && ("123".equals(password))) {
			request.getRequestDispatcher("/welcome.jsp").forward(request, response);
		} else if (username == "" || password == "") {
			String msg = "请输入用户名或密码";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		} else {
			String msg = "用户名或密码错误，请重新输入";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	%>
</body>
</html>