package com.vietsci;


public class Payment {
	Order order;
	
	public Order getOrder() {
		return order;
	}
	// a setter method to inject the dependency.
	public void setOrder(Order order) {
		System.out.println("Inside setOrder." );
		this.order = order;
	}

	public void printOrder() {
		order.printOrderDetail();
	}
	
	 
}
