<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.future.dto.LoginBeanDTO" %>
<html>
<head>
<title>Login Success</title>
</head>
<body>
<p>You are successfully logged in!</p>
<%
	LoginBeanDTO dto = (LoginBeanDTO)request.getAttribute("beanDTO");
	out.println("Welcome " + dto.getUserName());
%>

</body>
</html>