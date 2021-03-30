<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 3/19/2021
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Register Form</title>
  </head>
  <body>
      <form name="login" method="post" action="hello">
          <label for ="email">Email</label>
          <input type="email" id="email" name="email"><br>

          <label for="name" >First Name</label>
          <input type="text" id="name" name="first"><br>

          <label for="name" >Last Name</label>
          <input type="text" id="name" name="last"><br>

          <label for="age">Age</label>
          <input type="number" id="age" name="age"><br>

          <label for ="password">Password</label>
          <input type="password" id="password" name="password">
          <input type="submit" value="Login" />
      </form>
  </body>
</html>
