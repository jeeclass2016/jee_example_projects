<html>
<head>
<title>Using JavaBeans in JSP</title>
</head>
<body>
<jsp:useBean id="obj" class="com.future.Calculator"/>  
 <%
int rs=obj.add(5, 10);
out.print("Total of 5 and 10 is "+rs);
%>  
</body>
</html>
