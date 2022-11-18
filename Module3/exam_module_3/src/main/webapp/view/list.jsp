<%--
  Created by IntelliJ IDEA.
  User: 84384
  Date: 11/15/2022
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trang danh sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<div style="font-size: 75px;display: flex; justify-content: center; align-items: center; background-color: aquamarine; color: black">
    <p>Phan Thanh Long</p></div>
<nav class="navbar navbar-light bg-light">
    <div class="container-fluid">
        <a class="btn btn-primary" href="home.jsp" role="button">Về lại trang chủ</a>
        <form class="d-flex" action="" method="post">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="" value="">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
</nav>
<br>
<div>
    <table class="table table-striped">
        <thead>
        <th>STT</th>
        <th>Mã bệnh án</th>
        <th>Mã bệnh nhân</th>
        <th>Tên bệnh nhân</th>
        <th>Ngày nhập viện</th>
        <th>Ngày ra viện</th>
        <th>Lý do nhập viện</th>
        <th>Sửa</th>
        <th>Xóa</th>
        </thead>
        <tbody>
        <c:forEach var="benhan" items="${benhAnList}" varStatus="stt">
            <tr>
                <td> <c:out value="${stt.count}"/></td>
                <td> <c:out value="${benhan.getId()}"/></td>
                <c:forEach var="benhnhan" items="${benhNhanList}">
                    <c:if test="${benhan.getMaBenhNhan() == benhnhan.getId()}">
                        <td>${benhnhan.getIdBenhNhan()}</td>
                    </c:if>
                </c:forEach>
                <c:forEach var="benhnhan" items="${benhNhanList}">
                    <c:if test="${benhan.getMaBenhNhan() == benhnhan.getId()}">
                        <td>${benhnhan.getTenBenhNhan()}</td>
                    </c:if>
                </c:forEach>
                <td> <c:out value="${benhan.getNgayNhapVien()}"/></td>
                <td> <c:out value="${benhan.getNgayRaVien()}"/></td>
                <td> <c:out value="${benhan.getLyDoNhapVien()}"/></td>
            </tr>
            <td>
                <button class="btn btn-success" type="button"><a href=""
                                                                 style="color: white">Sửa</a></button>
            </td>
            <td>
                <button type="button"
                        class="btn btn-danger" data-bs-toggle="modal"
                        data-bs-target="#exampleRemove">
                    Xóa
                </button>
            </td>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
