<%@page import="thangha.dto.AccountDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<p style="color: blue;">Welcome ${sessionScope.USER.fullname}</p>

	<form action="MainController">
		<input type="text" name="txtSearch" value="${sessionScope.SEARCH}">
		<input type="submit" name="action" value="Search">
	</form>

	<c:if test="${requestScope.LIST != null}">
		<c:if test="${not empty requestScope.LIST}">
			<table border="1">
				<thead>
					<tr>
						<th>NO</th>
						<th>Username</th>
						<th>Fullname</th>
						<th>Update</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="user" varStatus="counter"
						items="${requestScope.LIST}">
						<tr>
							<td>${counter.count}</td>
							<td>${user.username}</td>
							<td>${user.fullname}</td>
							<td>
								<form action="MainController" method="POST">
									<input type="submit" name="action" value="Update_Account"> 
									<input type="hidden" name="txtUsername" value="${user.username}">
									<input type="hidden" name="txtFullname" value="${user.fullname}">
								</form>
							</td>
							<td>
								<c:url var="delete" value="MainController">
									<c:param name="txtUsername" value="${user.username}"></c:param>
									<c:param name="action" value="Delete"></c:param>
								</c:url> 
								<a href="${delete}" id="deleteBtn">Delete</a>
							</td>
						</tr>

					</c:forEach>

				</tbody>
			</table>
		</c:if>
	</c:if>
	
	${DELETE_ERROR}
	
	<script type="text/javascript">
		function myFunction() {
			var deleteBtn = document.getElementById("deleteBtn");
		}
	</script>
</body>
</html>