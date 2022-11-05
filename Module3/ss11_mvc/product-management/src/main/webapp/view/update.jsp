<%--
  Created by IntelliJ IDEA.
  User: 84384
  Date: 11/5/2022
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trang update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
</c:if>
<form action="/product?action=update" method="post">
    <fieldset>
        <table>
            <tr>
                <td>ID</td>
                <th>Name</th>
                <th>Price</th>
                <th>Describe</th>
                <th>Producer</th>
            </tr>
            <tr>
                <td><input type="text" name="id" value="${requestScope["product"].getId()}"></td>
                <td><input type="text" name="name" value="${requestScope["product"].getName()}"></td>
                <td><input type="text" name="price" value="${requestScope["product"].getPrice()}"></td>
                <td><input type="text" name="describe" value="${requestScope["product"].getDescribe()}"></td>
                <td><input type="text" name="producer" value="${requestScope["product"].getProducer()}"></td>
            </tr>
        </table>
        <button>Update</button>
    </fieldset>
</form>
</body>
</html>
