<%--
  Created by IntelliJ IDEA.
  User: 84384
  Date: 11/7/2022
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Trang tìm kiếm</title>
</head>
<body>
<center>
    <h2>
        <a href="users?action=users">Quay lại trang danh sách</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.getId()}"/></td>
                <td><c:out value="${user.getName()}"/></td>
                <td><c:out value="${user.getEmail()}"/></td>
                <td><c:out value="${user.getCountry()}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
