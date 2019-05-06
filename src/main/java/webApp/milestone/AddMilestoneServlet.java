package webApp.milestone;

import webApp.db.MilestoneDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns="/webApp.addMilestone.do")

public class AddMilestoneServlet extends HttpServlet {

    private MilestoneDB milestones = new MilestoneDB();

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("milestoneName");
        String project = request.getParameter("project");
        String description = request.getParameter("description");
        String dueDate = request.getParameter("dueDate");
        String complete = request.getParameter("complete");

        milestones.addMilestone(new Milestone(name, project, description, dueDate, complete));
        response.sendRedirect("/webApp.listMilestone.do");
    }
}
