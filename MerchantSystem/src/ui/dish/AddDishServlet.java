package ui.dish;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.Dish;
import service.DishManager;
import service.impl.DishManagerImpl;
import ui.common.SessionLogin;

/**
 * Servlet implementation class AddDishServlet
 */
public class AddDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DishManager dm = new DishManagerImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession(false);
		
		if(sen!=null && SessionLogin.sessionLogin(sen)){

			long mid = Long.parseLong(request.getParameter("mid"));
			String dname = request.getParameter("dname");
			String dpath = request.getParameter("dpath");
			
			Dish d = new Dish();
			d.setMerchantUuid(mid);
			d.setDishName(dname);
			d.setDishFolderPath(dpath);
			
			dm.addDish(d);
			response.sendRedirect("control");
		}
		else
			response.sendRedirect("logout");
	}

}
