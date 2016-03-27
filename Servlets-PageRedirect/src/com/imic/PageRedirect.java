package com.imic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageRedirect extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, 
						HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("text/html");
		
		// New location to be redirected
      String site = new String("http://vnexpress.net/");

      response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
      response.setHeader("Location", site);    
	}
}
