<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/2/2021
  Time: 12:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
</head>
<body>
<form action="session" method="post">
    <label for="username" >Username: </label>
    <input type="text" id="username" name="username">

    <label for="password" >Password: </label>
    <input type="text" id="password" name="password">
    <input type="submit" value="Login">
</form>
<p>Session : ${username}    ${password}</p>


</body>
</html>
