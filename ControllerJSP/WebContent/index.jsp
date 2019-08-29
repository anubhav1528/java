<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<c:if test="${ERROR!=null}">
<c:forEach var="e" items="${ERROR}">
<span style="color:red">**${e}**</span><br>
</c:forEach>
</c:if>
<c:if test="${SUCCESS!=null}">
${SUCCESS}
</c:if>
<body>
	<h1>Add A New League....</h1>
	<br />
	<form id="form-1" action="check.do" method="post">
		<label for="input-1">League Title</label> <input id="input-1"
			name="title" required type="text" /><br /> <label
			for="input-2">Year</label> <input id="input-2" name="year" type="text" /><br /> <label for="input-3">Season</label> <select
			name="season">
			<option value="Unknmown">Select...</option>
			<option value="Summer">SUMMER</option>
			<option value="Winter">WITER</option>
			<option value="Autumn">Autumn</option>
			<option value="Spring">Spring</option>
		</select><br /> <input type="submit" value="Add League" id="button-1" /> <input
			type="reset" value="Reset" id="button-2" />
	</form>
</body>
</html>