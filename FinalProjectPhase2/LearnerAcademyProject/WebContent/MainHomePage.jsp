<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body background = "images/books.jpg"  background-repeat="no-repeat"
  background-size= "100px" "100px">

<div align='center' style='border: solid 8px black; height: 95%'>
    <u><h1>Welcome <%= session.getAttribute("name")%></h1></u>
    <br><br>
    <table>
        <tr>
            <td><h3>Admin Links</h3><br></td>
        </tr>
        <tr>
            <td><a href="addStudent">Add new student</a></td>
        </tr>
        <tr>
            <td><a href="viewStudent">View Student</a></td>
        </tr>
        <tr>
            <td><a href="classReport">View Class report</a></td>
        </tr>
        <tr>
            <td><a href="logout.jsp">Logout</a></td>
        </tr>
    </table>
</div>
</body>
</html>
