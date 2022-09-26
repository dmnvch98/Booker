<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Booking" %>
<%@ page import="java.io.PrintWriter" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="styles/select-room-style.css"%></style>
</head>
<body>
<div style="text-align: center;">
    <table >
        <caption><h2>List of my bookings</h2></caption>
        <tr>
            <th>Start date</th>
            <th>End date</th>
            <th>Room</th>
        </tr>
        <c:forEach var="booking" items="${userBookings}">
            <tr>
                <td><c:out value="${booking.startDate}" /></td>
                <td><c:out value="${booking.endDate}" /></td>
                <td><c:out value="${booking.room}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
