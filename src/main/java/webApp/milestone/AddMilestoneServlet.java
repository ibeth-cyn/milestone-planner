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
    //getting user input (milestone) from form
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/addMilestone.jsp").forward(request,response);
    }

    @Override
    //posting new user information on web page
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("milestoneName");
        String project = request.getParameter("project");
        String description = request.getParameter("description");
        String dueDate = request.getParameter("dueDate");

        milestones.addMilestone(new Milestone(name, project, description, dueDate));

        response.sendRedirect("/webApp.listMilestone.do");
    }
}
