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

import javax.sql.DataSource;

import com.cosmetic.model.Cosmetic;
import com.cosmetic.model.CosmeticDAO;
import com.cosmetic.model.Order;
import com.cosmetic.model.OrderDAO;
import com.cosmetic.model.User;

/**
 * Servlet implementation class AddToCartController
 */
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@Resource(name = "jdbc/cosmeticsShop")
	private DataSource dataSource;
	
	private CosmeticDAO cosmeticDAO;
	private OrderDAO  orderDAO;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		cosmeticDAO = new CosmeticDAO(dataSource);
		orderDAO = new OrderDAO(dataSource); 
				}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		if(mode == null) {
			mode = "BUY";
		}
		switch (mode) {
		case "BUY":
			buyProduct(request, response);
			break;
		case "ADD":
			addProduct(request, response);
			break;
		default:
			buyProduct(request, response);
			break;
		}
	}

	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		String email = user.getEmail();
		String brand = request.getParameter("brand");
		String type = request.getParameter("type");
		int total =Integer.parseInt( request.getParameter("total"));
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		Order order = new Order(brand, type, price, quantity, total,email);
		int rowEffected = this.orderDAO.createOrder(order);
		
		if(rowEffected > 0) {
			response.sendRedirect("order");
		}
			
		
	}
	private void buyProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		int productId = Integer.parseInt(request.getParameter("productId"));
		Cosmetic cosmeticCart = this.cosmeticDAO.getProduct(productId);
		request.setAttribute("cosmeticCart", cosmeticCart);
		RequestDispatcher rd = request.getRequestDispatcher("addToCart.jsp");
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
