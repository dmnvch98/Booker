<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Signup</title>
    <link href="styles/signup-style.css" rel="stylesheet" type="text/css">
</head>
<body>
<style>
    <%@include file="styles/signin-style.css" %>
</style>
<form method="post" action="/signup">
    <div class="box">
        <h1>Signup</h1>
        <input type="username" name="username" placeholder="username" class="username"/>
        <input type="password" name="password" placeholder="password" class="password"/>
        <div class="roles">
            <input type="radio" name="role" value="ADMIN" checked="checked"/>admin
            <input type="radio" name="role" value="USER" >user
        </div>
        <input type="submit" value="Submit" class="btn signup-btn"/>
        <a href="/signin"><div id="btn2">Sign In</div></a>
    </div>
</form>
<%--<form action="signup" method="post">--%>
<%--    <table style="with: 50%">--%>
<%--        <tr>--%>
<%--            <td>name</td>--%>
<%--            <td><input class="input-text" type="text" name="name"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>username</td>--%>
<%--            <td><input class="input-text" type="text" name="username"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>password</td>--%>
<%--            <td><input class="input-text" type="password" name="password"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>phone</td>--%>
<%--            <td><input class="input-text" type="text" name="phone"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>role</td>--%>
<%--            <td><input type="radio" name="role" value="ADMIN" checked="checked"/>admin</td>--%>
<%--            <td><input type="radio" name="role" value="USER" />user</td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--    <input type="submit" value="Submit"/>--%>
<%--</form>--%>
</body>
</html>