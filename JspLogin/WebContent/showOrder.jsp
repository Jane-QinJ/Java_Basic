<%@page import="domain.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show order</title>
</head>
<body>
	<h1>show order</h1>
	

	<hr>

	客户名：${user }

	<%
		Cart cart = (Cart) session.getAttribute("cart");
		ArrayList<Book> booklist = cart.showCart();
		Double totalPrice = cart.getTotalPrice();
	%>
	<table border="1px" width="600">
		<tr>
			<th>id</th>
			<th>title</th>
			<th>price</th>
			<th>quantity</th>
		</tr>
		<%
			for (int i = 0; i < booklist.size(); i++) {
				Book book = booklist.get(i);
		%>
		<tr>
			<td><%=book.getId()%></td>
			<td><%=book.getName()%></td>
			<td><%=book.getPrice()%></td>
			<td><%=book.getQuantity()%></td>
		</tr>
		<%
			}
		%>
		<tr>
			<td colspan="4">totalPrice:<%=totalPrice%></td>
		</tr>
	</table>
	<h3>
		<a href="logout.jsp">退出</a>
	</h3>
</body>
</html>