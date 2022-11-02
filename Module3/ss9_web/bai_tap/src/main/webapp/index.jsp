<%--
  Created by IntelliJ IDEA.
  User: 84384
  Date: 11/2/2022
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <form action="/display_discount" method="post">
    <p style="color: red">Mô tả sản phẩm</p>
    <input name="product_description" style="background-color: aquamarine">
    <p style="color: red">Giá niêm yết</p>
    <input name="price" style="background-color: aquamarine">
    <p style="color: red">Tỉ lệ chiết khấu</p>
    <input name="discount_percent" style="background-color: aquamarine">
    <br>
    <br>
    <button type="submit" style="background-color: aqua">Calculate Discount</button>
  </form>
  </body>
</html>
