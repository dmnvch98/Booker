<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>
    <title>Booking Management</title>
    <style><%@include file="styles/select-room-style.css"%></style>
</head>
<body>
<div style="text-align: center;">
    <h1>Booking Management</h1>
</div>
<div style="text-align: center;">
    <table >
        <caption><h2>List of Rooms</h2></caption>
        <tr>
            <th>Room number</th>
            <th>Capacity</th>
            <th>Type</th>
            <th>Floor</th>
        </tr>
        <c:forEach var="room" items="${rooms}">
            <tr>
                <td><c:out value="${room.number}" /></td>
                <td><c:out value="${room.capacity}" /></td>
                <td><c:out value="${room.type}" /></td>
                <td><c:out value="${room.floor}" /></td>
                <td>
                    <a href="select-dates.jsp?id=<c:out value='${room.id}' />">Select</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
