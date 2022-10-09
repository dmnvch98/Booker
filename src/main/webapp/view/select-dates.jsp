<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%--<%String roomId =  request.getParameter("id");--%>
<%--    request.getSession().setAttribute("roomId", roomId);%>--%>
<body>
<%@ include file="header.jsp" %>
<form action="available-rooms" method="post">
    <label for="start">Start date:</label>

    <input type="date" id="start" name="start_date">
    <label for="start">End date:</label>

    <input type="date" id="end" name="end_date">

    <input type="submit" value="View Available Rooms">
</form>
</body>
</html
