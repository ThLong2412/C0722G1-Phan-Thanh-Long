<%--
  Created by IntelliJ IDEA.
  User: 84384
  Date: 11/20/2022
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>

  <form action="" method="post">
    <input type="checkbox" id="vehicle1" name="condiment" value="Lettuce">
    <label for="vehicle1"> Lettuce </label><br>
    <input type="checkbox" id="vehicle2" name="condiment" value="Tomato">
    <label for="vehicle2"> Tomato </label><br>
    <input type="checkbox" id="vehicle3" name="condiment" value="Mustard">
    <label for="vehicle3"> Mustard </label><br>
    <input type="checkbox" id="vehicle4" name="condiment" value="Sprouts">
    <label for="vehicle4"> Sprouts </label><br><br>
    <input type="submit" value="Save">
  </form>
  <c:forEach var="s" items="${condiment}">
    <p>
      ${s}
    </p>
  </c:forEach>
  </body>
</html>
