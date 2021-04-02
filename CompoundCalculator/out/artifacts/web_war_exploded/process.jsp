<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/1/2021
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@  page errorPage="error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Processing</title>
</head>
<body>
<% int a = Integer.parseInt(request.getParameter("a"));
    int b = Integer.parseInt(request.getParameter("b"));
    int c = Integer.parseInt(request.getParameter("c"));
    out.println("a chia b = " + a/b);
%>
</body>
</html>
