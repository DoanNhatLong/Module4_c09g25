<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 1/23/2026
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trans</title>
</head>
<body>

<form method="get" action="/home/trans" >
    <input type="text" name="word" placeholder="Nhập tiếng anh">
    <button> Dịch sang tiếng việt</button>
</form>

<p> ${result} </p>

</body>
</html>
