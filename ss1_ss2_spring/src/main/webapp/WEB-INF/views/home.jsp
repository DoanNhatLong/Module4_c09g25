<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 1/23/2026
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <c:import url="library.jsp"/>
</head>
<body>
<div class="container d-flex flex-column gap-3">
    <a href="/home/calc"> Chuyển đổi tiền tệ</a>
    <a href="/home/trans"> Từ điển</a>
    <a href="/home/sandwich"> Sandwich</a>
    <a href="/home/computer"> Máy tính</a>
    <a href="/home/email"> Email</a>
</div>

</body>
</html>
