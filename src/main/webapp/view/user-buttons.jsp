<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="styles/homepage-buttons-style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="btns">
    <div class="btn">
        <form action="/select-dates.jsp">
            <input type="submit" value="Add Booking" class="btn" id="btn1"/>
        </form>
    </div>
    <div class="btn">
        <form action="/user-bookings">
            <input type="submit" value="View My Bookings" class="btn" id="btn2"/>
        </form>
    </div>
</div>
</body>
</html>
