<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>AdminItemAdd</title>
</head>
<body>
<div class="row">
    <div class="col-sm-4" style="background-color:mediumseagreen;"></div>
    <div class="col-sm-4" style="background-color:mediumspringgreen;"><br>
        <h3>ITEM ADD</h3>

        <form action="${pageContext.request.contextPath}/admin/item/add" method="post" >
            <div class="form-group"><br>
                <label for="number">Inventory Number</label>
                <input type="text" class="form-control" id="number" name="number" placeholder="Inventory Number"><br>
            </div>
            <div class="form-group"><br>
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Name"><br>
            </div>
            <div class="form-group"><br>
                <label for="description">Description</label>
                <input type="text" class="form-control" id="description" name="description" placeholder="Description"><br>
            </div>
            <div class="form-group"><br>
                <label for="price">Price</label>
                <input type="text" class="form-control" id="price" name="price" placeholder="Price"><br>
            </div>
            <input type="hidden">
            <button type="submit" class="btn">ADD</button>
        </form>

        <form action="${pageContext.request.contextPath}/admin/welcome" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">WELCOME PAGE</button>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/logout" method="get">
            <input type="hidden">
            <button type="submit" class="btn">LOG OUT</button>
        </form>
    </div>
    <div class="col-sm-4" style="background-color:lavender;"></div>
</div>
</body>
</html>
