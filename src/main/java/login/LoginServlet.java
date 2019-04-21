package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@WebServlet(urlPatterns="/login.do")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    //Create an instance of the user validation class
    private LoginService service = new LoginService();

    //Create an instance of the user authentication class
    PasswordHash passwordHash = new PasswordHash();

    //Handles redirection to the login page
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    //Handles login validation and redirects to projects dashboard
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        try {
            String storedPassword = passwordHash.createHash(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        boolean isUserValid = service.isUserValid(name, password);

        if(isUserValid) {
            request.getSession().setAttribute("name",name);
            response.sendRedirect("/dashboard.do");
        }
        else{
            request.setAttribute("errorMessage", "Invalid Credentials!!");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }

    }
}
