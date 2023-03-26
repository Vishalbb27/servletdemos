<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Name : ${user.name }</p>
	<p>Email : ${user.email }</p>
	<p>Phone : ${user.phone }</p>
	<p>Address : ${user.address }</p>
	<p>Source : ${user.flight.sourcePlace.name }</p>
	<p>Destination : ${user.flight.destinationPlace.name }</p>
	<p>Departure Date : ${user.flight.departureTime }</p>
	<p>Total Price : ${total}</p>
	<a href="payment.jsp">Complete the payment</a>
</body>
</html>