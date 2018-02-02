<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<div class="row">
    <div class="col-sm-4" style="background-color:mediumseagreen;"></div>
    <div class="col-sm-4" style="background-color:mediumspringgreen;"><br>
        <h3><p align="center">Welcome</p></h3>
        <br>
        <form action="${pageContext.request.contextPath}/login" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">login</button>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/checkin" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">checkin</button>
            </div>
        </form>
    </div>
    <div class="col-sm-4" style="background-color:lavender;"></div>
</div>
</body>
</html>