package shrikant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      PrintWriter out = response.getWriter();
       response.setContentType("text/html");
       String username=request.getParameter("user");
       
       out.println("welcome mr"+username);
       out.println("<form action='SecondServlet' method='post'>");
       out.println("<input type = 'hidden' name ='uname' value ='"+username+"'>");
       out.println("<input type ='submit'  value='forward'>");
       out.println("</form>");
	}

}
