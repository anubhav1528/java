<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP TAG</title>
</head>
<body>
	<h2>Hello, my name is Duke. What's yours?</h2>
	<form method="get">
		<input type="text" name="username" size="25">
		<p></p>
		<input type="submit" value="Submit"> <input type="reset"
			value="Reset">
	</form>
	<c:if test="${fn:length(param.username) > 0}">
		<jsp:include page="response.jsp" />
	</c:if>
</body>
</html>