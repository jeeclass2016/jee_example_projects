package com.vietsci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		obj.printHello();
	}
}
