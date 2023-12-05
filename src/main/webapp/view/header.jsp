<%@ page import="com.teamone.bookmanagementsystem.models.User" %><%--
  Created by IntelliJ IDEA.
  User: ThinkKING
  Date: 8/9/2022
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/header-footer.css">
</head>

<body>

<header class="header">
    <% if (session.getAttribute("user") != null) {
        User user = (User) session.getAttribute("user");
    %>
    <div class="container-fluid row m-0">
        <div class="col-2 d-flex justify-content-end align-items-center">
            <img src="image/logo.png" alt="" class="rounded-circle " id="logo">
            <a style="text-decoration: none; color: black " href="books"><h4>IBook</h4></a>
        </div>
        <div class="col-8 p-3">
            <form action="search" method="get" class="m-3">
                <div class="d-flex justify-content-end bg-white">
                    <div class="input-group px-3 w-50 border border-dark rounded-pill me-3">
                        <input type="text" class="form-control border-0" placeholder="Search..." name="search">
                        <button class="btn btn-light bd-0" type="submit"><span
                                class="input-group-text bg-white border-0" id="basic-addon1"> <i
                                class="bi bi-search"></i> </span></button>
                    </div>
                    <div class="input-group px-3 w-auto border border-dark rounded-pill">
                        <select class="form-select  border-0 rounded-pill" aria-label="Default select example"
                                name="filter">
                            <option value="BookTitle">Title</option>
                            <option value="Author">Author</option>
                            <option value="Publisher">Publisher</option>
                        </select>
                        <span class="input-group-text bg-white border-0" id="basic-addon2"> <i
                                class="bi bi-funnel pe-2"></i>
                            </span>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-2 p-2 mt-4 d-flex justify-content-end">
            <div class="dropdown">
                <button class="btn bg-light dropdown-toggle" type="button" id="dropdownMenuButton1"
                        data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="image/person.png" style="height: 40px;width: auto;" alt="">
                </button>
                <%if (user.getRole().getRoleId() == 1) {%>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                    <li><p class="dropdown-item fw-bold text-danger"><%=user.getUsername()%></p></li>
                    <li><a class="dropdown-item" href="admin-book">Book Dashboard</a></li>
                    <li><a class="dropdown-item" href="logout">Log Out</a></li>
                </ul>
                <%} else {%>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                    <li><p class="dropdown-item fw-bold text-danger"><%=user.getUsername()%></p></li>
                    <li><a class="dropdown-item" href="bookcase">Bookcase</a></li>
                    <li><a class="dropdown-item" href="logout">Log Out</a></li>
                </ul>
                <%}%>
            </div>
        </div>
    </div>
    <%} else {%>
    <div class="container-fluid row m-0">
        <div class="col-2 d-flex justify-content-end align-items-center">
            <img src="image/logo.png" alt="" class="rounded-circle " id="logo">
            <a style="text-decoration: none; color: black " href="books"><h4>IBook</h4></a>
        </div>
        <div class="col-8 p-3">
            <form action="search" method="get" class="m-3">
                <div class="d-flex justify-content-end bg-white">
                    <div class="input-group px-3 w-50 border border-dark rounded-pill me-3">
                        <input type="text" class="form-control border-0" placeholder="Search..." name="search">
                        <button class="btn btn-light bd-0" type="submit"><span
                                class="input-group-text bg-white border-0" id="basic-addon1"> <i
                                class="bi bi-search"></i> </span></button>
                    </div>
                    <div class="input-group px-3 w-auto border border-dark rounded-pill">
                        <select class="form-select  border-0 rounded-pill" aria-label="Default select example"
                                name="filter">
                            <option value="BookTitle">Title</option>
                            <option value="Author">Author</option>
                            <option value="Publisher">Publisher</option>
                        </select>
                        <span class="input-group-text bg-white border-0" id="basic-addon2"> <i
                                class="bi bi-funnel pe-2"></i>
                            </span>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-2 p-2 mt-4 d-flex justify-content-end">
            <div class="dropdown">
                <button class="btn bg-light dropdown-toggle" type="button" id="dropdownMenuButton1"
                        data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="image/person.png" style="height: 40px;width: auto;" alt="">
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                    <li><a class="dropdown-item" href="login">Login</a></li>
                </ul>
            </div>
        </div>
    </div>
    <%}%>
    <div class="d-flex justify-content-center">
        <hr class="w-75">
    </div>
</header>


<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
</body>

</html>