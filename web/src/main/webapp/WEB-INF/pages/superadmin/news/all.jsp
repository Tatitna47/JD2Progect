<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>SuperAdminNewsAll</title>
</head>
<body>

<div class="row">
    <div class="col-sm-2" style="background-color:mediumseagreen;"></div>
    <div class="col-sm-8" style="background-color:mediumspringgreen;"><br>
        <h3>NEWS</h3>
        <form action="${pageContext.request.contextPath}/superadmin/news/add" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">Add</button>
            </div>
        </form>
        <form action="${pageContext.request.contextPath}/superadmin/news/update" method="get">
            <div class="form-group"><br>
                <input type="hidden">
                <button type="submit" class="btn">Update</button>
            </div>
        </form>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>News name</th>
                <th>Date</th>
                <th>Author</th>
                <th>Content</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="news" items="${newsDTOList}">
                <tr>
                    <td><c:out value="${news.newsname}"/></td>
                    <td><c:out value="${news.date}"/></td>
                    <td><c:out value="${news.author}"/></td>
                    <td><c:out value="${news.content}"/></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/superadmin/news/delete" method="post">
                            <div class="form-group"><br>
                                <input type="hidden" name="newsname" value="${news.newsname}">
                                <button type="submit" class="btn">Delete</button>
                            </div>
                        </form>
                    </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/superadmin/news/one" method="post">
                            <div class="form-group"><br>
                                <input type="hidden" name="newsname" value="${news.newsname}">
                                <button type="submit" class="btn">Comments</button>
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
    <div class="col-sm-2" style="background-color:lavender;"></div>
</div>
</body>
</html>
