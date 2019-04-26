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
    <style><%@include file="/WEB-INF/views/style/deleteMilestone_style.css"%></style>
    <style><%@include file="/WEB-INF/views/style/editMilestone.css"%></style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <%--<script><%@include file="/WEB-INF/views/style/addMilestone.js"%></script>--%>
    <%--<script src="${pageContext.request.contextPath}/WEB-INF/views/style.addMilestone.js"></script>--%>

</head>

<body>
<%-------------------------------------------------%>
<%--TODO: Add a menu bar--%>
<%--TODO: Add a footer--%>
<%--TODO: Add hover effects where necessary--%>
<%-------------------------------------------------%>

<%--<div class="container">--%>
    <div class="row menu-bar">
        <div class="col-6">
            <img src="images/MP.png">
        </div>
        <form class="col-6 menu-logout" action ="webApp.logout.do" method="post">
            <button>Logout</button>
        </form>
    </div>

<%--</div>--%>


<div class="dashboard">
    <h1>Project: <span>E-Learning Website</span></h1>



    <div class="container">
        <div class="row">
            <c:forEach items="${milestoneList}" var="milestone">
                <div class="col-md-6">
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

                                <a class="icon_button" id="delete_icon" href="/webApp.deleteMilestone.do?name=${milestone.name}&project=${milestone.project}&description=${milestone.description}&dueDate=${milestone.dueDate}">
                                    <i class="fas fa-trash-alt card_icon"></i>
                                </a>

                                <%--<a class="icon_button" id="delete_icon" href="/webApp.listMilestone.do?name=${milestone.name}&project=${milestone.project}&description=${milestone.description}&dueDate=${milestone.dueDate}">--%>
                                    <%--<i class="fas fa-pencil-alt card_icon"></i>--%>
                                <%--</a>--%>

                                <%--onclick="/webApp.listMilestone.do"--%>

                                <button id="editMilestone_button" class="editMilestone_button" ><i class="fas fa-pencil-alt card_icon"></i></button>
                                <%--<i class="fas fa-pencil-alt card_icon"></i>--%>
                                <i class="fas fa-share-alt card_icon"></i>
                            </div>
                        </div>
                    </div>
                </div>

                <%--EDIT MILESTONE MODAL--%>
                <div id="modal_editMilestoneBlock" class="modal_editMilestoneBlock">
                        <%--Modal Content--%>
                    <div class="editMilestone_content">
                        <span class="close_editMilestone">&times;</span>
                        <h1>Edit:</h1>
                        <div class="container">
                            <div class="row">
                                <div class="col">
                                    <form action="webApp.addMilestone.do" method="post">
                                        <fieldset>
                                            <label>Name:</label><br>
                                            <input class="form_input" type="text" name="milestoneName" value="${milestone.name}" required/><br> <br>
                                        </fieldset>

                                        <fieldset>
                                            <label>Project: </label><br>
                                            <input class="form_input" type="text" name="project" value="${milestone.project}" required/> <br> <br>
                                        </fieldset>

                                        <fieldset>
                                            <label>Description: </label><br>
                                            <input class="form_input" type="text" name="description" value="${milestone.description}" required/> <br> <br>
                                                <%--<p> Fetched description: ${milestone.description}</p>--%>
                                                <%--<p id="content">Ajax data here: </p><br>--%>
                                        </fieldset>

                                        <fieldset>
                                            <label>Due Date: </label><br>
                                            <input class="form_input" type="date" name="dueDate" value="${milestone.dueDate}" required/> <br> <br>
                                        </fieldset>

                                        <button><input class="form_input" type="submit" value="Save Changes"></button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%--EDIT MODAL ENDS HERE--%>

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
            <button id="addMilestone_button"><i class="fas fa-plus-circle"></i></button>
        </div>
    </div>
</div>


<%--Referenced code for this modal was gotten from w3 schools.--%>
<%--ADD MILESTONE MODAL--%>
<div id="modal_addMilestoneBlock" class="modal_addMilestoneBlock">

    <%--Modal Content--%>
    <div class="addMilestone_content">
        <span class="close_addMilestone">&times;</span>

        <h1>Add new milestone:</h1>

        <div class="container">
            <div class="row">
                <div class="col">
                    <form action="webApp.addMilestone.do" method="post">
                        <fieldset>
                            <label>Name:</label><br>
                            <input class="form_input" type="text" name="milestoneName" required/><br> <br>
                        </fieldset>

                        <fieldset>
                            <label>Project: </label><br>
                            <input class="form_input" type="text" name="project" required/> <br> <br>
                        </fieldset>

                        <fieldset>
                            <label>Description: </label><br>
                            <input class="form_input" type="text" name="description" required/> <br> <br>
                        </fieldset>

                        <fieldset>
                            <label>Due Date: </label><br>
                            <input class="form_input" type="date" name="dueDate" required/> <br> <br>
                        </fieldset>

                        <button><input class="form_input" type="submit" value="Add"></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%--<div id="modal_deleteMilestone" class="modal_deleteMilestone">--%>
<%--&lt;%&ndash;Modal Content&ndash;%&gt;--%>
<%--<div class="deleteMilestone_content">--%>
<%--<span class="close_delete">&times;</span>--%>

<%--<h1>Delete milestone:</h1>--%>

<%--<div class="container">--%>
<%--<div class="row">--%>
<%--<div class="col">--%>
<%--<p>Are you sure you want to delete this milestone? This action cannot be undone.</p>--%>
<%--<a class="icon_button" id="delete_icon" href="/webApp.deleteMilestone.do?name=${milestone.name}&project=${milestone.project}&description=${milestone.description}&dueDate=${milestone.dueDate}"></a>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>





<script src="javascript/addMilestone.js"></script>
<script src="javascript/editMilestone.js"></script>
<%--<script src="javascript/editMilestone.js"></script>--%>


</body>
</html>
