<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="form.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h3>Reset Password</h3>
	<p>${LoginCredentials.email}</p>
	<form method="post" action="ResetPassword">
		<label>Enter New Password :</label> <input type="password" name="newpassword" /> <input
			type="submit" name="Reset Password" />
	</form>
</body>
</html>