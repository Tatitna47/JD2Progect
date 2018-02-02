<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>UserOrder</title>
</head>
<body>
<div class="row">
    <div class="col-sm-4" style="background-color:mediumseagreen;"></div>
    <div class="col-sm-4" style="background-color:mediumspringgreen;"><br>
        <h3>Order</h3>

        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Order Number</th>
                <th>OrderStatus</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${orderDTOList}">
                <tr>
                    <td><c:out value="${order.id}"/></td>
                    <td><c:out value="${order.orderNumber}"/></td>
                    <td><c:out value="${order.orderStatus}"/></td>
                    <td><c:if test="${order.orderStatus eq 'NEW'}">
                        <form action="${pageContext.request.contextPath}/user/order/update" method="post">
                            <div class="form-group"><br>
                                <input type="hidden" name="orderId" value="${order.id}">
                                <button type="submit" class="btn">Update</button>
                            </div>
                        </form>
                    </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>


        <br>
        <form action="${pageContext.request.contextPath}/user/item/all" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">CATALOG</button>
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
