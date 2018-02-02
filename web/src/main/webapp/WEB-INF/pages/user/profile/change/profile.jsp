<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>UserProfileChenge</title>
</head>
<body>
<div class="row">
    <div class="col-sm-4" style="background-color:mediumseagreen;"></div>
    <div class="col-sm-4" style="background-color:mediumspringgreen;"><br>
        <h3>PROFILE</h3>
        <spring:message code="ladel.login.title"/>
        <form method="post" action="${pageContext.request.contextPath}/user/profile/change">
            <div class="form-group"><br>
                <label for="name">Full Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Full Name"><br>
            </div>
            <div class="form-group"><br>
                <label for="login">Login</label>
                <input type="text" class="form-control" id="login" name="login" placeholder="Login"><br>
            </div>
            <div class="form-group"><br>
                <label for="phone">Fhone</label>
                <input type="text" class="form-control" id="phone" name="phone" placeholder="Price"><br>
            </div>
            <div class="form-group"><br>
                <label for="address">Address</label>
                <input type="text" class="form-control" id="address" name="address" placeholder="Price"><br>
            </div>
            <div class="form-group"><br>
                <label for="addinf">Additional Information</label>
                <input type="text" class="form-control" id="addinf" name="addinf" placeholder="Price"><br>
            </div>
            <input type="hidden">
            <button type="submit" class="btn">Change</button>
        </form>
        <form action="${pageContext.request.contextPath}/user/welcome" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">WELCOME PAGE</button>
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
