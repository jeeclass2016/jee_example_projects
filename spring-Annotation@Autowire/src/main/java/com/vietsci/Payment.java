package com.vietsci;

import org.springframework.beans.factory.annotation.Autowired;


public class Payment {
	// @Autowired on Properties:
	@Autowired(required=false)
	Order order;
	
	// @Autowired on Constructors:
	@Autowired
	public Payment(Order order) {
		System.out.println("Inside Payment constructor." );
		this.order = order;
	}
	
	public Order getOrder() {
		return order;
	}
	
	// @Autowired on Setter Methods:
	@Autowired(required=false)
	public void setOrder(Order order) {
		this.order = order;
	}
	public void printOrder() {
		order.printOrderDetail();
	}
	
	 
}
