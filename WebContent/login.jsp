<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="ISO-8859-1">
            <title>Login Page</title>
        </head>

        <body>
            <form action="MainController" method="POST">
                Username: <input type="text" name="txtUsername"> <br> Password: <input type="password" name="txtPassword"> <br>
                <input type="submit" name="action" value="Login">
            </form>

            <c:url var="register" value="MainController">
                <c:param name="action" value="Forward_Register"></c:param>
            </c:url>

            <a href="${register}">Register here</a>

            <h3 style="color: red;">${ERROR_MESSAGE}</h3>
            <h3 style="color: red;">
                Đà Nẵng gió cứ mặn vào tôi thêm nắng lửa táp trên cát trắng bóng núi xưa lặng yên vịnh biển mây ba chiều vào phố sông xanh .
            </h3>
            <h3 style="color: red;">${ERROR_MESSAGE} XH n�</h3>
        </body>

        </html>