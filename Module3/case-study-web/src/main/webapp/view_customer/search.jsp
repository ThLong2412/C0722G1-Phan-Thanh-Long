<%--
  Created by IntelliJ IDEA.
  User: 84384
  Date: 11/9/2022
  Time: 11:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<center>
    <h2>
        <a href="/customer?action=customer">Quay lại trang danh sách</a>
    </h2>
</center>
<div class="row" style=" margin: 0; padding:0; overflow: auto">
    <table class="table table-striped">
        <thead>
        <tr>
            <th class="col-lg-1">Customer id</th>
            <th class="col-lg-1">Customer type</th>
            <th class="col-lg-1">Name</th>
            <th class="col-lg-1">Day 0f birth</th>
            <th class="col-lg-1">Gender</th>
            <th class="col-lg-1">Id card</th>
            <th class="col-lg-1">Phone number</th>
            <th class="col-lg-1">Email</th>
            <th class="col-lg-1">Address</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td><c:out value="${customer.getId()}"/></td>
                <c:forEach var="cusType" items="${customerTypeList}">
                    <c:if test="${cusType.getId() == customer.getCustomerType()}">
                        <td>${cusType.getName()}</td>
                    </c:if>
                </c:forEach>
                <td><c:out value="${customer.getName()}"/></td>
                <td><c:out value="${customer.getBirthday()}"/></td>
                <c:if test="${customer.isGender()}">
                    <td>Nam</td>
                </c:if>
                <c:if test="${!customer.isGender()}">
                    <td>Nữ</td>
                </c:if>
                <td><c:out value="${customer.getIdCard()}"/></td>
                <td><c:out value="${customer.getPhoneNumber()}"/></td>
                <td><c:out value="${customer.getEmail()}"/></td>
                <td><c:out value="${customer.getAddress()}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>
</body>
</html>
