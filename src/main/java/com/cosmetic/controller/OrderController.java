package com.cosmetic.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import com.cosmetic.model.Cosmetic;
import com.cosmetic.model.CosmeticDAO;
import com.cosmetic.model.Order;
import com.cosmetic.model.OrderDAO;
import com.cosmetic.model.User;

/**
 * Servlet implementation class OrderController
 */
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/cosmeticsShop")
	private DataSource dataSource;
	
	private OrderDAO orderDAO;
	private CosmeticDAO cosmeticDAO;
	
	@Override
	public void init() throws ServletException {
		orderDAO = new OrderDAO(dataSource);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		if(mode == null) {
			mode = "SHOW";
		}
		switch (mode) {
		case "SHOW":
			showOrderList(request,response);
			break;
//		case "ADD":
//			createOrder(request,response);
//			break;
		case "DELETE":
			deleteOrder(request,response);
			break;
		case "CONTINUE":
			continueOrder(request,response);
			break;
			
		default:
			showOrderList(request,response);
			break;
		}
		
		
	}

	
	private void continueOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		List<Cosmetic> backCosmetic = this.cosmeticDAO.getCosmeticList();
		request.setAttribute("backCosmetic", backCosmetic);
		RequestDispatcher rd = request.getRequestDispatcher("shoppingMore.jsp");
		rd.forward(request, response);
		
	}

	private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		int rowEffected = this.orderDAO.deleteOrder(orderId);
		
		if(rowEffected > 0) {
			showOrderList(request, response);
		}
	}
	

private void showOrderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	request.setAttribute("user",user);
	String email = user.getEmail();
	List<Order> orderList = this.orderDAO.getOrderList(email);
	int netTotal = 0;
	for(Order order : orderList) {
		netTotal += order.getTotal();
	}
	request.setAttribute("netTotal", netTotal);
	request.setAttribute("orderList", orderList);
	RequestDispatcher rd = request.getRequestDispatcher("orderItem.jsp");
	rd.forward(request, response);
	
}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
