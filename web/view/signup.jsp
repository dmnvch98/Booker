<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Guru Registration Form</title>
    <link href="styles/signup-style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1>Sign up form</h1>
<form action="signup" method="post">
    <table style="with: 50%">
        <tr>
            <td>name</td>
            <td><input class="input-text" type="text" name="name"/></td>
        </tr>
        <tr>
            <td>username</td>
            <td><input class="input-text" type="text" name="username"/></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input class="input-text" type="password" name="password"/></td>
        </tr>
        <tr>
            <td>phone</td>
            <td><input class="input-text" type="text" name="phone"/></td>
        </tr>
        <tr>
            <td>role</td>
            <td><input type="radio" name="role" value="ADMIN" checked="checked"/>admin</td>
            <td><input type="radio" name="role" value="USER" />user</td>
        </tr>
    </table>
    <input type="submit" value="Submit"/></form>
</body>
</html>