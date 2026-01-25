<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Yuan
  Date: 1/25/2026
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
    <c:import url="library.jsp"/>
</head>
<body>
Ngôn ngữ : ${email.language}
Page : ${email.page}
<c:choose>
    <c:when test="${email.spam}">
        Có spam
    </c:when>
    <c:otherwise>
        Không spam
    </c:otherwise>
</c:choose>
Desc : ${email.desc}

</body>
</html>
