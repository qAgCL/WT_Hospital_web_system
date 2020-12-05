<%--
  Created by IntelliJ IDEA.
  User: agcl3
  Date: 05.12.2020
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${user==null}">
    <c:redirect url="Controller?command=go_to_main"/>
</c:if>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<header>
    <jsp:include page="/WEB-INF/views/header.jsp" />
</header>
    <c:if test = "${sessionScope.user.roleName == 'Patient'}">
        <c:out value = "${sessionScope.user.name}"/>
        <a href="Controller?command=viewmaps">HashMap</a>
        <a href="Controller?command=viewoperations">HashMap</a>
        <a href="Controller?command=viewprocedures">HashMap</a>
        <a href="Controller?command=viewmedines">HashMap</a>
    </c:if>
</body>
</html>
