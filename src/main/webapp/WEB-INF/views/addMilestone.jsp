<%--
  Created by IntelliJ IDEA.
  User: Fatuma Ingabire
  Date: 31-Mar-19
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html"; charset="UTF-8">
    <title>Add Milestone</title>
    <style><%@include file="/WEB-INF/views/style/style.css"%></style>
    <style><%@include file="/WEB-INF/views/style/addMilestone_style.css"%></style>

</head>
<body>

<div>
    <h1>Add new milestone:</h1>

    <form action="webApp.addMilestone.do" method="post">
        <fieldset>
            <label>Name:</label>
            <input type="text" name="milestoneName"/><br> <br>
        </fieldset>

        <fieldset>
            <label>Project: </label>
            <input type="text" name="project"/> <br> <br>
        </fieldset>

        <fieldset>
            <label>Description: </label>
            <input type="text" name="description"/> <br> <br>
        </fieldset>

        <fieldset>
            <label>Due Date: </label>
            <input type="date" name="dueDate"/> <br> <br>
        </fieldset>

        <input type="submit" value="Add">
    </form>
</div>

</body>
</html>
