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
<p>Log in to View Your Milestones.</p>
    <!--We can have the paragraphs below appear after a user logs in. How do we figure that out? Debbie?-->
    <!--p>Registration Successful!</p>
    <p>Log in to view your Milestones</p-->
</div>

<!--Create webApp.login form for user-->
<div class="login_card">
    <form action="/webApp.login.do" method="post">

        <div class="form_input">
            <p>${invalidLoginError}</p><br>
            Name:<br> <input type="text" name="name" maxlength="30"/>
        </div>

        <div class="form_input">
            Password:<br> <input type="password" name="password" title="Password must be atleast 8 or more characters including 1 uppercase letter, 1 lowercase letter and numeric characters" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"/>
        </div>

        <div class="form_input" id="form_button">
            <button><input type="submit" value="Login"/></button>
        </div>
        <div class = "form_input">
            <p>Do not have an account? <a href="/webApp.register.do"> SignUp here</a></p>
        </div>

    </form>
</div>

</body>
</html>
