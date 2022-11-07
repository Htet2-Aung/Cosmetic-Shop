package com.cosmetic.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class OrderDAO {

private final DataSource dataSource;
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	public OrderDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	private void close() {
		if(connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
	
	public List<Order> getOrderList() {
		List<Order> orderList = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from `order`;");
			
			while (rs.next()) {
				orderList.add(new Order(
						rs.getInt("orderId"),
						rs.getString("brand"),
						rs.getString("type"),
						rs.getInt("price"),
						rs.getInt("quantity"),
						rs.getInt("total"),
						rs.getString("email")));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return orderList;
		
		
	}
	public List<Order> getOrderList(String email) {
		List<Order> orderList = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from `order` where `email` ='"+email+"';");
			
			while (rs.next()) {
				orderList.add(new Order(
						rs.getInt("orderId"),
						rs.getString("brand"),
						rs.getString("type"),
						rs.getInt("price"),
						rs.getInt("quantity"),
						rs.getInt("total"),
						rs.getString("email")));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return orderList;
		
		
	}
	public Order getOrder(int orderId) {
		Order order = null;
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from `order` where `orderId` ='"+orderId+"';");
			
			while (rs.next()) {
				order = new Order(
						rs.getInt("orderId"),
						rs.getString("brand"),
						rs.getString("type"),
						rs.getInt("price"),
						rs.getInt("quantity"),
						rs.getInt("total"),
						rs.getString("email"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return order;
		
	}
	public int createOrder(Order order) {
		int rowEffected =0;
		
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement(
					"INSERT INTO `order` "+
			        "(`brand`, `type`, `price`, `quantity`, `total`,`email`) "+
					"VALUES (?, ?, ?, ?, ?, ?)"
					);
			pStmt.setString(1, order.getBrand());
			pStmt.setString(2, order.getType());
			pStmt.setInt(3, order.getPrice());
			pStmt.setInt(4, order.getQuantity());
			pStmt.setInt(5, order.getTotal());
			pStmt.setString(6,order.getEmail());
			
			rowEffected = pStmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
	}
	
	public int deleteOrder(int orderId) {
		int rowEffected = 0;
		
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("delete from `order` where `orderId` = ?;");
			pStmt.setInt(1, orderId);
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
		
	}
}
