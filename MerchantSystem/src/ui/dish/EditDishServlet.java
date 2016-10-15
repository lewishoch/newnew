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
 * Servlet implementation class EditDishServlet
 */
public class EditDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final DishManager dm = new DishManagerImpl();

    public EditDishServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession(false);
		
		if(sen!=null && SessionLogin.sessionLogin(sen)){
		
			int dishId = Integer.parseInt(request.getParameter("dishId"));
			Dish d = dm.loadDish(dishId);
			request.setAttribute("d", d);
			request.getRequestDispatcher("updateDishForm.jsp").forward(request, response);
		}
		else
			response.sendRedirect("logout");
	}

}
