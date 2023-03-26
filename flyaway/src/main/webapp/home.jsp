<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Profile</h2>
	<p>Name : ${LoginCredentials.name }</p>
	<p>Name : ${LoginCredentials.email }</p>
	<p><a href="resetPassword.jsp">Reset Password</a></p>
	<h3>Admin Options</h3>
	<p><a href="PlaceController">Places</a></p>
	<p><a href="AirlineController">Airlines</a></p>
	<p><a href="FlightController">Flights</a></p>
</body>
</html>