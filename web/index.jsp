<%--
  Created by IntelliJ IDEA.
  User: agcl3
  Date: 02.12.2020
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:if test="${user!=null}">
    <c:redirect url="Controller?command=go_to_main"/>
</c:if>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" href="resourses/images/main.ico">
    <link rel="stylesheet" type="text/css" href="resourses/styles/main.css">
    <fmt:setLocale value="${sessionScope.local}" />
    <fmt:setBundle basename="local" var="var" />
    <fmt:message bundle="${var}" key="lang.but.name.en" var="EN"/>
    <fmt:message bundle="${var}" key="main.hello" var="hello"/>
    <fmt:message bundle="${var}" key="main.title" var="title"/>
    <fmt:message bundle="${var}" key="main.signin" var="signin"/>
    <fmt:message bundle="${var}" key="main.signup" var="signup"/>
    <title>${title}</title>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/header.jsp" />
</header>
<div class="startPage">
    <div class="loginTable">
        <div class="login100-pic js-tilt" data-tilt>
            <img src="resourses/images/welcome.png">
        </div>
        <div class="loginForm">
				<span class="loginForm-title">
					${hello}
				</span>
            <div class="startPage-form-btn">
                <button class="loginForm-btn" onclick="location.href='Controller?command=go_to_signin'">
                    ${signin}
                </button>
            </div>
            <div class="startPage-form-btn">
                <button class="loginForm-btn" onclick="location.href='Controller?command=go_to_signup'">
                    ${signup}
                </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>