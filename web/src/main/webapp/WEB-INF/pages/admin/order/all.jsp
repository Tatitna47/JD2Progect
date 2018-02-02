<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>AdminOrderAll</title>
</head>
<body>

<div class="row">
    <div class="col-sm-3" style="background-color:mediumseagreen;"></div>
    <div class="col-sm-6" style="background-color:mediumspringgreen;"><br>
        <h3>ORDERS</h3>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>OrderNumber</th>
                <th>Order StatusEnum</th>
                <th>User Name</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${orderDTOList}">
                <tr>
                    <td><c:out value="${order.id}"/></td>
                    <td><c:out value="${order.orderNumber}"/></td>
                    <td><c:out value="${order.orderStatus}"/></td>
                    <td><c:out value="${order.username}"/></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/admin/order/all" method="post">
                            <div class="radio">
                                <label><input type="radio" name="orderstatus" value=NEW>NEW</label>
                            </div>
                            <div class="radio">
                                <label><input type="radio" name="orderstatus" value=REVIWING>REVIWING</label>
                            </div>
                            <div class="radio">
                                <label><input type="radio" name="orderstatus" value=IN_PROGRESS>IN_PROGRESS</label>
                            </div>
                            <div class="radio">
                                <label><input type="radio" name="orderstatus" value=DELIVERED>DELIVERED</label>
                            </div>
                            <div class="form-group"><br>
                                <input type="hidden" name="orderId" value="${order.id}">
                                <button type="submit" class="btn">Change status</button>
                            </div>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <form action="${pageContext.request.contextPath}/admin/welcome" method="get">
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
