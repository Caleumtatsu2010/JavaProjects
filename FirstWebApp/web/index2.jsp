<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 3/29/2021
  Time: 12:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<p>${error}</p>
<p>welcome ${person.getEmail()}</p>
<p>Hello ${person.getFirstName()}   ${person.getLastName()}</p>
<p>${person.getAge()}</p>
</body>
</html>
