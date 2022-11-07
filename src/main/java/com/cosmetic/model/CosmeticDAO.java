package com.cosmetic.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;




public class CosmeticDAO {

private DataSource dataSource;
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	public CosmeticDAO(DataSource dataSource) {
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
	
	public List<Cosmetic> getCosmeticList() {
		List<Cosmetic> cosmeticList = new ArrayList<>();
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from cosmetic;");
			
			while(rs.next()) {
				cosmeticList.add(new Cosmetic(
						rs.getInt("productId"),
						rs.getString("brand"),
						rs.getString("type"),
						rs.getInt("price"),
						rs.getInt("quantity")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return cosmeticList;
		
		
	}
	
	public Cosmetic getProduct(int productId) {
		Cosmetic cosmetic = null;
		
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from cosmetic where productId='"+productId+"';");
			
			while (rs.next()) {
				cosmetic = new Cosmetic(
						rs.getInt("productId"),
						rs.getString("brand"),
						rs.getString("type"),
						rs.getInt("price"),
						rs.getInt("quantity"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return cosmetic;
		
	}
	public int createProduct(Cosmetic cosmetic) {
		int roweffected =0;
		
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement(
					"INSERT INTO `cosmetic` "+
					"(`brand`, `type`, `price`, `quantity`)"+
					" VALUES (?,?,?,?);");
			pStmt.setString(1,cosmetic.getBrand());
			pStmt.setString(2,cosmetic.getType());
			pStmt.setInt(3,cosmetic.getPrice());
			pStmt.setInt(4,cosmetic.getQuantity());
			
			roweffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return roweffected;
		
	}
	public int updateProduct(Cosmetic cosmetic) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			
			pStmt = connection.prepareStatement(
					"UPDATE `cosmetic` SET "
					+ "`brand` = ?, "
					+ "`type` = ?, "
					+ "`price` = ?, "
					+ "`quantity` =? WHERE (`productId` = ?);"
					);
			pStmt.setString(1,cosmetic.getBrand());
			pStmt.setString(2,cosmetic.getType());
			pStmt.setInt(3,cosmetic.getPrice());
			pStmt.setInt(4,cosmetic.getQuantity());
			pStmt.setInt(5,cosmetic.getProductId());
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
	}

	
	public int deleteProduct(int productId) {
		int roweffected = 0;
		
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("delete from cosmetic where productId =?;");
			pStmt.setInt(1,productId);
			
			roweffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return roweffected;
		
	}
	

}
