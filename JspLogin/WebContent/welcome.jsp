<%@page import="com.jane.dao.impl.BookDaoImpl"%>
<%@page import="domain.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="domain.Book"%>
<%@page import="com.jane.dao.impl.BookDaoImpl"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>显示物品页面</title>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
	.footer{
		text-align:center;
		letter-spacing: 1em;
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
	<div class="container">
		<div class="row">
			<div class="panel-primary">
				<div class="panel-heading">
					<div class="panel-title"
						style="text-align: center; font-size: 18px;">商品列表</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped">

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
							<td><%=booklist.get(i).getAuthor()%></td>
							<td><a
								href="AddBookServlet?id=<%=booklist.get(i).getId()%>&name=<%=booklist.get(i).getName()%>&price=<%=booklist.get(i).getPrice()%>&quantity=<%=booklist.get(i).getQuantity()%>">yes</a></td>
						</tr>
						<%
							}
						%>

					</table>

				</div>
				<!-- end panel body -->
			</div>
			<!-- end panel-primary -->
			<div class="footer panel-footer">
				<%
					//如果第一页，first不显示
					if (pageIndex != 1) {
				%>
				
				<a href="welcome.jsp?i=1">First</a>
				<%
					}
				%>

				<%
					if (pageIndex != 1) {
				%>
				<a href="welcome.jsp?i=<%=pageIndex - 1%>"><<</a>
				<%
					}
				%>

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
				<a href="welcome.jsp?i=<%=pageIndex + 1%>">>></a> &nbsp;&nbsp;<a
					href="welcome.jsp?i=3">End</a>
				<%
					}
				%>

			</div>
			<%-- 购物车加到Session中 --%>

			<%
				if (session.getAttribute("cart") == null) {
					Cart cart = new Cart();
					session.setAttribute("cart", cart);
				} else {

					session.getAttribute("cart");
				}
			%>

		</div>
	</div>
</body>
</html>