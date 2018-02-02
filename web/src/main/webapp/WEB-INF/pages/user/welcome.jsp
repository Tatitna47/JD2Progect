<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>UserWelcome</title>
</head>
<body>
<h2>   < <!--spring:message code="ladel.login.title"/-->></h2>
<div class="row">
    <div class="col-sm-4" style="background-color:mediumseagreen;"></div>
    <div class="col-sm-4" style="background-color:mediumspringgreen;"><br>
        <h3>HELLO USER</h3>
        <br>
        <form action="${pageContext.request.contextPath}/user/news" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">NEWS</button>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/user/item/all" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">CATALOG</button>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/user/profile/show" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">PROFILE</button>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/user/order/all" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">ORDERS</button>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/user/feedback" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">FEEDBACK</button>
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
