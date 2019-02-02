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
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>





	客户名：${user }

	<%
		Cart cart = (Cart) session.getAttribute("cart");
		ArrayList<Book> booklist = cart.showCart();
		Double totalPrice = cart.getTotalPrice();
	%>
	<div class="container">
		<div class="row">
			<div class="panel panel-primary">
			<div class="panel-heading">
				<div style="text-align:center; font-size:18px;" class="panel-title">
					显示订单
				</div>
			</div>
			<div class="panel-body">
				<table class="table table-striped">
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
				</div>
			</div>
			<h3>
				<a href="logout.jsp">退出</a>
			</h3>

		</div>
	</div>
</body>
</html>