package ui.dish;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.DishManager;
import service.impl.DishManagerImpl;
import ui.common.SessionLogin;

public class DeleteDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final DishManager dm = new DishManagerImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession(false);
		
		if(sen!=null && SessionLogin.sessionLogin(sen)){
			int did = Integer.parseInt(request.getParameter("did"));
			dm.deleteDish(did);
			response.sendRedirect("control");
		}
		else
			response.sendRedirect("logout");
	}

}
