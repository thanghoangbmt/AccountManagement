<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<form action="MainController" method="POST">
		Username: <input type="text" name="txtUsername"> <br>
		Password: <input type="password" name="txtPassword"> <br>
		Confirm Password: <input type="password" name="txtConfirmPassword"> <br>
		Fullname: <input type="text" name="txtFullname"> <br>
		<input type="submit" name="action" value="Register">
	</form>
	
	${requestScope.USERNAME_ERROR}
	${requestScope.PASSWORD_BLANK_ERROR}
	${requestScope.PASSWORD_NOT_MATCH}
	${requestScope.FULLNAME_ERROR}
	${requestScope.ERROR}
</body>
</html>