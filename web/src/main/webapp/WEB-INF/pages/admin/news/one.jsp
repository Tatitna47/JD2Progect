<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>AdminWholeNews</title>
</head>
<body>
<div class="row">
    <div class="col-sm-4" style="background-color:mediumseagreen;"></div>
    <div class="col-sm-4" style="background-color:mediumspringgreen;"><br>
        <h3>NEWS</h3>

        News Name <c:out value="${newsDTO.newsname}"/><br>
        Date <c:out value="${newsDTO.date}"/><br>
        Author <c:out value="${newsDTO.author}"/><br>
        Content <c:out value="${newsDTO.content}"/><br>

        <form action="${pageContext.request.contextPath}/admin/news/delete" method="post">
            <div class="form-group"><br>
                <input type="hidden" name="newsname" value="${newsDTO.newsname}">
                <button type="submit" class="btn">Delete News</button>
            </div>
        </form>

        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Message</th>
                <th>Date</th>
                <th>Author</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="comment" items="${comments}">
                <tr>
                    <td><c:out value="${comment.message}"/></td>
                    <td><c:out value="${comment.date}"/></td>
                    <td><c:out value="${comment.author}"/></td>

                    <td>
                        <form action="${pageContext.request.contextPath}/admin/news/one/comment/delete" method="post">
                            <div class="form-group"><br>
                                <input type="hidden" name="comment" value="${comment.message}">
                                <input type="hidden" name="newsname" value="${newsDTO.newsname}">
                                <button type="submit" class="btn">Delete Comment</button>
                            </div>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <form action="${pageContext.request.contextPath}/admin/news/all" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">All NEWS</button>
            </div>
        </form>
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
    <div class="col-sm-4" style="background-color:lavender;"></div>
</div>
</body>
</html>
