<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Guru Success Page</title>
    <link href="styles/welcome-style.css" rel="stylesheet" type="text/css">
    <style><%@include file="styles/welcome-style.css"%></style>
</head>
<header>
    <div class="header">
        <a href="#default" class="logo">CompanyLogo</a>
        <div class="header-right">
            <p><%=request.getSession().getAttribute("username")%>
            <a href="#about">Logout</a>
            <form action="/logout">
                <input type="submit" value="Logout" class="btn" />
            </form>
        </div>
    </div>
</header>

<%--<div class="header">--%>
<%--    <p><%=request.getSession().getAttribute("username")%></p>--%>
<%--    <form action="/logout">--%>
<%--        <input type="submit" value="Logout" class="btn" />--%>
<%--    </form>--%>
<%--</div>--%>
<main>
    <div>
        <form action="/add-booking">
            <input type="submit" value="Add Booking" class="btn btn-big"/>
        </form>
    </div>
</main>
<footer></footer>
</html>
