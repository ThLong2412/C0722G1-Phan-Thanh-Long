<%--
  Created by IntelliJ IDEA.
  User: 84384
  Date: 11/21/2022
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form action="" method="post">
    <label>
      <input type="number" name="value1" value="${value1}">
    </label>
    <label>
      <input type="number" name="value2" value="${value2}" >
    </label>
    <br>
    <br>
    <input type="submit" name="func" value="+">
    <input type="submit" name="func" value="-">
    <input type="submit" name="func" value="*">
    <input type="submit" name="func" value="/">
   <script>
     alert("Kết quả là: " ${result});
   </script>
  </form>
  </body>
</html>
