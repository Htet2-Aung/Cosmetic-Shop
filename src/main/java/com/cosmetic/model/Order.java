package com.cosmetic.model;

public class Order {
	
	private int orderId;
	private String brand;
	private String type;
	private int price;
	private int quantity;
	private int total;
	private String email;
	
	public Order() {
		
	}

	

	public Order(String brand, String type, int price, int quantity, int total, String email) {
		super();
		this.brand = brand;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
		this.email = email;
	}



	public Order(int orderId, String brand, String type, int price, int quantity, int total, String email) {
		super();
		this.orderId = orderId;
		this.brand = brand;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
		this.email = email;
	}

	

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", brand=" + brand + ", type=" + type + ", price=" + price + ", quantity="
				+ quantity + ", total=" + total + "]";
	}

	
}
