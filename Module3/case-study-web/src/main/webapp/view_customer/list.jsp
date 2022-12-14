<%--
  Created by IntelliJ IDEA.
  User: 84384
  Date: 11/7/2022
  Time: 5:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách khách hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
</head>
<body>
<center>
    <h1>LIST CUSTOMER</h1>
</center>
<center>
    <a class="btn btn-primary" href="index.jsp" role="button">Home</a>
</center>
<center>
    <h2>
        <a href="/customer?action=create">Add Customer</a>
    </h2>
</center>
<center>
    <div>
        <form action="/customer?action=search" method="post">
            <div class="form-outline mb-4">
                <input type="search" value="${name}" class="form-control me-2 justify-content-between" name="name"
                       placeholder="Enter name want search">
                <input type="search" value="${address}" class="form-control me-2 justify-content-between" name="address"
                       placeholder="Enter address want search">
                <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Search
                </button>
            </div>
        </form>
    </div>
</center>
<div class="row" style=" margin: 0; padding:0; overflow: auto">
    <table class="table table-striped" id="tableCustomer">
        <thead>
        <tr>
            <th class="col-lg-1">STT</th>
            <th class="col-lg-1">Customer type</th>
            <th class="col-lg-1">Name</th>
            <th class="col-lg-1">Day 0f birth</th>
            <th class="col-lg-1">Gender</th>
            <th class="col-lg-1">Id card</th>
            <th class="col-lg-1">Phone number</th>
            <th class="col-lg-1">Email</th>
            <th class="col-lg-1">Address</th>
            <th class="col-lg-1" style="text-align: center">Function</th>
            <th class="col-lg-1" style="text-align: center">Function</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customerList}" varStatus="stt">
            <tr>
                <td><c:out value="${stt.count}"/></td>
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
                <td>
                    <button class="btn btn-success" type="button"><a href="/customer?action=edit&id=${customer.getId()}"
                                                                     style="color: white">Edit</a></button>
                </td>
                <td>
                    <button type="button" onclick="idRemove('${customer.getId()}','${customer.getName()}')"
                            class="btn btn-danger" data-bs-toggle="modal"
                            data-bs-target="#exampleRemove">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="modal fade" id="exampleRemove" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">DELETE</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Are you sure to delete this customer ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel
                </button>
                <form action="/customer?action=delete" method="post">
                    <input type="hidden" name="id" id="idInput">
                    <button class="btn btn-primary" type="submit">Delete</button>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
<script>
    function idRemove(id, name) {
        document.getElementById("idInput").value = id;
    }

    document.getElementById('datatable-search-input').addEventListener('input', (e) => {
        instance.input - group(e.target.value);
    });

</script>
<script>
    <c:if test="${messDelete != null}">
    alert("${messDelete}");
    </c:if>
</script>
</body>
</html>
