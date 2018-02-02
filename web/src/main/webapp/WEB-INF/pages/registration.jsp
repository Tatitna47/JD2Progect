<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>Checkin</title>
</head>
<body>
<div class="row">
    <div class="col-sm-4" style="background-color:mediumseagreen;"></div>
    <div class="col-sm-4" style="background-color:mediumspringgreen;"><br>
        <h3><p align="center">Welcome</p></h3>
        <br>
        <form method="post" action="${pageContext.request.contextPath}/checkin">
            <div class="form-group"><br>
                <label for="username">Enter Name</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Enter name"><br>
            </div>
            <div class="form-group"><br>
                <label for="mail">Enter Mail</label>
                <input type="text" class="form-control" id="mail" name="mail" placeholder="Enter Mail"><br>
            </div>
            <div class="form-group"><br>
                <label for="phone">Enter Phone</label>
                <input type="text" class="form-control" id="phone" name="phone" placeholder="Enter Phone"><br>
            </div>
            <div class="form-group"><br>
                <label for="address">Enter Address</label>
                <input type="text" class="form-control" id="address" name="address" placeholder="Enter Address"><br>
            </div>
            <div class="form-group"><br>
                <label for="addinf">Enter Additional Information</label>
                <input type="text" class="form-control" id="addinf" name="addinf"
                       placeholder="Enter Additional Information"><br>
            </div>
            <div class="form-group"><br>
                <label for="password">Enter password</label>
                <input name="password" type="password" class="form-control" id="password" placeholder="Enter password"
                       align="center"><br>
            </div>
            <div class="form-group"><br>
                <label for="repassword">Repeat password</label>
                <input name="repassword" type="password" class="form-control" id="repassword"
                       placeholder="Repeat password" align="center"><br>
            </div>
            <input type="hidden">
            <button type="submit" class="btn">CHECK IN</button>
        </form>
        <form action="${pageContext.request.contextPath}/superadmin/welcome" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">WELCOME PAGE</button>
            </div>
        </form>
    </div>
    <div class="col-sm-4" style="background-color:lavender;"></div>
</div>
</body>
</html>
