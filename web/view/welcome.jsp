<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Guru Success Page</title>
    <link href="styles/welcome-style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="greeting">
    <h3><%= "Hello " + request.getSession().getAttribute("username")%>
    </h3>
    <p><%= "Role: " + request.getSession().getAttribute("role")%>
    </p>
</div>
<div>
    <form action="/logout">
        <input type="submit" value="Logout" />
    </form>
</div>
</body>
</html>
