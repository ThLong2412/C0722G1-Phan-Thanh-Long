<%--
  Created by IntelliJ IDEA.
  User: 84384
  Date: 11/5/2022
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trang thêm mới</title>
</head>
<body>
<a href="/product">Quay lại trang chủ</a>
<c:if test="${mess!=null}" >
    <span style="color: red">${mess}</span>
</c:if>
<form action="/product?action=add" method="post">
    <pre>ID:          <input type="text" name="id"></pre>
    <pre>Name:        <input type="text" name="name"></pre>
    <pre>Price:       <input type="text" name="price"></pre>
    <pre>Describe:    <input type="text" name="describe"></pre>
    <pre>Producer:    <input type="text" name="producer"></pre>
    <pre>             <button>Save</button></pre>
</form>
</body>
</html>
