<%--
  Created by IntelliJ IDEA.
  User: 84384
  Date: 11/5/2022
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trang hiển thị thông tin 1 khách hàng</title>
</head>
<body>
<p>
    <a href="/product">Quay lại trang danh sách</a>
</p>
<form action="/product?action=view" method="get">
    <table>
        <tr>
            <td>Id: </td>
            <td>${requestScope["product"].getId()}</td>
        </tr>
        <tr>
            <td>Name: </td>
            <td>${requestScope["product"].getName()}</td>
        </tr>
        <tr>
            <td>Price: </td>
            <td>${requestScope["product"].getPrice()}</td>
        </tr>
        <tr>
            <td>Describe: </td>
            <td>${requestScope["product"].getDescribe()}</td>
        </tr>
        <tr>
            <td>Producer: </td>
            <td>${requestScope["product"].getProducer()}</td>
        </tr>
    </table>
</form>

</body>
</html>
