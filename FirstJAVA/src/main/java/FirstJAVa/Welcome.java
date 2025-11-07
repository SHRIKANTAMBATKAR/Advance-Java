package FirstJAVa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle POST (from form submission)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to GET with query parameters to preserve data
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        response.sendRedirect("Welcome?name=" + name + "&surname=" + surname);
    }

    // Handle GET (show page and refresh functionality)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Welcome Page</title>");
        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css' rel='stylesheet'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container mt-5 text-center'>");

        if (name != null && surname != null) {
            out.println("<h1>Welcome, " + name + " " + surname + "!</h1>");
            out.println("<p>Glad to have you here.</p>");
        } else {
            out.println("<h1>No user data found!</h1>");
            out.println("<p>Please go back and enter your details.</p>");
        }

        // Buttons
        out.println("<form action='Welcome' method='get' class='mt-3'>");
        out.println("<input type='hidden' name='name' value='" + (name != null ? name : "") + "'>");
        out.println("<input type='hidden' name='surname' value='" + (surname != null ? surname : "") + "'>");
        out.println("<button type='submit' class='btn btn-primary me-2'>Refresh</button>");
        out.println("<a href='index.html' class='btn btn-secondary'>Go Back</a>");
        out.println("</form>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
