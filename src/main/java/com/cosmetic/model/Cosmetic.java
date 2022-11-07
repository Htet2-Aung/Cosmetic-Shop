package com.cosmetic.model;

public class Cosmetic {
	
	private int productId;
	private String brand;
	private String type;
	private int price;
	private int quantity;
	
	public Cosmetic() {
		
	}

	public Cosmetic(String brand, String type, int price, int quantity) {
		super();
		this.brand = brand;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	}

	public Cosmetic(int productId, String brand, String type, int price, int quantity) {
		super();
		this.productId = productId;
		this.brand = brand;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	@Override
	public String toString() {
		return "Cosmetic [productId=" + productId + ", brand=" + brand + ", type=" + type + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	
}
