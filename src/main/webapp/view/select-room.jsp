<%@ page import="java.time.LocalDate" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Booking Management</title>
    <style><%@include file="styles/select-room-style.css"%></style>
</head>
<body>
<%@ include file="header.jsp" %>
<div style="text-align: center;">
    <table >
        <caption><h2>List of available rooms</h2></caption>
        <tr>
            <th>id</th>
            <th>Room number</th>
            <th>Capacity</th>
            <th>Type</th>
            <th>Floor</th>
        </tr>
        <c:forEach var="room" items="${rooms}">
            <tr>
                <td><c:out value="${room.id}" /></td>
                <td><c:out value="${room.number}" /></td>
                <td><c:out value="${room.capacity}" /></td>
                <td><c:out value="${room.type}" /></td>
                <td><c:out value="${room.floor}" /></td>
                <td>
                    <a href="/add-booking?id=<c:out value='${room.id}' />">Select</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
