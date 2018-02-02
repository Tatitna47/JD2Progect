<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>FeedBack Form</title>
</head>
<body>
<div class="row">
    <div class="col-sm-4" style="background-color:mediumseagreen;"></div>
    <div class="col-sm-4" style="background-color:mediumspringgreen;"><br>
        <h3><p align="center">FeedBack</p></h3>
        <br>
        <form method="post" action="${pageContext.request.contextPath}/user/feedback/add">
            <div class="form-group"><br>
                <label for="email">Enter email</label>
                <input type="text" class="form-control" id="email" name="email"
                       placeholder="Enter name"><br><br>
            </div>
            <div class="form-group"><br>
                <label for="message">Enter password</label>
                <input name="message" type="text" class="form-control" id="message" placeholder="Enter message"
                       align="center"><br><br>
            </div>
            <input type="hidden">
            <button type="submit" class="btn">LOG IN</button>
        </form>
        <form action="${pageContext.request.contextPath}/user/welcome" method="get">
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
