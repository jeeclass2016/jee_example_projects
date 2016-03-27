package com.imic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public void init() throws ServletException {
		message = "Hello Nice World. My name is IMIC";
	}
	
	public void doGet(HttpServletRequest request, 
						HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<h1>" + message + "</h1>");
	}
	
	public void destroy() {
		
	}
}
