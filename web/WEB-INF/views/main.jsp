<%--
  Created by IntelliJ IDEA.
  User: agcl3
  Date: 04.12.2020
  Time: 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${user==null}">
    <c:redirect url="Controller?command=go_to_main"/>
</c:if>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/header.jsp" />
</header>
<c:if test="${sessionScope.user.roleName=='Patient'}">
    <h1> <c:out value="${sessionScope.user.roleName}"/></h1>
</c:if>
<jsp:include page="/WEB-INF/views/menu.jsp" />
<a href="Controller?command=signout">LogOut</a>
</body>
</html>
