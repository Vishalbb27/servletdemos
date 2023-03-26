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

	<table style="border:1px solide black">
		<tr>
			<th>FlightId</th>
			<th>Airlines</th>
			<th>Source</th>
			<th>Destination</th>
			<th>Date</th>
			<th>Ticket Price</th>
			<th>Total</th>
			<th>Select Flight</th>
		</tr>
		<c:forEach var="flight" items="${flightDetails}">
			<tr>
				<td>F${flight.id }</td>
				<td>${flight.airline.name }</td>
				<td>${flight.sourcePlace.name }</td>
				<td>${flight.destinationPlace.name }</td>
				<td>${flight.departureTime }</td>
				<td>${seats }</td>
				<td>${flight.price }</td>
				
				<td><a href="UserLogin?flightid=${flight.id }">Select</a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>