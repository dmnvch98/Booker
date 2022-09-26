<%@ page import="model.Room" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="add-booking">
    <%
        List<Room> rooms = (List<Room>) request.getAttribute("rooms");
        PrintWriter printWriter = response.getWriter();
        for (Room room : rooms) {
            printWriter.println(room);
            request.getSession().setAttribute("room", room);
        }
    %>
    <label for="start_date">Start date</label>
    <input type="date" id="start_date" name="start_date">

    <label for="end_date">End date</label>
    <input type="date" id="end_date" name="end_date">

    <input type="submit" value="Add Booking">
</form>
</body>
</html>
