<%@page import="java.text.Normalizer.Form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 out.println("Welcome To JSP");
%>
<form id="form-1" method="post" action="process.jsp">
<label>INPUT YOUR NAME-</label>
<input type="text" name="name"></input>
<br>
<input type="submit" value="login">
</form>
</body>
</html>