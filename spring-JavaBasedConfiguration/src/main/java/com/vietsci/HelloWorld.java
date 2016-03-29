package com.vietsci;


public class HelloWorld {
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public void printHello() {
		System.out.println("Spring using JAVA Based Configuration says : Hello ! " + name);
	}
}
