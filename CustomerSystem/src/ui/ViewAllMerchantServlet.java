package ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import po.MerchantProfile;
import dao.MerchantProfileDao;
import dao.impl.MerchantProfileDaoImpl;

//import service.UserManager;
//import service.impl.UserManagerImpl;

/**
 * Servlet implementation class ViewMerchantServlet
 */
public class ViewAllMerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantProfileDao md = new MerchantProfileDaoImpl();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MerchantProfile> mp =  md.loadAllMerchantProfile(0);
		request.setAttribute("merchant", mp);
		System.out.println(mp.size());
		request.getRequestDispatcher("viewMerchant.jsp").forward(request, response);
	}

}
