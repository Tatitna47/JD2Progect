<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>SuperAdminUserAll</title>
</head>
<body>
<div class="row">
    <div class="col-sm-0" style="background-color:mediumseagreen;"></div>
    <div class="col-sm-12" style="background-color:mediumspringgreen;"><br>
        <H3>USERS</H3>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>User Name</th>
                <th>Password</th>
                <th>Role</th>
                <th>Status</th>
                <th>Email</th>
                <th>Full Name</th>
                <th>Phone</th>
                <th>Additional Information</th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${userDTOList}">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.username}"/></td>
                    <td><c:out value="${user.password}"/></td>
                    <td><c:out value="${user.role}"/></td>
                    <td><c:out value="${user.status}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.fullName}"/></td>
                    <td><c:out value="${user.phone}"/></td>
                    <td><c:out value="${user.additionalInformation}"/></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/superadmin/user/change/role" method="post">
                            <div class="radio">
                                <label><input type="radio" name="userRole" value=SUPERADMIN>SUPERADMIN</label>
                            </div>
                            <div class="radio">
                                <label><input type="radio" name="userRole" value=ADMIN>ADMIN</label>
                            </div>
                            <div class="radio">
                                <label><input type="radio" name="userRole" value=USER>USER</label>
                            </div>
                            <div class="form-group"><br>
                                <input type="hidden" name="userId" value="${user.id}">
                                <button type="submit" class="btn">Change Role</button>
                            </div>
                        </form>
                    </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/superadmin/user/change/status" method="post">
                            <div class="radio">
                                <label><input type="radio" name="userStatus" value=IS_ACTIVE>IS_ACTIVE</label>
                            </div>
                            <div class="radio">
                                <label><input type="radio" name="userStatus" value=IS_LOCKED>IS_LOCKED</label>
                            </div>
                            <div class="form-group"><br>
                                <input type="hidden" name="userId" value="${user.id}">
                                <button type="submit" class="btn">Change Staus</button>
                            </div>
                        </form>
                    </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/superadmin/user/delete" method="post">
                            <div class="form-group"><br>
                                <input type="hidden" name="userId" value="${user.id}">
                                <button type="submit" class="btn">Delete User</button>
                            </div>
                        </form>
                    </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/superadmin/user/change/password" method="get">
                            <div class="form-group"><br>
                                <input type="hidden" name="userId" value="${user.id}">
                                <input type="hidden" name="userName" value="${user.username}">
                                <button type="submit" class="btn">Change Password</button>
                            </div>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>
        <form action="${pageContext.request.contextPath}/superadmin/welcome" method="get">
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
    <div class="col-sm-0" style="background-color:lavender;"></div>
</div>
</body>
</html>
