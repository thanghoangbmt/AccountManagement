<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
</head>
<body>
	<form action="MainController">
		Username: <input type="text" name="txtUsername" value="${requestScope.USERNAME}" readonly="readonly"> <br>
		Password: <input type="password" name="txtPassword"> <br>
		Confirm Password: <input type="password" name="txtConfirmPassword"> <br>
		Fullname: <input type="text" name="txtFullname" value="${requestScope.FULLNAME}"> <br>
		<input type="submit" name="action" value="Update">
	</form>
	
	${requestScope.PASSWORD_BLANK_ERROR}
	${requestScope.PASSWORD_NOT_MATCH}
	${requestScope.FULLNAME_ERROR}
	${requestScope.ERROR}
</body>
</html>