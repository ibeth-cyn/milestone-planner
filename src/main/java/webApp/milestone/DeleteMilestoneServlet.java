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
        milestones.deleteMilestone(new Milestone(request.getParameter("name"), request.getParameter("project"),
                request.getParameter("description"), request.getParameter("dueDate")));

        response.sendRedirect("/webApp.listMilestone.do");
    }
}
