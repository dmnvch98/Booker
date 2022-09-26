<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Guru Success Page</title>
    <link href="styles/welcome-style.css" rel="stylesheet" type="text/css">
    <style type= text/css><%@include file="styles/welcome-style.css"%></style>
</head>
<body>
    <div class="header">
        <a href="#default" class="logo">CompanyLogo</a>
        <div class="header-right">
            <a><%=request.getSession().getAttribute("username")%></a>
            <a class="logout-btn">
                <form action="/logout" >
                    <input type="submit" value="Logout"/>
                </form>
            </a>
        </div>
    </div>
    <div>
        <form action="/add-booking">
            <input type="submit" value="Add Booking" class="btn btn-big"/>
        </form>
    </div>
    <div>
        <form action="/user-bookings">
            <input type="submit" value="View My Bookings" class="btn btn-big"/>
        </form>
    </div>
</body>
</html>
