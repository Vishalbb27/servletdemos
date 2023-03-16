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
	<% java.util.Date mydate=new java.util.Date(); %>
	Time on the server is <%= mydate %>
	
	<c:set var="date" value="<%= new java.util.Date() %>"/>
	
	Todays date : ${date }
</body>
</html>