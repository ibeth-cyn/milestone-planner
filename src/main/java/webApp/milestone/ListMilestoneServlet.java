package webApp.milestone;

import webApp.db.MilestoneDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//adding URL
@WebServlet(urlPatterns="/webApp.listMilestone.do")

public class ListMilestoneServlet extends HttpServlet {

    private MilestoneDB milestones = new MilestoneDB();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("milestoneList", milestones.getMilestones());
        request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(request,response);

    }

}
