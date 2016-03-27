package com.vietsci;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		
		Father fatherObj = (Father)context.getBean("fatherBean");
		fatherObj.introduceProfile();
		
		Son son = (Son) context.getBean("sonBean");
		son.introduceProfile();
	}
}
