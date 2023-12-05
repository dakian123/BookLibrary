<%--
  Created by IntelliJ IDEA.
  User: ThinkKING
  Date: 8/9/2022
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/home.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
</head>

<body>
	<jsp:include page="header.jsp" />
	<div class="container row mx-auto mt-4">
		<div class="col-3 bg-white border rounded-4">
			<h3>
				<i class="bi bi-list-task"></i> Category
			</h3>
			<div class="overflow-auto" id="category">
				<ul class="list-group">
					<c:forEach items="${categoryList}" var="category">
						<li class="list-group-item border border-light "><a
							href="search?search=&category=${ category.getcategoryId()}"
							class="text-dark text-decoration-none">${category.categoryName }</a>
						</li>
					</c:forEach>

				</ul>
			</div>
		</div>
		<div class="col-9">
			<div id="carouselExampleIndicators" class="carousel slide"
				data-bs-ride="true">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="3" aria-label="Slide 4"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active img">
						<img src="image/banner1.jpg" class="d-block img-fluid" alt="">
					</div>
					<div class="carousel-item img">
						<img src="image/banner2.jpg" class="d-block img-fluid" alt="">
					</div>
					<div class="carousel-item img">
						<img src="image/banner3.jpg" class="d-block img-fluid" alt="">
					</div>
					<div class="carousel-item img">
						<img src="image/banner4.jpg" class="d-block img-fluid" alt="">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
			
		</div>
	</div>
	<div class="container rounded-5 row mx-auto mt-3 bg-white border">
		<div class="d-flex justify-content-between ">
			<h5 class="m-4">Recommend Book</h5>
		</div>
		<div class="d-flex justify-content-evenly">
			<c:forEach items="${bookRandom}" var="book1">
				<div id="book" class="pb-4">
					<img src="${book1.image }" alt="" id="bookcove" class="rounded-3">
					<div class="card-body">
						<a href="detail?bookId=${book1.bookId}"
							class="text-dark text-decoration-none " style="font-weight: bold" id="an">${book1.bookTitle }</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="container rounded-5 row mx-auto mt-3 bg-white border">
		<div class="d-flex justify-content-between ">
			<h5 class="m-4">Books New</h5>
			<a href="search?search&filter" class="text-decoration-none m-3">View
				all</a>
		</div>
		<div class="d-flex justify-content-evenly">
			<c:forEach items="${bookNew}" var="book">
				<div id="book" class="pb-4">
					<img src="${book.image }" alt="" id="bookcove" class="rounded-3">
					<div class="card-body">
						<a href="detail?bookId=${book.bookId}"
							class="text-dark text-decoration-none" style="font-weight: bold" id="an">${book.bookTitle }</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>



	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
	<jsp:include page="footer.jsp" />
</body>

</html>
