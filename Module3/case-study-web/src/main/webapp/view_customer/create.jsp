<%--
  Created by IntelliJ IDEA.
  User: 84384
  Date: 11/9/2022
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
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
                    Add Customer
                </h2>
            </caption>
            <tr>
                <th>ID:</th>
                <td>
                    <input type="text" name="id" id="id" size="45" placeholder="nhập id"/>
                    <c:if test="${!errorMap.isEmpty()}">
                        <p style="color:red;">${errorMap.get("errorId")}</p><br>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>Customer type:</th>
                <td>
                    <select name="customer_type_id">
                        <c:forEach var="cusType" items="${customerTypeList}">
                            <option value="${cusType.getId()}">${cusType.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input placeholder="nhập tên" required pattern="^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[ ])*([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$" title="Tên không chưa kí tự số hoặc đặc biệt hoặc chưa đúng định dạng" type="text" name="name" id="name" size="45"
                    />
                </td>
            </tr>
            <tr>
                <th>Day of birth:</th>
                <td>
                    <input type="date" name="day_of_birth" id="day_of_birth" size="45"
                    />
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <input type="radio" name="gender" size="45" value="true">Nam
                    <input type="radio" name="gender" size="45" value="false">Nữ
                </td>
            </tr>
            <tr>
                <th>Id card:</th>
                <td>
                    <input placeholder="nhập cccd" required pattern="^[0-9]{12}$" title="Số CCCD phải là 12 số" type="text" name="id_card" id="id_card" size="45"
                    />
                </td>
            </tr>
            <tr>
                <th>Phone number:</th>
                <td>
                    <input placeholder="nhập số điện thoại" required pattern="^(((\+|)84)|0)(3|5|7|8|9)+([0-9]{8})$" title="Số điện thoại chưa đúng định dạng" type="text" name="phone_number" id="phone_number" size="45"
                    />
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input placeholder="nhập email" required pattern="^[A-Za-z0-9]*[@][A-Za-z0-9]+[.][A-Za-z0-9]+$" title="Email chưa đúng định dạng" type="text" name="email" id="email" size="45"
                    />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input placeholder="nhập địa chỉ" type="text" name="address" id="address" size="45"
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
<script>
    <c:if test="${messAdd != null}">
    alert("${messAdd}");
    </c:if>
</script>
</body>
</html>
