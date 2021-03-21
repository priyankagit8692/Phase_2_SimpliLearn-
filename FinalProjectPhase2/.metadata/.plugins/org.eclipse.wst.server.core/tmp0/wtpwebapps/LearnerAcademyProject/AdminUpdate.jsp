<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Update</title>
<style type="text/css">
div {
	transform: translate(-20px, 80px);
	background-color: lightblue;
}

h1 {
	transform: translate(0px, 10px);
	color: #4CAF50;
}
</style>
</head>
<body>
	<div align='center'>
		<h1>Update Admin</h1>
		<a href="AdminLogin.jsp">Admin Login</a>
		<form method="post" action="adminUpdate">
			<table>
				<tr>
					<td>Enter Admin name for which you want to update details:</td>
					<td><input type="text" name="adminName"></td>
				</tr>
				<tr>
					<td>Enter correct Email for the above mentioned user:</td>
					<td><input type="email" name="adminEmail"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="adminPassword"></td>
				</tr>
				<tr>
					<td>Phone:</td>
					<td><input type="text" name="adminPhone"></td>
				</tr>
				<tr>
					<td>City:</td>
					<td><input type="text" name="adminCity"></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<button type="submit">Update</button>
					</td>
				</tr>
			</table>


			<c:if test="${not empty msg}">
				<c:out value="${msg}" />
			</c:if>

		</form>
</body>
</html>