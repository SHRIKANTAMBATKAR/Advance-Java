package kapil.it;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // Get the search query from input field
        String query = request.getParameter("query");

        // Encode query for URL (spaces -> +)
        query = java.net.URLEncoder.encode(query, "UTF-8");

        // Redirect to Google search
        response.sendRedirect("https://www.google.com/search?q=" + query);
    }
}
