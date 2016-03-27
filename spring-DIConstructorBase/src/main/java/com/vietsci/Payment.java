package com.vietsci;


public class Payment {
	Order order;
	public Payment() {
	}
	public Payment(Order order) {
		System.out.println("Inside Payment constructor." );
		this.order = order;
	}
	
	public void printOrder() {
		order.printOrderDetail();
	}
	
	 
}
