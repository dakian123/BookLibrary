<%--
  Created by IntelliJ IDEA.
  User: ThinkKING
  Date: 8/9/2022
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <link rel="stylesheet" href="./css/bookcase.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="bg-white container row mx-auto mt-3 bg-white border ">

    <div class="d-flex justify-content-between pt-3">
        <h4 class="ms-2">Book Case</h4>
    </div>
    <div>
        <form action="bookcase/delete" method="post" class="d-flex justify-content-start flex-wrap ">
            <c:forEach items="${books}" var="book1">
                <div class="card col-3 m-4 " style="width: 20%;">
                    <img src="${book1.image}"
                         class="card-img-top">
                    <div class="card-body">
                        <a href="detail?bookId=${book1.bookId}"
                           class="text-dark text-decoration-none" id="an">${book1.bookTitle}</a>
                        <input type="hidden" name="bookId" value="${book1.bookId}">
                        <input type="hidden" name="userId" value="${bookcase.bookcaseId}">
                    </div>
                    <button type="submit" onclick="return confirm('Are you sure to delete?')"
                            class="btn btn-danger position-absolute rounded-circle px-2  top-0 start-100 translate-middle ">
                        <i class="bi bi-x-lg"></i></button>
                </div>
            </c:forEach>

        </form>
    </div>
</div>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous"></script>
<jsp:include page="footer.jsp"/>
</body>

</html>
