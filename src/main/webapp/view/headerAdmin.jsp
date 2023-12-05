<%@ page import="com.teamone.bookmanagementsystem.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Header</title>
    <link rel="stylesheet" href="../css/styleAdmin.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
</head>
<body>
<head>
    <%
        User user = (User) session.getAttribute("user");
    %>
    <div class="container-fluid-0">
        <nav class="navbar navbar-expand-lg">
            <div class="container-fluid">
                <button type="button" onclick="history.back()" class="btn btn-outline-secondary">
                        <i class="bi bi-arrow-return-left"></i>
                        Back
                </button>
                <div class="col-2 d-flex justify-content-end align-items-center">
                    <img src="image/logo.png" alt="" class="rounded-circle " id="logo" style="width: auto;height: 50px">
                    <a style="text-decoration: none; color: black " href="${pageContext.request.contextPath}/books"><h4>IBook</h4></a>
                </div>

                <span class="user mx-3">
                        <small class="text-danger mx-3"><%="Welcome " + user.getUsername()+"!"%></small>
                        <i class="bi bi-person-circle"></i>
                        <button type="button" class="btn btn-outline-secondary logout-btn">
                            <a href="logout" class="logout-link">Logout</a>
                        </button>
                </span>
            </div>
        </nav>
    </div>
</head>

</body>
</html>