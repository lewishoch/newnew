package ui.dish;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.DishManager;
import service.impl.DishManagerImpl;

/**
 * Servlet implementation class AddDishServlet
 */
public class AddDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DishManager dm = new DishManagerImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession(false);
		
		if(sen!=null){
			int mid = Integer.parseInt(request.getParameter("mid"));
			String dname = (String)request.getParameter("dname");
			
			
			long merchantUuid;
			long dishId;
			String dishName;
			String dishFolderPath;
			Date createdDtGmt;
			Date lastModifiedDtGmt;
		}
		else
			response.sendRedirect("index.jsp");
	}

}
