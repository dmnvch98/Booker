<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Guru Registration Form</title>
</head>
<body>
<h1>Guru Register Form</h1>
<form action="signup" method="post">
    <table style="with: 50%">
        <tr>
            <td>name</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>username</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td>phone</td>
            <td><input type="text" name="phone"/></td>
        </tr>
    </table>
    <input type="submit" value="Submit"/></form>
</body>
</html>