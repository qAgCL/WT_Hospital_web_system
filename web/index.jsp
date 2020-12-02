<%--
  Created by IntelliJ IDEA.
  User: agcl3
  Date: 02.12.2020
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Durka</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="main.ico">
    <link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
<div class="startPage">
    <div class="loginTable">
        <div class="login100-pic js-tilt" data-tilt>
            <img src="welcome.png">
        </div>
        <div class="loginForm">
				<span class="loginForm-title">
					Welcome to the durka, buddy
				</span>
            <div class="startPage-form-btn">
                <button class="loginForm-btn" onclick="location.href='Controller?command=go_to_signin'">
                    SingIn
                </button>
            </div>
            <div class="startPage-form-btn">
                <button class="loginForm-btn" onclick="location.href='Controller?command=go_to_signup'">
                    SingIn
                </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>