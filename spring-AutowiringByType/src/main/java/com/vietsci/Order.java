package com.vietsci;


public class Order {
	private String orderId;
	private String product;
	private Double price;
	private int quantity;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Order() {
		System.out.println("Inside Order constructor." );
	}
	
	public void printOrderDetail() {
		System.out.println("Order: " + orderId + ", product: " + product +
				", price: " + price + ", quantity: " + quantity);
	}
	
	
}
