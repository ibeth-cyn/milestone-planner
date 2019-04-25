package webApp.milestone;

import webApp.db.MilestoneDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns="/webApp.deleteMilestone.do")

public class DeleteMilestoneServlet extends HttpServlet {

    private MilestoneDB milestones = new MilestoneDB();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        String name = request.getParameter("name");
        String project = request.getParameter("project");
        String description = request.getParameter("description");
        String dueDate = request.getParameter("duedate");
        //String[] completeArray = request.getParameterValues("complete");
        //String complete = completeArray[0];
        String complete = "false";

        milestones.deleteMilestone(new Milestone(name, project, description,dueDate,complete));

        response.sendRedirect("/webApp.listMilestone.do");
    }
}
