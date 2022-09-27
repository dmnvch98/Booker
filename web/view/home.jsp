<%@ page import="model.UserRole" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="styles/homepage-buttons-style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="header.jsp" %>

</body>
</html>

<%
    UserRole role;
    if (request.getSession().getAttribute("role") != null) {
        role = (UserRole) request.getSession().getAttribute("role");
    } else {
        role = UserRole.UNKNOWN;
    }
    request.setAttribute("role", role.toString());
%>
<c:choose>
    <c:when test="${role eq 'ADMIN'}">
        <%@ include file="admin-button.jsp" %>
    </c:when>
    <c:when test="${role eq 'USER'}">
        <%@ include file="user-buttons.jsp" %>
    </c:when>
    <c:otherwise>
        <p>Not authorized</p>
    </c:otherwise>
</c:choose>