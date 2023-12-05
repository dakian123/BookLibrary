<%@ page import="com.teamone.bookmanagementsystem.models.User" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 8/9/2022
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
    <title>${book.bookTitle}</title>
</head>
<body>
<%
	User user = (User) session.getAttribute("user");
%>
<jsp:include page="header.jsp"/>
<div class="container">
	<form method="post" action="bookcaseadd">
		<div class="row mt-4 mb-5">
	        <div class="aleft col-lg-5 col-md-5 d-flex justify-content-end">
	            <img src="${book.image}" alt="">
	        </div>
	        <div class="aright col-lg-7 col-md-7 mt-3 ps-5 ">
	            <h2 class="mt-3">${book.bookTitle}</h2>
	            <p class="mt-4"><span>Author: </span>${book.author}</p>
	            <p class="mt-4"><span> Publisher: </span>${book.publisher}</p>
	            <p class="mt-4"><span>Category: </span>${book.category.categoryName}</p>
	            <p class="Brief mt-4" id="an"><span>Brief: </span>${book.brief}</p>
				<%if (user != null) {%>
	            <div class="button">
	            	<input type="hidden" name="bookId" value="${book.bookId}">  
	                <button type="submit" class="btn btn-secondary me-2" >Add Bookcase</button>
	                <a href="https://truyenfull.vn/trai-tim-thieu-nu/chuong-51/"><button type="button" class="btn btn-light">Read Online</button></a>
	            </div>
				<%} else {%>
				<div class="button">
					<input type="hidden" name="bookId" value="${book.bookId}">
					<button type="submit" class="btn btn-secondary me-2" disabled >Add Bookcase</button>
					<button type="button" class="btn btn-light " disabled><a href="https://truyenfull.vn/trai-tim-thieu-nu/chuong-51/" style="text-decoration: none" > Read Online</button></a>
				</div>
				<%}%>
	        </div>
	        <div class="text-danger">${error_text}</div>
    </div>
	</form>
</div>
<jsp:include page="footer.jsp"/>
<link rel="stylesheet" href="css/bookdetail.css">
</body>
</html>
