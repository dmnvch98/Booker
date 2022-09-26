<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: ydzemyanovich
  Date: 9/26/2022
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%String roomId =  request.getParameter("id");
    request.getSession().setAttribute("roomId", roomId);%>
<body>
    <form action="add-booking" method="post">
        <label for="start">Start date:</label>

        <input type="date" id="start" name="start_date">
        <label for="start">End date:</label>

        <input type="date" id="end" name="end_date">

        <input type="submit" value="Add Booking">

    </form>
</body>
</html>
