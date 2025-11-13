package shrikant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response .getWriter();
		response.setContentType("text/html");
		out.println("the name of user is "+request.getParameter("uname"));
	
	    out.println("<form action='ThirdServlet' method='post'>");
	    out.println("<input type = 'hidden' name ='Company' value ='"+"kapilSkillHub"+"'>");
	    out.println("<input type ='submit'  value='forward'>");
	    out.println("<input type ='submit'  value='Back'>");

	    
	    out.println("</form>");

		}

}
