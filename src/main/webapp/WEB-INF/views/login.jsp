<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MileStone Planner Login Page</title>
    <link href="https://fonts.googleapis.com/css?family=Raleway:400,500,600,700" rel="stylesheet">
    <style><%@include file="/WEB-INF/views/style/login_style.css"%></style>
    <style><%@include file="/WEB-INF/views/style/style.css"%></style>
</head>
<body>

<div class="login_text">
    <h1>Welcome To Your Milestone Planner App!</h1>

    <p>Login or Sign Up to Get Started.</p>
</div>

<!--Create webApp.login form for user-->

<div class="login_card">
    <form action="/webApp.login.do" method="post">

        <div class="form_input">
            Name:<br> <input type="text" name="name"/>
        </div>

        <div class="form_input">
            Password:<br> <input type="password" name="password"/>
        </div>

        <div class="form_input" id="form_button">
            <button><input type="submit" value="Login"/></button>
        </div>

    </form>
</div>

</body>
</html>
