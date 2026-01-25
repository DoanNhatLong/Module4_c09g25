<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 1/25/2026
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email</title>
  <c:import url="library.jsp"/>
</head>
<body>
<form:form action="/home/email" modelAttribute="email">
  <select name="language">
    <c:forEach items="${sessionScope.language}" var="temp">
      <option value=${temp}>${temp}</option>
    </c:forEach>
  </select>
  <select name="page">
    <option value="5">5</option>
    <option value="10">10</option>
    <option value="15">15</option>
    <option value="20">20</option>
  </select>
  <input type="hidden" name="spam" value="false">
  <input type="checkbox" name="spam" value="true">
  <input type="text" name="desc">
  <button> Gửi</button>
</form:form>

</body>
</html>
