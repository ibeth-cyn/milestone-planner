<%--
  Created by IntelliJ IDEA.
  User: Fatuma Ingabire
  Date: 31-Mar-19
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html"; charset="UTF-8">
    <title>List Milestone</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <style><%@include file="/WEB-INF/views/style/style.css"%></style>
    <style><%@include file="/WEB-INF/views/style/dashboard_style.css"%></style>
    <style><%@include file="/WEB-INF/views/style/addMilestone_style.css"%></style>
    <%--<script><%@include file="/WEB-INF/views/style/addMilestone.js"%></script>--%>
    <%--<script src="${pageContext.request.contextPath}/WEB-INF/views/style.addMilestone.js"></script>--%>

</head>

<body>
<%-------------------------------------------------%>
<%--TODO: Add a menu bar--%>
<%--TODO: Add a footer--%>
<%--TODO: Add hover effects where necessary--%>
<%-------------------------------------------------%>

<div class="dashboard">
    <h1>Project: <span>E-Learning Website</span></h1>



    <div class="container">
        <div class="row">
            <c:forEach items="${milestoneList}" var="milestone">
            <div class="col-6">
                <div class="mcard">
                    <h3>${milestone.name}</h3>

                    <div class="row">
                        <div class="col-6">
                            <h4>Project: <span>${milestone.project}</span></h4>
                        </div>

                        <div class="col-6 mdue_date">
                            <p>Due: ${milestone.dueDate}</p>
                        </div>
                    </div>

                    <p>${milestone.description}</p>

                    <div class="row">
                        <div class="col card_icons">

                            <a class="icon_button" href="/webApp.deleteMilestone.do?milestoneName=${milestone.name}&project=${milestone.project}&description=${milestone.description}&dueDate=${milestone.dueDate}">
                            <i class="fas fa-trash-alt card_icon"></i>
                            </a>
                            <i class="fas fa-pencil-alt card_icon"></i>
                            <i class="fas fa-share-alt card_icon"></i>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>


<div class="row">
    <div class="col-11">

    </div>
    <div class="col-1">
        <div class="add_milestone">
            <%--<a href="/webApp.addMilestone.do"><i class="fas fa-plus-circle"></i></a>--%>
            <button id="modal_button"><i class="fas fa-plus-circle"></i></button>
        </div>
    </div>
</div>


<%--Referenced code for this modal was gotten from w3 schools.--%>
<%--The Modal--%>
<div id="modal_addMilestone" class="modal_class">

    <%--Modal Content--%>
    <div class="modal_content">
        <span class="close">&times;</span>

            <h1>Add new milestone:</h1>

            <div class="container">
                <div class="row">
                    <div class="col">
                        <form action="webApp.addMilestone.do" method="post">
                            <fieldset>
                                <label>Name:</label><br>
                                <input class="form_input" type="text" name="milestoneName"/><br> <br>
                            </fieldset>

                            <fieldset>
                                <label>Project: </label><br>
                                <input class="form_input" type="text" name="project"/> <br> <br>
                            </fieldset>

                            <fieldset>
                                <label>Description: </label><br>
                                <input class="form_input" type="text" name="description"/> <br> <br>
                            </fieldset>

                            <fieldset>
                                <label>Due Date: </label><br>
                                <input class="form_input" type="date" name="dueDate"/> <br> <br>
                            </fieldset>

                            <button><input class="form_input" type="submit" value="Add"></button>
                        </form>
                    </div>
                </div>
            </div>



    </div>

</div>
<script src="javascript/addMilestone.js"></script>

</body>
</html>
