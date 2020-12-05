<%--
  Created by IntelliJ IDEA.
  User: agcl3
  Date: 05.12.2020
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="resourses/styles/main.css">
    <fmt:setLocale value="${sessionScope.local}" />
    <fmt:setBundle basename="local" var="var" />
    <fmt:message bundle="${var}" key="lang.but.name.en" var="EN"/>
    <fmt:message bundle="${var}" key="lang.but.name.ru" var="RU"/>
</head>
<body>
<table>
    <tr>
        <th>
            <form action="Controller" method="post">
            <input type="hidden" name="command" value="changeLocale" />
            <input type="hidden" name="local" value="en_US" />
            <input type="submit" value="${EN}" />
            </form>
        </th>
        <th>
            <form action="Controller" method="post">
                <input type="hidden" name="command" value="changeLocale" />
                <input type="hidden" name="local" value="ru_RU" />
                <input type="submit" value="${RU}" />
            </form>
        </th>
    </tr>
</table>
</body>
</html>
