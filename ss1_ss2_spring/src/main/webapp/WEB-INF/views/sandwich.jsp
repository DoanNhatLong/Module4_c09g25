<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Sand</title>
</head>
<body>
<form:form action="/home/sandwich" method="get" modelAttribute="sandwichDto">
  <form:checkbox path="condiment" value="lettuce"/> Pepper<br>
  <form:checkbox path="condiment" value="tomato"/> Tomato<br>
  <form:checkbox path="condiment" value="cheese"/> Cheese<br>
  <button>Submit</button>
</form:form>

<c:if test="${not empty result}">
  <p>Đã chọn:</p>
  <c:forEach items="${result}" var="item">
    <p>${item}</p>
  </c:forEach>
</c:if>

</body>
</html>
