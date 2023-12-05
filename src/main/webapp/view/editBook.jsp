<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Edit</title>
    <link rel="stylesheet" href="../css/styleAdmin.css">
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
            crossorigin="anonymous"
    />
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
            crossorigin="anonymous"
    ></script>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css"
    />
</head>
<body>
<jsp:include page="headerAdmin.jsp"></jsp:include>
<div class="container-fluid">
    <div class="text-edit mt-3">
        <h1 class="text-center">Edit Book</h1>
    </div>

    <div class="row">
        <div class="col-lg-4 col-md-6">
            <img
                    class="img-edit"
                    src="${book.image}"
                    id="imageOutput"
            />
        </div>

        <div class="col-lg-8 col-md-6">

            <form action="edit" method="post">
                <input type="hidden" name="bookid" value="${book.bookId}">
                <div class="mb-3 mt-4 row">
                    <label for="title" class="col-sm-2 col-form-label">Title:</label>
                    <div class="col-sm-10">
                        <input type="text" name="title" class="form-control" id="title" value="${book.bookTitle}" required />
                    </div>
                </div>
                <div class="mb-3 mt-4 row">
                    <label for="author" class="col-sm-2 col-form-label"
                    >Author:</label
                    >
                    <div class="col-sm-10">
                        <input type="text" name="author" class="form-control" id="author" value="${book.author}" required/>
                    </div>
                </div>
                <div class="mb-3 mt-4 row">
                    <label for="brief" class="col-sm-2 col-form-label">Brief:</label>
                    <div class="col-sm-10">
                <textarea
                        name="brief"
                        id="brief"
                        class="form-control"
                        rows="3"
                        required
                >${book.brief} </textarea>
                    </div>
                </div>
                <div class="mb-3 mt-4 row">
                    <label for="publisher" class="col-sm-2 col-form-label"
                    >Publisher:</label
                    >
                    <div class="col-sm-10">
                        <input type="text" name="publis" class="form-control" id="publisher" value="${book.publisher}" required />
                    </div>
                </div>
                <div class="mb-3 mt-4 row">
                    <label for="content" class="col-sm-2 col-form-label"

                    >Content:</label
                    >
                    <div class="col-sm-10">
                    <textarea
                            name="content"
                            id="content"
                            class="form-control"
                            rows="3"
                        required
                    >${book.content}</textarea></div>
                </div>
                <div class="mb-3 mt-4 row">
                    <label for="date" class="col-sm-2 col-form-label"
                    >Create date:</label
                    >
                    <div class="col-sm-10">
                        <input type="date" name="creatdate" class="form-control" id="date" value="${book.createDate}" />
                    </div>
                </div>
                <div class="mb-3 mt-4 row">
                    <label for="category" class="col-sm-2 col-form-label"
                    >Category</label
                    >
                    <div class="col-sm-10">
                        <select name="cate" id="category" class="form-select">
                               <c:forEach var="item" items="${categoryList}">
                            <option value="<c:out value="${item.categoryId}"/>" <c:if test="${item.categoryId eq book.category.categoryId}">selected</c:if> >${item.categoryName}</option>
                               </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="mb-3 mt-4 row">
                    <label for="img" class="col-sm-2 col-form-label">Image:</label>
                    <div class="col-sm-10">
                        <input
                                name="image"
                                type="text"
                                class="form-control"
                                id="img"
                                value="${book.image}"
                                onchange="changeURL()"
                        />
                    </div>
                </div>
                <div class="mb-3 mt-4 row">
                    <label for="submit" class="col-sm-2 col-form-lable"></label>
                    <div class="col-sm-10 text-center">
                        <button
                                type="submit"
                                class="btn btn-secondary btn-save"
                                id="submit"
                        >
                            Save
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    let changeURL = () =>{
        let img = document.getElementById('img');
        let imgOutput = document.getElementById('imageOutput');
        imgOutput.src = img.value;
    }
</script>
</body>

</html>

