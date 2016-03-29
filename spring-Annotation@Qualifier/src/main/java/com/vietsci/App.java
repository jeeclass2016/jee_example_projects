package com.vietsci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		System.out.println("Using @Required Annotation example");

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");

		Profile profile = (Profile) context.getBean("profile");
		profile.printAge();
		profile.printName();
	}
}
