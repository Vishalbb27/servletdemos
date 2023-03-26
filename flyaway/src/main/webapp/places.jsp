<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@page import="java.awt.print.Book"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h2>Enter the places</h2>

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<c:forEach var="place" items="${places}">
			<tr>
				<td>${place.id }</td>
				<td>${place.name }</td>
				<td><a href="PlaceUpdate?placeid=${place.id }">Update</a></td>
				<td><a href="PlaceDelete?placeid=${place.id }">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		Insert New Place : <a href="insertPlace.html">click here</a>
	</p>
	<p>
		Back to Home Page <a href="home.jsp">click here</a>
	</p>
</body>
</html>