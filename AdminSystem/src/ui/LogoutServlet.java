package ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SessionManager;
import service.impl.SessionManagerImpl;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SessionManager sm = new SessionManagerImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sm.endSession(request);
		response.sendRedirect("login.jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
