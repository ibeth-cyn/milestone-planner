package webApp.register;

import webApp.db.MilestoneDB;
import webApp.login.PasswordHash;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@WebServlet(urlPatterns = "/webApp.register.do")
public class RegisterServlet extends HttpServlet {

    private MilestoneDB validate = new MilestoneDB();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
    }

    //Handles webApp.login validation and redirects to projects dashboard
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String name = request.getParameter("name");
            String password = request.getParameter("password");
        try {
            String hash = PasswordHash.createHash(password);
            validate.addHashedPasswords(new RegisterService(name, hash));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/webApp.login.do");
    }
}
