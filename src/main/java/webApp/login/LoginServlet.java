package webApp.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@WebServlet(urlPatterns="/webApp.login.do")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    //Create an instance of the user validation class
    private LoginService service = new LoginService();

<<<<<<< HEAD:src/main/java/login/LoginServlet.java
    //Create an instance of the user authentication class
    PasswordHash passwordHash = new PasswordHash();

    //Handles redirection to the login page
=======
    //Handles redirection to the webApp.login page
>>>>>>> ec3b2b8aafd1f0f9a46837a6d897be97ccd0e312:src/main/java/webApp/login/LoginServlet.java
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
            String storedPassword = passwordHash.createHash(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }

        boolean isUserValid = service.isUserValid(name, password);

        if(isUserValid) {
            request.getSession().setAttribute("name",name);
            response.sendRedirect("/webApp.listMilestone.do");
        }
        else{
            request.setAttribute("errorMessage", "Invalid Credentials!!");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }

    }
}
