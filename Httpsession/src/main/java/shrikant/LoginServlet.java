package shrikant;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
  
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if (user.equals("shrikant") && pass.equals("1234")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", user);
            response.sendRedirect("Home.html");

        } else {
            out.println("<h3>Invalid username or password</h3>");
            request.getRequestDispatcher("/login.html").include(request, response);
        }
    }
}
