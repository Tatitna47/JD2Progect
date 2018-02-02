<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div class="row">
    <div class="col-sm-4" style="background-color:mediumseagreen;"></div>
    <div class="col-sm-4" style="background-color:mediumspringgreen;"><br>
        <h3><p align="center">Enter password and login</p></h3>
        <h3><c:out value="${messageNotValidUser}"/></h3>
        <br>
       <c:if test="${result != null}">UserName ore Password are not valid</c:if>
        <form method="post" action="${pageContext.request.contextPath}/login">
            <div class="form-group"><br>
                <label for="username">Enter Name</label>
                <input type="text" class="form-control" id="username" name="username"
                       placeholder="Enter name"><br><br>
            </div>
            <div class="form-group"><br>
                <label for="password">Enter password</label>
                <input name="password" type="text" class="form-control" id="password" placeholder="Enter password"
                       align="center"><br><br>
            </div>
            <input type="hidden">
            <button type="submit" class="btn">LOG IN</button>
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
