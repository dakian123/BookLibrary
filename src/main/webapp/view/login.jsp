<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: ThinkKING
  Date: 8/9/2022
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Managerment System</title>

    <link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"
          type="text/css" />
    <link rel="stylesheet" href="./css/loginStyle.css">
</head>

<body>
<div class="login">
    <div class="d-flex justify-content-center col-xl-12">
        <div class="card border-75 bg-light bg-opacity-50 mb-4">
            <div class="card-body">
                <h3 class="card-title fw-bold">WELCOME TO BOOK MANAGEMENT</h3>
                <h2 class="card-subtitle pt-3    d-flex justify-content-center">Login your account</h2>
                <br>
                <form action="login" method="POST">
                    <div class="d-flex justify-content-center mb-3">
                        <div class="form-outline input input-group">
                            <span class="input-group-text bg-white border-end-0"><i class="bi bi-person-fill"></i></span> <input
                                type="text" name="username" class="form-control border-start-0" id="loguser" required
                                placeholder="Username" maxlength="50">
                        </div>

                    </div>

                    <div class="d-flex justify-content-center mb-3">
                        <div class="input input-group">
                            <span class="input-group-text bg-white border-end-0"><i class="bi bi-lock-fill"></i></span>

                            <input type="password" name="password" class="form-control  border-start-0" id="logpass" required
                                   placeholder="Password" maxlength="50">
                        </div>
                    </div>
                    <div class="check form-check">
                        <input class="form-check-input rounded-circle" type="checkbox" value="" id="flexCheckDefault">
                        <label class="form-check-label" for="flexCheckDefault">
                            Remember Me
                        </label>
                    </div>
                    <br>
                    <c:if test="${message_forward ne null}">
                        <div class="d-flex justify-content-center mb-3">
                            <div class="input input-group">
                                <p><c:out value="${message_forward['noti']}"></c:out></p>
                            </div>
                        </div>
                    </c:if>
                    <div class="login-btn d-flex justify-content-center">
                        <button type="submit" class="btn-login btn btn-dark btn-lg btn-block w-50">Login</button>
                    </div>
                    <br> <span class="d-flex justify-content-center">New here?&nbsp;<a href="register" class="link-primary"> Create new account</a></span>

                </form>


            </div>
        </div>
    </div>

</div>
</body>

</html>
