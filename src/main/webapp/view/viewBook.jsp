<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.teamone.bookmanagementsystem.models.Book" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="css/searchbook.css">
    <link rel="stylesheet" href="css/styleAdmin.css">
    <title>View Book</title>
</head>
<%List<Book> listbook = (List) request.getAttribute("listbook"); %>
<body>

<header class="header">
    <jsp:include page="headerAdmin.jsp"></jsp:include>
    <section class="container-fluid-0">
        <section class="d-flex justify-content-center">
            <h1 style="padding-top: 100px">View Book</h1>
        </section>
        <section class="d-flex justify-content-center align-items-center">
            <section class="col-7">
                <form action="${pageContext.request.contextPath}/admin-book/searchadmin" method="get" class="m-3">
                    <section class="d-flex justify-content-end bg-white">
                        <section class="input-group px-3 w-50 border border-dark rounded-pill me-3">
                            <input type="text" class="form-control border-0" placeholder="Search..." name="search">
                            <button class="btn btn-light bd-0" type="submit"><span
                                    class="input-group-text bg-white border-0"
                                    id="basic-addon1"> <i class="bi bi-search"></i> </span></button>
                        </section>
                        <section class="input-group px-3 w-auto border border-dark rounded-pill">
                            <select class="form-select  border-0 rounded-pill" aria-label="Default select example"
                                    name="filter">
                                <option value="BookTitle">Title</option>
                                <option value="Author">Author</option>
                                <option value="Publisher">Publisher</option>
                            </select>
                            <span class="input-group-text bg-white border-0" id="basic-addon2"> <i
                                    class="bi bi-funnel pe-2"></i>
                </span>
                        </section>
                    </section>
                </form>
            </section>
            <section class="col-1">
                <a href="admin-book/create"
                   class="text-decoration-none btn btn-success border border-1 rounded-pill w-100" style="color: black;">Create
                    Book</a>
            </section>
        </section>
    </section>
</header>
        <div class="container-fluid">
            <table class="table table-secondary table-bordered">
                <thead>
                <tr>
                    <th scope="col">BookId</th>
                    <th scope="col">BookTitle</th>
                    <th scope="col">Author</th>
                    <th scope="col">Brief</th>
                    <th scope="col">Publisher</th>
                    <th scope="col">Content</th>
                    <th scope="col">Image</th>
                    <th scope="col">Created date</th>
                    <th scope="col">Category</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <%for (Book book : listbook) { %>
                <tr>
                    <td><%=book.getbookId()%>
                    </td>
                    <td><%=book.getbookTitle()%>
                    </td>
                    <td><%=book.getauthor()%>
                    </td>
                    <td><%=book.getBrief()%>
                    </td>
                    <td><%=book.getPublisher()%>
                    </td>
                    <td><%=book.getContent()%>
                    </td>
                    <td>
                        <img src="<%=book.getImage()%>" alt="">
                    </td>
                    <td><%=book.getcreateDate()%>
                    </td>
                    <td><%=book.getCategory().getcategoryName()%>
                    </td>
                    <td>
                        <a href="admin-book/edit?bookId=<%=book.getbookId()%>"
                           class="text-decoration-none btn btn-success rounded-pill mb-3 action-btn"
                           style="color: black;">Edit</a>
                        <a href="admin-book/delete?bookId=<%=book.getbookId()%>" class="btn btn-danger rounded-pill action-btn"
                           onclick="return confirm('Are you sure to delete?')">Delete</a>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
            integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
            crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
            integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
            crossorigin="anonymous"></script>
    <c:if test="${sessionScope.insert ne null}">
        <!-- Modal -->
        <div class="modal hide" id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                            ${sessionScope.insert}
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <script>
            var myModal = new bootstrap.Modal(document.getElementById('myModal'), {})
            myModal.toggle()
        </script>
        <c:remove var="insert" scope="session"></c:remove>
    </c:if>
</body>

</html>