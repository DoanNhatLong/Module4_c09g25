<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 1/22/2026
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:import url="/WEB-INF/views/library.jsp"/>
</head>
<body>
${mess}
Student
${studentList[0].name}
<form class="container" action="/student/save" method="get">
    <input type="checkbox" name="class" value="1"> Lớp A
    <input type="checkbox" name="class" value="2"> Lớp B
    <input type="checkbox" name="class" value="3"> Lớp C
    <input type="checkbox" name="class" value="4"> Lớp D

<button> Save </button>
</form>


</body>
</html>
