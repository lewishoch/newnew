package ui;  	

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;

import po.Dish;
import po.MerchantProfile;
import dao.DishDao;
import dao.MerchantProfileDao;
import dao.impl.DishDaoImpl;
import dao.impl.MerchantProfileDaoImpl;

/**
 * Servlet implementation class ShowMerchantServlet
 */
public class LoadMerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantProfileDao md = new MerchantProfileDaoImpl();
	private DishDao dd = new DishDaoImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String merchantName = request.getParameter("sName");

		long uuid = Long.parseLong((String) request.getParameter("uuid"));
		MerchantProfile mp = md.loadMerchantProfile(uuid);
		
		List<Dish> d = dd.findDishesByMerchantUuid(uuid);
		request.setAttribute("merchant", mp);
		request.setAttribute("dish", d);
		
		request.getRequestDispatcher("MerchantInfo.jsp").forward(request, response);
		
		
	}

}
