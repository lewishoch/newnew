package ui.dish;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ui.common.SessionLogin;

/**
 * Servlet implementation class TrashDishServlet
 */
public class InsertDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession(false);
		
		if(SessionLogin.sessionLogin(sen)){
		
			long merchantId = Long.parseLong(request.getParameter("mid"));
			request.setAttribute("mid", merchantId);
			request.getRequestDispatcher("addDishForm.jsp").forward(request, response);
			
		}
		else
			response.sendRedirect("logout");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
