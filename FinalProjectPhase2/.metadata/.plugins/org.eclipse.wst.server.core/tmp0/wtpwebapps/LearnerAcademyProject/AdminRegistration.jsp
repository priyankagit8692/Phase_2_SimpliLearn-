<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administration Register</title>
<style type="text/css">
div {
  transform: translate(-20px,80px);
  background-color: lightblue;
}
h1{
  transform: translate(0px,10px);
  color: #4CAF50;
}
</style>
</head>
<body>

	<div align='center'>
	   <h1>Administration Register</h1>
	   <a href="AdminLogin.jsp">Admin Login</a>
	   <form method="post" action="adminRegister">
	   		<table>
	   			<tr>
	   			<td>Name:</td>
	   			<td><input type="text" name="adminName"></td>
	   			</tr>
	   			<tr>
	   			<td>Password:</td>
	   			<td><input type="password" name="adminPassword"></td>
	   			</tr>
	   			<tr>
	   			<td>Contact No:</td>
	   			<td><input type="text" name="adminContact"></td>
	   			</tr>
	   			<tr>
	   			<td>Email Id:</td>
	   			<td><input type="text" name="adminEmail"></td>
	   			</tr>
	   			<tr>
	   			<td>City:</td>
	   			<td><input type="text" name="adminCity"></td>
	   			</tr>
	   			<tr>
                <td></td>
                <td>
                    <button type="submit">Register</button>
                </td>
               </tr>
        </table>
        <c:if test="${not empty msg}">
            <c:out value="${msg}"/>
        </c:if>
	   		</table>
	   </form>
	</div>
</body>
</html>