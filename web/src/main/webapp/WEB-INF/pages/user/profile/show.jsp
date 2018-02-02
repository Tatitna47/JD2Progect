<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>UserProfileShow</title>
</head>
<body>
<div class="row">
    <div class="col-sm-4" style="background-color:mediumseagreen;"></div>
    <div class="col-sm-4" style="background-color:mediumspringgreen;"><br>
        <h3>PROFILE</h3>

        Name <c:out value="${userDTO.username}"/><br>
        Password <c:out value="${userDTO.password}"/> <br>
        Role <c:out value="${userDTO.role}"/> <br>
        Status <c:out value="${userDTO.status}"/><br>
        Email <c:out value="${userDTO.email}"/><br>
        Full Name <c:out value="${userDTO.fullName}"/><br>
        Phone <c:out value="${userDTO.phone}"/><br>
        Additional Infoormation <c:out value="${userDTO.additionalInformation}"/><br>

        <br>
        <form action="${pageContext.request.contextPath}/user/profile/change" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">Change Profile</button>
            </div>
        </form>

        <form action="${pageContext.request.contextPath}/user/change/password" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">Change Password</button>
            </div>
        </form>

        <form action="${pageContext.request.contextPath}/user/order/all" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">Show Orders</button>
            </div>
        </form>

        <form action="${pageContext.request.contextPath}/user/item/all" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">Go to shop</button>
            </div>
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
