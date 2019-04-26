package webApp.milestone;

import webApp.db.MilestoneDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/webApp.updateMilestone.do")

public class UpdateMilestoneServlet extends HttpServlet {

    private MilestoneDB milestones = new MilestoneDB();

    @Override
    //posting new user information on web page
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String stringId = request.getParameter("id");
        int id  = Integer.parseInt(stringId);
        String name = request.getParameter("milestoneName");
        String project = request.getParameter("project");
        String description = request.getParameter("description");
        String dueDate = request.getParameter("dueDate");
        //String[] completeArray = request.getParameterValues("complete");
        String complete = "true";

        milestones.updateMilestone(new Milestone(name, project, description, dueDate, complete), id);

        response.sendRedirect("/webApp.listMilestone.do");
    }


}
