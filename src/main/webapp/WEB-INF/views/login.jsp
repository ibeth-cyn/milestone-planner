<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MileStone Planner Login Page</title>
</head>
<body>
<!--Create login form for user-->
<form action="/login.do" method="post">
    <p><font color ="red">${ErrorMessage}</font></p>
    Name: <input type="text" name="name"/>  Password: <input type="password" name="password"/>  <input type="submit" value="Login"/>
</form>
</body>
</html>
