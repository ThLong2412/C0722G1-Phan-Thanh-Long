<%--
  Created by IntelliJ IDEA.
  User: 84384
  Date: 11/8/2022
  Time: 9:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>trang edit</title>
</head>
<body>
<center>
    <h2>
        <a href="/customer?action=customer">Quay lại trang danh sách</a>
    </h2>
</center>
<center>
    <div style="float: right;margin-right: 100px">
        <form action="/customer?action=search" method="post">
            <input type="text" placeholder="nhập id muốn tìm kiếm" name="id">
            <span> <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Tìm kiếm
    </button></span>
        </form>
    </div>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Cusotmer
                </h2>
            </caption>
            <c:if test="${customer != null}">
                <input type="hidden" name="id" value="<c:out value='${customer.getId()}' />"/>
            </c:if>
            <tr>
                <th>Customer type:</th>
                <td>
                    <input type="text" name="customer_type_id" size="45"
                           value="<c:out value='${customer.getCustomerType()}'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${customer.getName()}'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Day of birth:</th>
                <td>
                    <input type="text" name="day_of_birth" size="45"
                           value="<c:out value='${customer.getBirthday()}'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <input type="text" name="gender" size="45"
                           value="<c:out value='${customer.isGender()}'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Id card:</th>
                <td>
                    <input type="text" name="id_card" size="45"
                           value="<c:out value='${customer.getIdCard()}'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Phone number:</th>
                <td>
                    <input type="text" name="phone_number" size="45"
                           value="<c:out value='${customer.getPhoneNumber()}'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${customer.getEmail()}'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${customer.getAddress()}'/>"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
