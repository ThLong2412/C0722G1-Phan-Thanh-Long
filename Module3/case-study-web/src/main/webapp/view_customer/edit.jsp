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
        <a href="/customer?action=customer">Back to list customer</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Customer
                </h2>
            </caption>
            <c:if test="${customer != null}">
                <input type="hidden" name="id" value="<c:out value='${customer.getId()}' />"/>
            </c:if>
            <tr>
                <th>Customer type:</th>
                <td>
                    <select name="customer_type_id">
                        <c:forEach var="cusType" items="${customerTypeList}">
                            <option value="${cusType.getId()}"
                                    <c:if test="${cusType.getId() == customer.getCustomerType()}"
                                    > selected </c:if> >${cusType.getName()}</option>
                        </c:forEach>
                    </select>
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
                    <input type="date" name="day_of_birth" size="45"
                           value="<c:out value='${customer.getBirthday()}'/>"
                    />
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <input type="radio" name="gender" size="45" <c:if test="${customer.isGender()}">checked</c:if>>Nam
                    <input type="radio" name="gender" size="45" <c:if test="${!customer.isGender()}">checked</c:if> >Nữ
<%--                    <input type="text" name="gender" size="45"--%>
<%--                           value="<c:out value='${customer.isGender()}'/>"--%>
<%--                    />--%>
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
                    <input type="submit" value="Update"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<script>
    <c:if test="${messUpdate != null}">
    alert("${messUpdate}");
    </c:if>
</script>
</body>
</html>
