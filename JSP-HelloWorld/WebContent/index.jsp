<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%! int a = 10000; %>
<% 
out.println("Hello World " + a); 
%>
<h1><%= a %></h1>
<%-- This comment will not be visible in the page source --%>

</body>
</html>