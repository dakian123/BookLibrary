<%@ page import="com.teamone.bookmanagementsystem.models.Book"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.teamone.bookmanagementsystem.models.Category"%><%--
  Created by IntelliJ IDEA.
  User: ThinkKING
  Date: 8/9/2022
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/searchbook.css">
<title>Search Book</title>
<%
List<Book> listBooks = (List) request.getAttribute("listBooks");
List<Book> listBooksByCate = (List) request.getAttribute("listBooksByCate");
List<Category> categoryList = (List) request.getAttribute("categoryList");
String msg = (String) request.getAttribute("msg");
if (msg == null)
	msg = "";
%>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container row mx-auto mt-4">
		<div class="col-3 bg-white border rounded-4" id="category">
			<h3>
				<i class="bi bi-list-task"></i> Category
			</h3>
			<ul class="list-group">
				<%
				for (Category c : categoryList) {
				%>
				<li class="list-group-item border border-light "><a
					class="text-decoration-none text-dark"
					href="search?search=&category=<%=c.getcategoryId()%>"><%=c.getcategoryName()%>
				</a></li>
				<%
				}
				%>
			</ul>
		</div>
		<!-- Right -->
		<div class="col-9 ">
			<div class="flex-nowrap ">
				<h5 class="text-danger"><%=msg%></h5>
				<%
				for (Book b : listBooks) {
				%>
				<div class="bg-white mt-3 mx-4 mb-2 d-inline-block " id="book">
					<img src="<%=b.getImage()%>">
					<div class="card-body">
						<a href="detail?bookId=<%=b.getbookId()%>"
							class="text-dark text-decoration-none" id="an"><%=b.getbookTitle()%>
						</a>
					</div>
				</div>
				<%
				}
				%>
				<div class="justify-content-end">
					<ul class="pagination">
						<c:choose>
							<c:when test="${previousPage > 1}">
								<c:choose>
									<c:when test="${category == null }">
										<li class="page-item"><a class="page-link"
											href="search?search=${ search}&filter=${filter }&page=${previousPage - 1}">Previous</a></li>
									</c:when>
									<c:when test="${category != null }">
										<li class="page-item"><a class="page-link"
											href="search?search=${ search}&category=${category }&page=${previousPage - 1}">Previous</a></li>
									</c:when>
								</c:choose>
							</c:when>
							<c:when test="${previousPage == 1}">
								<c:choose>
									<c:when test="${category == null }">
										<li class="page-item"><a class="page-link"
											href="search?search=${ search}&filter=${filter }&page=${previousPage}">Previous</a></li>
									</c:when>
									<c:when test="${category != null }">
										<li class="page-item"><a class="page-link"
											href="search?search=${ search}&category=${category }&page=${previousPage}">Previous</a></li>
									</c:when>
								</c:choose>
							</c:when>
						</c:choose>

						<c:forEach begin="1" end="${totalPage}" var="p">
							<c:choose>
								<c:when test="${category == null }">
									<li class="page-item"><a class="page-link"
										href="search?search=${ search}&filter=${filter }&page=${p}">${p}</a></li>
								</c:when>
								<c:when test="${category != null }">
									<li class="page-item"><a class="page-link"
										href="search?search=${ search}&category=${category }&page=${p}">${p}</a></li>
								</c:when>
							</c:choose>
						</c:forEach>

						<c:if test="${totalPage != null}">
							<c:choose>
								<c:when test="${previousPage < totalPage}">
									<c:choose>
										<c:when test="${category == null }">
											<li class="page-item"><a class="page-link"
												href="search?search=${ search}&filter=${filter }&page=${previousPage + 1}">Next</a></li>
										</c:when>
										<c:when test="${category != null }">
											<li class="page-item"><a class="page-link"
												href="search?search=${ search}&category=${category }&page=${previousPage + 1}">Next</a></li>
										</c:when>
									</c:choose>
								</c:when>
								<c:when test="${previousPage == totalPage}">
									<c:choose>
										<c:when test="${category == null }">
											<li class="page-item"><a class="page-link"
												href="search?search=${ search}&filter=${filter }&page=${previousPage}">Next</a></li>
										</c:when>
										<c:when test="${category != null }">
											<li class="page-item"><a class="page-link"
												href="search?search=${ search}&category=${category }&page=${previousPage}">Next</a></li>
										</c:when>
									</c:choose>
								</c:when>
							</c:choose>
						</c:if>
					</ul>
				</div>


			</div>
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
