<%@page import="domain.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="domain.Book" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Show Cart</h1>
	
	<%Cart cart = (Cart)session.getAttribute("cart");
		ArrayList<Book> bookList = cart.showCart();
		Double totalPrice = cart.getTotalPrice();
		%>
	<%--修改为表单 --%>
<form action="updateServlet" method="post">
	<table border="1" width="60%" bordercolor="green">
		<tr>
			<th>id</th>
			<th>title</th>
			<th>price</th>
			<th>quantity</th>
			<th>delete</th>
		</tr>
		<a href="welcome.jsp">return hall</a>
		<%
		for(int i = 0;i<bookList.size();i++){
			Book book = bookList.get(i);
		
		%>
		<tr>
			<td><%=book.getId() %><input type="hidden" name="id" value="<%=book.getId()%>"></td>
			<td><%=book.getName() %></td>
			<td><%=book.getPrice() %></td>
			<td><input type="text" name="quantity"
					value="<%=book.getQuantity()%>"></td>
			<td><a href="deleteServlet?id=<%=book.getId()%>">delete</a></td>
		</tr>
		
		
		<%} %>
			<tr>
			<td colspan="5">totalPrice<%=totalPrice %></td>
			
			</tr>
			<tr>
				<td colspan="5"><input name="update" type="submit" value="update"></td> 
			</tr>
	</table>
	<h3><a href="showOrder.jsp">submit order</a></h3>
</form>
	

</body>
</html>