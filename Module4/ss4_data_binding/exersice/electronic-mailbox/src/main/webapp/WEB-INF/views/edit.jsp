<%--
  Created by IntelliJ IDEA.
  User: 84384
  Date: 11/22/2022
  Time: 1:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/edit" method="post" modelAttribute="mailbox">
    <form:hidden path="id"/>
    <form:label path="languages"/> Languages
    <form:select path="languages" items="${languageList}"/>
    <br>
    <form:label path="pageSize"/> Page Size
    <form:select path="pageSize" items="${pageSizeList}"/>
    <br>
    <form:label path="spamsFilter"/>Spams Filter
    <form:checkbox path="spamsFilter"/>
    <br>
    <form:label path="signature"/> Signature
    <form:textarea path="signature"/>
    <br>
    <input type="submit" value="Update">
</form:form>
<a href="home">back to home</a>
</body>
</html>
