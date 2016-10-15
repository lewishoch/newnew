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
		
		if(sen!=null){
			long mid = Long.parseLong(request.getParameter("mid"));
			long did = Long.parseLong(request.getParameter("did"));
			String dname = request.getParameter("dname");
			String dpath = request.getParameter("dpath");
			
			Dish d = new Dish();
			d.setMerchantUuid(mid);
			d.setDishId(did);
			d.setDishName(dname);
			d.setDishFolderPath(dpath);
			
			dm.updateDish(d);
		}
		else
			response.sendRedirect("index.jsp");
	}

}
