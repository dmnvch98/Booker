<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="styles/select-room-style.css" %>
    </style>
</head>
<body>
<%@ include file="header.jsp" %>
<div>
    <table>
        <caption><h2>List of my bookings</h2></caption>
        <tr>
            <th>User</th>
            <th>Start date</th>
            <th>End date</th>
            <th>Room</th>
        </tr>
        <c:forEach var="booking" items="${bookings}">
            <tr>
                <td><c:out value="${booking.user}"/></td>
                <td><c:out value="${booking.startDate}"/></td>
                <td><c:out value="${booking.endDate}"/></td>
                <td><c:out value="${booking.room}"/></td>
                <td>
                    <a href="${pageContext.request.contextPath}/manage-bookings?booking-id=<c:out value='${booking.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
