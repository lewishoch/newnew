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
import util.UploadImage;

public class DeleteDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final DishManager dm = new DishManagerImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession(false);
		
		if(SessionLogin.sessionLogin(sen)){
			
			long did = Long.parseLong(request.getParameter("dishId"));

			Dish d = dm.loadDish(did);
			String path = d.getDishFolderPath();
			
			UploadImage.deleteImage(this.getServletContext().getRealPath(path));
			

			if(dm.deleteDish(did)){
				request.setAttribute("msgType", "succMsg");
				request.setAttribute("msg", "Record has been removed.");
			}
			else{
				request.setAttribute("msgType", "errorMsg");
				request.setAttribute("msg", "Failed to remove the record.");
			}

			request.getRequestDispatcher("control").forward(request, response);
		}
		else
			response.sendRedirect("logout");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
