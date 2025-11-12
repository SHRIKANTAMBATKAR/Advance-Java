package shrikant;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
   
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {
            String user = (String) session.getAttribute("username");
            out.println("<h2>Welcome, " + user + "</h2>");
            out.println("<p>This is your profile page.</p>");
            out.println("<a href='LogoutServlet'>Logout</a>");
        } else {
            out.println("<h3>You must login first.</h3>");
            request.getRequestDispatcher("/login.html").include(request, response);
        }
    }
}
