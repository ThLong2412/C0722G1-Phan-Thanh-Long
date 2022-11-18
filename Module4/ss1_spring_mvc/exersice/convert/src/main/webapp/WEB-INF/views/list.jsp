<%--
  Created by IntelliJ IDEA.
  User: 84384
  Date: 11/18/2022
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<form class="mb-5" action="" method="post" style="text-align: center; background-color: aquamarine">
    <div class="mb-3">
        <input type="text" name="usd" value="${usd}">
    </div>
    <div class="mb-3">
        <input placeholder="nhập vnd" type="text" name="vnd" value="${vnd}">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<h1>
    ${vndAfter}
    <br>
    ${usdAfter}
</h1>
</body>
</html>
