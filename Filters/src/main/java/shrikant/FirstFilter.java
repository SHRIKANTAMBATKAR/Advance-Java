package shrikant;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.io.PrintWriter;


@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/SecondFilter" })
public class FirstFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FirstFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String uname = request.getParameter("user");
        String pass = request.getParameter("pass");

        if (uname.equals("shrikant") && pass.equals("1234")) {
            chain.doFilter(request, response); // pass request to servlet
        } else {
            out.println("<h3>Invalid username or password</h3>");
            request.getRequestDispatcher("Login.html").include(request, response);
        }
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("LogFilter initialized");
	}

}
