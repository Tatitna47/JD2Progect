<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>AdminNewsAdd</title>
</head>
<body>

<div class="row">
    <div class="col-sm-4" style="background-color:mediumseagreen;"></div>
    <div class="col-sm-4" style="background-color:mediumspringgreen;"><br>
        <h3>NEWS ADD</h3>
        <form method="post" action="${pageContext.request.contextPath}/admin/news/add">
            <div class="form-group"><br>
                <label for="newsname">News name</label>
                <input type="text" class="form-control" id="newsname" name="newsname" placeholder="Enter News Name"><br>
            </div>
            <div class="form-group"><br>
                <label for="date">Date</label>
                <input type="text" class="form-control" id="date" name="date" placeholder="Enter Date"><br>
            </div>
            <div class="form-group"><br>
                <label for="author">Author</label>
                <input type="text" class="form-control" id="author" name="author" placeholder="Enter Author"><br>
            </div>
            <div class="form-group"><br>
                <label for="photo">Photo</label>
                <input type="text" class="form-control" id="photo" name="photo" placeholder="Enter Photo"><br>
            </div>
            <div class="form-group"><br>
                <label for="content">Enter Content</label>
                <input type="text" class="form-control" id="content" name="content" placeholder="Enter Content"><br>
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
            <input type="hidden" name="" value="">
            <button type="submit" class="btn">LOG OUT</button>
        </form>
    </div>
    <div class="col-sm-4" style="background-color:lavender;"></div>
</div>
</body>
</html>
