<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Reset Password</h3>
	<p>${LoginCredentials.email}</p>
	<form method="post" action="ResetPassword">
		Enter New Password : <input type="password" name="newpassword" />
		<input type="submit" name="Reset Password" />
	</form>
</body>
</html>