<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<html>
<head>
    <title>SuperAdminWelcome</title>
</head>
<body>

<div class="row">
    <div class="col-sm-4" style="background-color:mediumseagreen;"></div>
    <div class="col-sm-4" style="background-color:mediumspringgreen;"><br>
        <h3>HELLO SUPERADMIN</h3>
        <br>
        <form action="${pageContext.request.contextPath}/superadmin/news/all" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">news</button>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/superadmin/user/all" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">users</button>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/superadmin/item/all" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">items</button>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/superadmin/order/all" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">orders</button>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/logout" method="get">
            <input type="hidden" name="" value="">
            <button type="submit" class="btn">LOG OUT</button>
        </form>
    </div>
    <div class="col-sm-4" style="background-color:lavender;"></div>
</div>
</body>
</html>
