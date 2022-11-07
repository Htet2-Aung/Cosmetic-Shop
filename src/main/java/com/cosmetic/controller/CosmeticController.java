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
import java.io.PrintWriter;
import java.util.List;

import javax.sql.DataSource;

import com.cosmetic.model.UserDAO;
import com.cosmetic.model.Cosmetic;
import com.cosmetic.model.CosmeticDAO;
import com.cosmetic.model.User;

/**
 * Servlet implementation class ResultController
 */
public class CosmeticController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/cosmeticsShop")
	private DataSource dataSource;
	
	private CosmeticDAO cosmeticDAO;
	
	@Override
	public void init() throws ServletException {
		cosmeticDAO = new CosmeticDAO(dataSource);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CosmeticController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		
		if (user != null) {
		String mode = request.getParameter("mode");
		if(mode == null) {
			mode = "LIST";
		}
		
		switch (mode) {
		case "LIST":
			showCosmeticList(request, response);
			break;
		case "LOAD":
			loadProduct(request, response);
			break;
		case "CREATE":
			createProduct(request, response);
			break;
		case "UPDATE":
			updateProduct(request, response);
			break;
		case "DELETE":
			deleteProduct(request, response);
			break;
		case "LOGOUT":
			session.invalidate();
			response.sendRedirect("login");
			break;
		default:
			showCosmeticList(request, response);
			break;
		}
		
		}else {
			response.sendRedirect("login");
		}
		
		
	}
	

	private void showCosmeticList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		List<Cosmetic> cosmeticList = this.cosmeticDAO.getCosmeticList();
		request.setAttribute("cosmeticList", cosmeticList);
		RequestDispatcher rd = request.getRequestDispatcher("shoppingMore.jsp");
		rd.forward(request, response);
		
	}
	
	private void loadProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		int productId = Integer.parseInt(request.getParameter("productId"));
		Cosmetic cosmetic = this.cosmeticDAO.getProduct(productId);
		request.setAttribute("cosmetic", cosmetic);
		RequestDispatcher rd = request.getRequestDispatcher("update-product.jsp");
		rd.forward(request, response);
	}
	
	private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		String brand = request.getParameter("brand");
		String type = request.getParameter("type");
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		Cosmetic cosmetic = new Cosmetic(brand, type, price, quantity);
		
		int rowEffected = this.cosmeticDAO.createProduct(cosmetic);
		
		if(rowEffected > 0)
			showCosmeticList(request, response);
		
	}
	
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		int productId = Integer.parseInt(request.getParameter("productId"));
		String brand = request.getParameter("brand");
		String type = request.getParameter("type");
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
				
		Cosmetic cosmetic = new Cosmetic(productId,brand, type, price, quantity);
		int rowEffected = this.cosmeticDAO.updateProduct(cosmetic);
		
		if(rowEffected > 0)
			showCosmeticList(request, response);
	}
	
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user",user);
		int productId = Integer.parseInt(request.getParameter("productId"));
		int rowEffected = this.cosmeticDAO.deleteProduct(productId);
		
		if(rowEffected > 0)
			showCosmeticList(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
