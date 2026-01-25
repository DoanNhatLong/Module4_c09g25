<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 1/23/2026
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input</title>
</head>
<body>
<form method="get" action="/home/calc" >
    <input type="number" name="money" placeholder="Nhập số tiền (USD)">
    <button> Chuyển đổi</button>
</form>
<p> ${result} VND </p>
</body>
</html>
