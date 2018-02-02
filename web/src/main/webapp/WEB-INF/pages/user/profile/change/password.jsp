<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>UserPasswordChange</title>
</head>
<body>
<div class="row">
    <div class="col-sm-4" style="background-color:mediumseagreen;"></div>
    <div class="col-sm-4" style="background-color:mediumspringgreen;"><br>
        <h3><p align="center">USER</p></h3>
        User
        <br>
        <form method="post" action="${pageContext.request.contextPath}/user/change/password">
            <div class="form-group"><br>
                <label for="password">Enter password</label>
                <input name="password" type="text" class="form-control" id="password" placeholder="Enter password"
                       align="center"><br>
            </div>
            <div class="form-group"><br>
                <label for="repassword">Repeat password</label>
                <input name="repassword" type="text" class="form-control" id="repassword"
                       placeholder="Repeat password" align="center"><br>
            </div>
            <input type="hidden">
            <button type="submit" class="btn">Change Password</button>
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