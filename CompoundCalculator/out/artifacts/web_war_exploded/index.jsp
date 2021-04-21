<%@ page import="java.util.Date" %><%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <p>${error}</p>
  <form action="calculator" method="post">

    <label for="principal">Principal Amount: </label>
    <input type="number" id="principal" name="principal"><br>

    <label for ="interest">Interest Rate: </label>
    <input type="number" id="interest" name="interest"><br>

    <label for="year">Of Years: </label>
    <input type="number" id="year" name="year"><br>

    <label for="time">Time per Years: </label><br>
    <input type="number" id="time" name="time">

    <button type="submit">Calculate</button>
    <h2>Results:  ${result}</h2>
  </form>
<p>Add Exact: <%= Math.addExact(2,3)%></p>
  <p>Current Time: <%= new Date()%></p>
  <p>You have visited this site: ${count}</p>

  </body>
</html>