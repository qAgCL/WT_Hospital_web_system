<%--
  Created by IntelliJ IDEA.
  User: agcl3
  Date: 02.12.2020
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${user!=null}">
    <c:redirect url="Controller?command=go_to_main"/>
</c:if>
<html>
<head>
    <title>Durka</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="resourses/images/main.ico">
    <link rel="stylesheet" type="text/css" href="resourses/styles/main.css">
</head>
<body>
<div class="startPage">
    <div class="loginTable">
        <div class="login100-pic js-tilt" data-tilt>
            <img src="resourses/images/welcome.png">
        </div>
        <form class="loginForm" action="Controller" method="post">
            <input type="hidden" name="command" value="signUp" />
            <span class="loginForm-title">
					Welcome to the durka, buddy
				</span>
            <c:if test="${param.signup == 'error'}">
                <span class="errorMessage-title">
					SignUp error
                </span>
            </c:if>
            <c:if test="${param.signup == 'unique'}">
                <span class="errorMessage-title">
					This user is already exist
                </span>
            </c:if>
            <div class=".startPage-form-input">
                <input class="input" type="text" id="name" name="name" placeholder="Name" required>
            </div>
            <div class=".startPage-form-input">
                <input class="input" type="text" id="surname" name="surname" placeholder="surname" required>
            </div>
            <div class=".startPage-form-input">
                <input class="input" type="date" id="birth" name="birth" placeholder="surname" required>
            </div>
            <div class=".startPage-form-input">
                <input class="input" type="text" id="phone" name="phone" placeholder="surname" required>
            </div>
            <div class=".startPage-form-input">
                <input class="input" type="text" id="email" name="email" placeholder="Email" required>
            </div>
            <div class=".startPage-form-input">
                <input class="input" type="password" id="password" name="password" placeholder="password" required>
            </div>
            <div class="startPage-form-btn">
                <button class="loginForm-btn">
                    Sign In
                </button>
            </div>
            <a class="txt2" href='Controller?command=go_to_signin'>
                Already have an account?
            </a>
        </form>
    </div>
</div>
</body>
</html>