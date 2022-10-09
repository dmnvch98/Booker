<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="../view/styles/sign-in.css" rel="stylesheet">
    <title>Sign in</title>
</head>
<body>
<div class="sign-in">
    <h1 class="text-center">Sign in</h1>
    <form action="/signin" method="post">
        <div>
            <label class="form-label" for="username">Username</label>
            <input class="form-control" type="text" id="username" required name="username">
        </div>
        <div>
            <label class="form-label" for="password">Password</label>
            <input class="form-control" type="password" id="password" required name="password">
        </div>
        <div class="btns">
            <a href="/signup" class="btn btn-outline-primary sign-in-btn">
                SIGN UP
            </a>
            <input type="submit" class="btn btn-primary sign-up-btn" value="SIGN IN">
        </div>
    </form>
</div>

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
