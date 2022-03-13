<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/21/2021
  Time: 10:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="col-sm-3">

    <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
            <c:forEach items="${listCategory}" var="o">
                <li class="list-group-item text-white ${tag == o.cid ? "active":"" }"><a href="category?cid=${o.cid}">${o.cname}</a></li>
            </c:forEach>
        </ul>
    </div>

    <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Last product</div>
        <div class="card-body">
            <img class="img-fluid" src="${lastProduct.image}" />
            <h5 class="card-title">${lastProduct.name}</h5>
            <p class="card-text">${lastProduct.title}</p>
            <p class="bloc_left_price">${lastProduct.price} $</p>
        </div>
    </div>

</div>

</body>
</html>
