<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] arr= {"Mubai", "Singapore","Malaysia"};
	pageContext.setAttribute("places", arr);
	%>
	<p>Using tags</p>
	<c:forEach var="place" items="${places }">
		${place.isbn} </br>
		${place.name} </br>
		${place.price} </br>
	</c:forEach>
</body>
</html>