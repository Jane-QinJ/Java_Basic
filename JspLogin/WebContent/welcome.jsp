<%@page import="com.jane.dao.impl.BookDaoImpl"%>
<%@page import="domain.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="domain.Book"%>
<%@page import="com.jane.dao.impl.BookDaoImpl" %>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border-collapse: collapse;
	text-align: center;
}

caption {
	font-size: 20px;
	font-weight: 700;
}
</style>
</head>
<body>
	<%
		ArrayList<Book> booklist = new BookDaoImpl().findAll(); //获取书集合，有七本

		int pageIndex = 1; //当前页

		int rowCount = booklist.size(); //总条数
		int pageSize = 3; //一页的条数

		//页面页数
		//有余数说明要多出一页存放那单独的一条
		int pageCount = rowCount % pageSize != 0 ? rowCount / pageSize + 1 : rowCount / pageSize;

		//共享参数i，代表页数
		String a = request.getParameter("i"); //期望显示那一页
		System.out.println(a);
		//防止初始时没有i值
		if (a != null) {
			pageIndex = Integer.parseInt(a);//用户点击页面的索引值
		}
		
		
	%>
	<center>
		<table border='1px' width=60%>
			<caption>商品列表</caption>
			<tr>
				<th>id</th>
				<th>price</th>
				<th>name</th>
				<th>info</th>
				<th>author</th>
				<th>add</th>
			</tr>
			<!-- i指当前商品的索引值  
			此语句控制了每页最多显示3条
			Math.min防止最后一页范围变为i<9 改用总条数7 i<7
			 -->
			<%
				for (int i = (pageIndex - 1) * pageSize; i < Math.min(pageIndex * pageSize, rowCount); i++) {
			%>
			<tr>
				<td><%=booklist.get(i).getId()%></td>
				<td><%=booklist.get(i).getPrice()%></td>
				<td><%=booklist.get(i).getName()%></td>
				<td><%=booklist.get(i).getInfo()%></td>
				<td><%=booklist.get(i).getAuthor() %></td>
				<td><a href="AddBookServlet?id=<%=booklist.get(i).getId()%>&name=<%=booklist.get(i).getName()%>&price=<%=booklist.get(i).getPrice()%>&quantity=<%=booklist.get(i).getQuantity()%>">yes</a></td>
			</tr>
			<%
				}
			%>

		</table>
		<br>

		<center>
			<%
				//如果第一页，first不显示
				if (pageIndex != 1) {
			%>
			<a href="welcome.jsp?i=1">first</a>
			<%
				}
			%>
			
			<%
				if(pageIndex != 1){
			%>
			<a href="welcome.jsp?i=<%=pageIndex - 1%>">prev</a>
			<%} %>
			
			<%
				//总页数
				int size = rowCount % pageSize != 0 ? rowCount / pageSize + 1 : rowCount / pageSize;
				for (int i = 1; i <= size; i++) {
			%>
			<a href="welcome.jsp?i=<%=i%>"><%=i%></a>
			<%
				}
			%>
			<!-- 如果最后一页，next和end不显示 -->
			<%			
				if (pageIndex != 3) {
			%>
			<a href="welcome.jsp?i=<%=pageIndex + 1%>">next</a> &nbsp;&nbsp;<a
				href="welcome.jsp?i=3">end</a>
			<%
				}
			%>
		</center>
	</center>
<%-- 购物车加到Session中 --%>

<%
	if(session.getAttribute("cart") == null){
	Cart cart = new Cart();
	session.setAttribute("cart", cart); 
	}else{
		
		session.getAttribute("cart");
	}
	
%>


</body>
</html>