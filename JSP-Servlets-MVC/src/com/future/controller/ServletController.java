package com.future.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.future.dto.LoginBeanDTO;
import com.future.service.LoginService;
import com.future.service.impl.LoginServiceImpl;

public class ServletController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final String LOGIN_SUCCESS_PAGE="pages/login-success.jsp";
	final String LOGIN_ERROR_PAGE="pages/login-error.jsp";
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginBeanDTO dto = new LoginBeanDTO();
		dto.setUserName(userName);
		dto.setPassword(password);
		request.setAttribute("beanDTO", dto);
		
		LoginService loginService = new LoginServiceImpl();
		boolean status = loginService.validate(userName, password); 
		RequestDispatcher rd;
		
		if (status) {
			rd = request.getRequestDispatcher(LOGIN_SUCCESS_PAGE);
		} else {
			rd = request.getRequestDispatcher(LOGIN_ERROR_PAGE);
		}
		rd.forward(request, response);	
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        doPost(request, response);  
    }  

}
