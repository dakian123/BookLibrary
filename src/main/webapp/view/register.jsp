<%--
  Created by IntelliJ IDEA.
  User: ThinkKING
  Date: 8/9/2022
  Time: 12:27 PM
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
          type="text/css"/>
    <link rel="stylesheet" href="./css/registerStyle.css">
</head>
<%String msg = (String) request.getAttribute("msg");
if(msg==null){
    msg = "";
}%>
<%String msg1 = (String) request.getAttribute("msg1");
    if(msg1==null){
        msg1 = "";
    }%>

<body>

<div class="login">
    <div class="d-flex justify-content-center col-xl-12">
        <div class="card border-75 bg-light bg-opacity-50 mb-4">
            <div class="card-body">
                <h3 class="card-title fw-bold">WELCOME TO BOOK MANAGEMENT</h3>
                <h4 class="card-title fw-bold">Let's begin the adventure</h4>
                <h3 class="card-subtitle pt-3    d-flex justify-content-center">Register</h3>
                <br>
                <form action="register" method="POST" id="register-form" novalidate>
                    <div class="d-flex justify-content-center mb-3">
                        <div class="input input-group">
                            <span class="input-group-text bg-white border-end-0"><i
                                    class="bi bi-person-fill"></i></span> <input
                                type="text" name="username" class="form-control border-start-0 w-75" id="loguser" required
                                placeholder="Username" maxlength="50">
                        </div>

                    </div>

                    <div class="d-flex justify-content-center mb-3">
                        <div class="input input-group">
                            <span class="input-group-text bg-white border-end-0"><i class="bi bi-lock-fill"></i></span>

                            <input type="password" name="password" class="form-control  border-start-0 w-75" id="logpass"
                                   required
                                   placeholder="Password" maxlength="50">
                        </div>
                    </div>
                    <div class="d-flex justify-content-center mb-3">
                        <div class="input input-group">
                            <span class="input-group-text bg-white border-end-0"><i class="bi bi-lock-fill"></i></span>

                            <input type="password" name="repassword" class="form-control  border-start-0 w-75" id="relogpass"
                                   required
                                   placeholder="Confirm Password" maxlength="50">
                        </div>
                    </div>
                    <br>
                    <div class="d-flex justify-content-center mb-3">
                        <h4 class=" text-danger" style="font-style: italic"><%=msg%></h4>
                        <h4 class=" text-danger" style="font-style: italic"><%=msg1%></h4>
                    </div>

                    <div class="login-btn d-flex justify-content-center">
                        <button type="submit" name="register" value="register" class="btn-login btn btn-dark btn-lg btn-block w-50">Create Account
                        </button>
                    </div>
                    <br> <span class="d-flex justify-content-center">Already has an account?&nbsp;<a href="login"
                                                                                                     class="link-primary"> Sign in</a></span>

                </form>


            </div>
        </div>
    </div>

</div>
<script src="https://unpkg.com/just-validate@latest/dist/just-validate.production.min.js"></script>
<script>
    const validate = new window.JustValidate('#register-form');
    validate.addField('#loguser', [
        {
            rule: 'minLength',
            value: 6,
        },
        {
            rule: 'maxLength',
            value: 50,
        },
        {
            rule: 'required',
            errorMessage: 'Username is required'
        }
    ]).addField('#logpass', [
        {
            rule: 'customRegexp',
            value: /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*]).{6,50}$/,
            errorMessage: 'At least 1 upper, 1 lower, 1 number, 1 character'
        },
        {
            rule: 'maxLength',
            value: 50,
        },
        {
            rule: 'minLength',
            value: 6,
        },
        {
            rule: 'required',
            errorMessage: 'Password is required'
        }
    ]).addField('#relogpass', [
        {
            validator: (value, fields) => {
                if (fields['#logpass'] && fields['#logpass'].elem) {
                    const repeatPasswordValue = fields['#logpass'].elem.value;

                    return value === repeatPasswordValue;
                }

                return true;
            },
            errorMessage: 'Passwords should be the same',
        },
    ]).onSuccess(()=> {

            document.forms["register-form"].submit();

        });
    ;
</script>
</body>

</html>
