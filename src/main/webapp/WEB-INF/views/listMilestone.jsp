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
    <style><%@include file="/WEB-INF/views/style/listMilestone_style.css"%></style>
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
            <a href="/webApp.addMilestone.do"><i class="fas fa-plus-circle"></i></a>
        </div>
    </div>
</div>

</body>
</html>
