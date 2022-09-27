<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="styles/header-style.css" %>
    </style>
</head>
<body>
<div class="header">
    <a href="/home.jsp" class="logo">Booker</a>
    <div class="header-right">
        <a><%=request.getSession().getAttribute("username")%>
        </a>
        <a class="logout-btn">
            <form action="/logout">
                <input type="submit" value="Logout" id="btn"/>
            </form>
        </a>
    </div>
</div>
</body>
</html>
