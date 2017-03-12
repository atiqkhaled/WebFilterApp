<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
<div align = "center" style = "color : gray">
<h3>Enter Name and password 'jamil' to see Welcome page.</h3>
</div>
</br>
</br>
<%
String msg = (String) request.getAttribute("msg");
if(msg != null && msg.equalsIgnoreCase("not matched")) {
%>
<div align = "center" style = "color : red">
Your input parameter been filtered but not authentic !
</div>
<% } %>
</br>
<div align = "center">
<form action = "welcome" method = "post">
Name :<input type = "text" name = "name" /></br>
Password :<input type = "text" name = "pass" /></br>
<input type = "submit"/>
</form>
</div>
</body>
</html>