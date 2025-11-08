package FirstJAVa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Firstservlet")
public class Firstservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Set response type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get parameters from form
        String username = request.getParameter("user");
        String password = request.getParameter("upass");

        // Simple login validation
        if ("admin".equals(username) && "1234".equals(password)) {
            // Create session
            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            out.println("<html><body>");
            out.println("<h2>Welcome, " + username + "!</h2>");
            out.println("<a href='ProfileServlet'>Go to Profile</a><br>");
            out.println("<a href='LogoutServlet'>Logout</a>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<h3 style='color:red;'>Invalid Username or Password!</h3>");
            out.println("<a href='index.html'>Try Again</a>");
            out.println("</body></html>");
        }
    }
}
