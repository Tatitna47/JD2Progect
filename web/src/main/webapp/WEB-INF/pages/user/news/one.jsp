<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>UserNewsOne</title>
</head>
<body>
<div class="row">
    <div class="col-sm-4" style="background-color:mediumseagreen;"></div>
    <div class="col-sm-4" style="background-color:mediumspringgreen;"><br>
        <h3>NEWS</h3>

        News Id <c:out value="${newsDTO.id}"/><br>
        News Name <c:out value="${newsDTO.newsname}"/><br>
        Date <c:out value="${newsDTO.date}"/><br>
        Author <c:out value="${newsDTO.author}"/><br>
        Content <c:out value="${newsDTO.content}"/><br>

        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Message</th>
                <th>Date</th>
                <th>Author</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="comment" items="${comments}">
                <tr>
                    <td><c:out value="${comment.message}"/></td>
                    <td><c:out value="${comment.date}"/></td>
                    <td><c:out value="${comment.author}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        Add your comment
        <form method="post" action="${pageContext.request.contextPath}/user/news/comment/add">
            <div class="form-group"><br>
                <label for="comment">Coment</label>
                <input type="text" class="form-control" id="comment" name="comment" placeholder="Your comment"><br>
            </div>
            <div class="form-group"><br>
                <label for="date">Date</label>
                <input type="text" class="form-control" id="date" name="date" placeholder="Your date"><br>
            </div>
            <input type="hidden" name="newsId" value="${newsDTO.id}">
            <button type="submit" class="btn">ADD</button>
        </form>

        <form action="${pageContext.request.contextPath}/user/news" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">NEWS</button>
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
