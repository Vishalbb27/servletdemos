<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="user.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	<div class="user-details">
		<div class="user-info">
			<h2>User Information</h2>
			<p>Name : ${user.name }</p>
			<p>Email : ${user.email }</p>
			<p>Phone : ${user.phone }</p>
			<p>Address : ${user.address }</p>
		</div>
		<div class="flight-info">
			<p>Source : ${user.flight.sourcePlace.name }</p>
			<p>Destination : ${user.flight.destinationPlace.name }</p>
			<p>Departure Date : ${user.flight.departureTime }</p>
			<p>Total Price : ${total}</p>
			
		</div>
	</div>
	<a  href="payment.jsp">PAY</a>
	
</body>
</html>