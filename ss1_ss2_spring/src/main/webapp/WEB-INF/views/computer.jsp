<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 1/24/2026
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comp</title>
</head>
<body>
<form action="/home/computer" method="get">
    <input type="number" name="a" placeholder="Nhập a">
    <input type="number" name="b" placeholder="Nhập b">
    <input type="radio" name="op" value="+"> +
    <input type="radio" name="op" value="-"> -
    <input type="radio" name="op" value="*"> *
    <input type="radio" name="op" value="/"> /

    <button>Tính</button>
</form>

<c:if test="${not empty result}">
    <p>Kết quả: ${result}</p>
</c:if>

</body>
</html>
