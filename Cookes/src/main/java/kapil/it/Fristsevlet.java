package kapil.it;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter; 

@WebServlet("/Firstsevlet")  // Make sure URL matches your form
public class Fristsevlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        request.getRequestDispatcher("/Link.html").include(request, response);

        String uname = request.getParameter("user");
        String password = request.getParameter("upass"); // match HTML name

        if ("Shrikant".equals(uname) && "pass@123".equals(password)) {
            out.println("Welcome to Mr " + uname);

            Cookie ck = new Cookie("username", uname);
            response.addCookie(ck);

        } else {
            out.println("Wrong Credentials");
            request.getRequestDispatcher("/login.html").include(request, response);
        }

        out.close();
    }
}
