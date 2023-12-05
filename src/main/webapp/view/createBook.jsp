<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Create</title>
    <link rel="stylesheet" href="../css/styleAdmin.css" >
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
<div class="container">
    <div class="text-edit">
        <h1 class="text-center">Create Book</h1>
    </div>
    <div class="row">
        <div class="col-lg-3">
            <h5 class="text-small text-primary">Your image will show below</h5>
            <img
                    class="img-edit-create"
                    src=""
                    id="imageOutput"
            />
        </div>
        <div class="col-lg-9">
            <form action="create" method="post" name="createForm" onsubmit="return validate();">
                <div class="mb-3 mt-4 row">
                    <label for="title" class="col-sm-2 col-form-label">Title:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="title" name="title" required/>
                    </div>
                    <small class="text-danger" id="title-err"></small>
                </div>
                <div class="mb-3 mt-4 row">
                    <label for="author" class="col-sm-2 col-form-label"
                    >Author:</label
                    >
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="author" name="author" required/>
                    </div>
                    <small class="text-danger" id="author-err"></small>
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
                ></textarea>
                    </div>
                    <small class="text-danger" id="brief-err"></small>
                </div>
                <div class="mb-3 mt-4 row">
                    <label for="publisher" class="col-sm-2 col-form-label"
                    >Publisher:</label
                    >
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="publisher" name="publisher" required/>
                    </div>
                    <small class="text-danger" id="publisher-err"></small>
                </div>
                <div class="mb-3 mt-4 row">
                    <label for="category" class="col-sm-2 col-form-label"
                    >Category:</label
                    >
                    <div class="col-sm-10">
                        <select name="category" id="category" class="form-select" required>
                            <c:forEach var="item" items="${categoryList}">
                                <option value="${item.categoryId}" name="categoryId">${item.categoryName}</option>
                            </c:forEach>
                        </select>
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
                ></textarea>
                    </div>
                    <small class="text-danger" id="content-err"></small>
                </div>
                <div class="mb-3 mt-4 row">
                    <label for="date" class="col-sm-2 col-form-label"
                    >Create date:</label
                    >
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="date" name="date" required/>
                    </div>
                </div>
                <div class="mb-3 mt-4 row">
                    <label for="img" class="col-sm-2 col-form-label">Image:</label>
                    <div class="col-sm-10">
                        <input
                                type="text"
                                class="form-control"
                                id="img"
                                name="img"
                                onchange="changeURL()"
                                required
                        />
                    </div>
                    <small class="text-danger" id="imgURL-err"></small>
                </div>
                <div class="mb-3 mt-4 row">
                    <label for="submit" class="col-sm-2 col-form-label"></label>
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
    function validate(){
        let title = document.forms['createForm']['title'].value;
        let author = document.forms['createForm']['author'].value;
        let brief = document.forms['createForm']['brief'].value;
        let publisher = document.forms['createForm']['publisher'].value;
        let content = document.forms['createForm']['content'].value;
        let imgURL = document.forms['createForm']['img'].value;
        let titleErr = document.getElementById('title-err');
        let authorErr = document.getElementById('author-err');
        let briefErr = document.getElementById('brief-err');
        let publisherErr = document.getElementById('publisher-err');
        let contentErr = document.getElementById('content-err');
        let imgURLErr = document.getElementById('imgURL-err');
        if(title.length < 5 || title.length > 50){
            titleErr.innerHTML = 'Title must between 5 to 50 characters';
            return false;
        }
        if(author.length < 5 || title.length > 50){
            authorErr.innerHTML = 'Author must between 5 to 50 characters';
            return false;
        }
        if(brief.length < 5 || brief.length > 255){
            briefErr.innerHTML = 'Brief must between 5 to 255 characters';
            return false;
        }
        if(publisher.length < 5 || publisher.length > 50){
            publisherErr.innerHTML = 'Publisher must between 5 to 50 characters';
            return false;
        }
        if(content.length < 5 || content.length > 255){
            contentErr.innerHTML = 'Content must between 5 to 255 characters';
            return false;
        }
        if(imgURL.length == 0){
            imgURLErr.innerHTML = 'ImgURL must not be blank';
            return false;
        }
        return true;
    }
</script>
</body>

</html>

