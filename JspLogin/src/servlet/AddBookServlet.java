package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Book;
import domain.Cart;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");  
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");
		Cart cart = (Cart)request.getSession().getAttribute("cart"); //获得session，域对象
		
		Book book = new Book();
		book.setId(Integer.parseInt(id));
		book.setName(name);
		book.setPrice(Double.parseDouble(price));
		book.setQuantity(Integer.parseInt(quantity));
		
		cart.addBook(id, book); //加到购物车中
		Double totalPrice = cart.getTotalPrice();
		
		request.setAttribute("booklist", cart.showCart());   //传书的列表
		request.setAttribute("totalPrice", cart.getTotalPrice());		//请求域中  double转化为了一个对象Double（装箱）
		
//		out.print("id"+id);

//		request.getRequestDispatcher("showCart.jsp").forward(request, response);
//		用重定向，防止重复提交购物车
		response.sendRedirect("showCart.jsp?totalPrice="+totalPrice);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
