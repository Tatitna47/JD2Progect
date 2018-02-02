<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>UserBasket</title>
</head>
<body>
<div class="row">
    <div class="col-sm-3" style="background-color:mediumseagreen;"></div>
    <div class="col-sm-6" style="background-color:mediumspringgreen;"><br>
        <h3>BASKET</h3>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Item Id</th>
                <th>Item Name</th>
                <th>Investory Number</th>
                <th>Description</th>
                <th>Price</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="item" items="${basket}">
                <c:set var="summ" value="${summ + item.price}"/>
                <tr>
                    <td><c:out value="${item.id}"/></td>
                    <td><c:out value="${item.itemName}"/></td>
                    <td><c:out value="${item.inventoryNumber}"/></td>
                    <td><c:out value="${item.description}"/></td>
                    <td><c:out value="${item.price}"/></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/user/item/delete" method="post">
                            <div class="form-group"><br>
                                <input type="hidden" name="itemId" value="${item.id}">
                                <button type="submit" class="btn">Delete from basket</button>
                            </div>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        All Price ${summ}
        <br>

        <form action="${pageContext.request.contextPath}/user/item/all" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">CATALOG</button>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/user/order/new" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">Make Order</button>
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
    <div class="col-sm-3" style="background-color:lavender;"></div>
</div>
</body>
</html>
