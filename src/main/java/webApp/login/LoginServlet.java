package webApp.login;

import webApp.db.PasswordDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;

@WebServlet(urlPatterns="/webApp.login.do")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    //Create an instance of the user authentication class
    PasswordHash passwordHash = new PasswordHash();

    private PasswordDB authenticate = new PasswordDB();
    //Handles redirection to the login page

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    //Handles webApp.login validation and redirects to projects dashboard
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        try {
            passwordHash.validatePassword(password, authenticate.confirmUser(new LoginService(name)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/webApp.listMilestone.do");

    }
}
