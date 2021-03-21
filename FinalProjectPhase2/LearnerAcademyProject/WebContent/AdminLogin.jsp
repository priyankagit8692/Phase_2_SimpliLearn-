<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
  background-image: url("images/academy.jpg");
  background-repeat: no-repeat;
}
div {
  transform: translate(-200px,50px);
}
h1{
  transform: translate(40px,50px);
  color: #4CAF50;
}
</style>
<body>
  <div align='right'>
  <h1>LEARNER  ACADEMY</h1> <br><br>
  <h3>Administration Login</h3>
  <form action="adminLogin" method="post" cellpadding="5" cellspacing="5">
    <table>
        <tr>
            <td>Username:</td>
            <td><input type="text" name="uname"></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td></td>
            <td><a href="AdminRegistration.jsp">Register</a>&nbsp&nbsp&nbsp&nbsp<a href="AdminUpdate.jsp">Update</a></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Login</button>
            </td>
        </tr>
    </table>
    <br>
    <c:if test="${not empty message}">
        <c:out value="${message}"/>
    </c:if>


</form>
  </div>
</body>
</html>