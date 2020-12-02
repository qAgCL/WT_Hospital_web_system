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
    <link rel="icon" type="image/png" href="images/main.ico">
    <link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>
<div class="startPage">
    <div class="loginTable">
        <div class="login100-pic js-tilt" data-tilt>
            <img src="images/welcome.png">
        </div>
        <form class="loginForm" action="Controller" method="post">
				<span class="loginForm-title">
					SignIn to the durka, buddy
				</span>
            <div class="startPage-form-btn">
                <button class="loginForm-btn">
                    SingIn
                </button>
            </div>
            <div class="startPage-form-btn">
                <button class="loginForm-btn">
                    SingUp
                </button>
            </div>
        </form>
    </div>
</div>
</body>
</html>