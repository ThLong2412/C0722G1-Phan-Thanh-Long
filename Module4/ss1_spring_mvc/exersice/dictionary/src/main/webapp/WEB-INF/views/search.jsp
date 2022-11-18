<%--
  Created by IntelliJ IDEA.
  User: 84384
  Date: 11/18/2022
  Time: 11:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form method="post" style="text-align: center; background-color: aquamarine">
        <legend>Nhập(chọn) từ muốn dịch</legend>
        <div class="mb-3">
            <input type="text" name="value" value="${value}">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
</form>
<h1>
    <c:if test="${value != null}">
        ${dictionary.get(value)}
    </c:if>
    <c:if test="${value.length()==0 or !dictionary.containsKey(value)}">
        ${notFound}
    </c:if>
</h1>

<%--    <c:if test="${value != null}">--%>
<%--        <script>--%>
<%--            alert("${value} có nghĩa là: ${dictionary.get(value)}");--%>
<%--        </script>--%>
<%--    </c:if>--%>
<%--<script>--%>
<%--    for (let i = 0; i < ${dictionary.size()} ;i++) {--%>
<%--        if (${value != null}) {--%>
<%--            alert("${value} có nghĩa là: ${dictionary.get(value)}");--%>
<%--            break;--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>
