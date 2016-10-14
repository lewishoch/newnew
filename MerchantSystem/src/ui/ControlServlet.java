package ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.Merchant;
import service.MerchantManager;
import service.impl.MerchantManagerImpl;

/**
 * Servlet implementation class ControlServlet
 */
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantManager mm = new MerchantManagerImpl(); 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession();
		if(sen!=null){
			try{
				Merchant merchant = mm.loadMerchant((String)sen.getAttribute("merchantName"));
				// check merchant is accpeted
				if(merchant.getStatus()==0){
					// put...
					
					// redirect to control.jsp
					request.getRequestDispatcher("control.jsp").forward(request,response);
				}
				else{
					// redirect to status.jsp
					request.getRequestDispatcher("status.jsp").forward(request,response);
				}
			}
			catch(Exception e){
				response.sendRedirect("logout");
			}
		}
		else
			// redirect to logout
			response.sendRedirect("logout");
	}

}
