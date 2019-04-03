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

    <style>

        @import url('https://fonts.googleapis.com/css?family=Quicksand');
        *{
            font-family: "Quicksand", sans-serif;
        }
        th, td{
            width: 200px;
            padding:10px;
        }

        th{
            text-align: left;
            background: #464646;
            color: #fff;
        }

        td{
            background: mintcream;
        }
    </style>
</head>
<body>

<div >
    <%--<p>Welcome, ${name}</p>--%>
    <h1>Your milestones:</h1>

    <table>
        <thead>
        <th>Milestone</th>
        <th>Project</th>
        <th>Description</th>
        <th>Due Date</th>
        <%--<th>Completion Date</th>--%>
        <th>Actions</th>
        </thead>
        <tbody>
        <c:forEach items="${milestoneList}" var="milestone">
            <tr>
                <td>${milestone.name}</td>
                <td>${milestone.project} </td>
                <td>${milestone.description} </td>
                <td>${milestone.dueDate} </td>
                <td>
                    <a href="/webApp.deleteMilestone.do?milestoneName=${milestone.name}&project=${milestone.project}&description=${milestone.description}&dueDate=${milestone.dueDate}">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <ul>
        <li><a href="/webApp.addMilestone.do">Add Milestone</a></li>
    </ul>
</div>

</body>
</html>
