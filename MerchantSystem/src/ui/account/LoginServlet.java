package ui.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession(true);
		String uname = (String)request.getParameter("uname");
		String password = (String)request.getParameter("password");
		
		// check if valid
		if(true){
			sen.setAttribute("uname", uname);
			sen.setAttribute("password", password);
			request.getRequestDispatcher("control.jsp").forward(request,response);
		}
		else{
			// else
			
		}
	}

}
