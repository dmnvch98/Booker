<%@ page import="model.Room" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Room> rooms = (List<Room>) request.getAttribute("rooms");
    PrintWriter printWriter = response.getWriter();
    for (Room room: rooms) {
        printWriter.println(room);
    }
%>
</body>
</html>
