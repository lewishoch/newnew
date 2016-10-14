package ui;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.MerchantAccount;
import po.MerchantProfile;
import service.MerchantAccountManager;
import service.MerchantProfileManager;
import service.impl.MerchantAccountManagerImpl;
import service.impl.MerchantProfileManagerImpl;

/**
 * Servlet implementation class ControlServlet
 */
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantAccountManager mm = new MerchantAccountManagerImpl(); 
	private MerchantProfileManager mpm = new MerchantProfileManagerImpl(); 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession(false);
		
		if(sen!=null){
			try{
				String merchant_name = ((MerchantAccount)sen.getAttribute("merchant")).getUname();
				MerchantAccount merchant = mm.loadMerchantAccount(merchant_name);
				
				MerchantProfile merchantProfile = mpm.loadMerchantProfile(merchant_name);
				request.setAttribute("merchantProfile", merchantProfile);
				
				// check merchant is accpeted
				if(merchant.getStatus()==0){
					// put...
					System.out.println("control");
					// redirect to control.jsp
					request.getRequestDispatcher("control.jsp").forward(request,response);
				}
				else{
					System.out.println("status");
					
					
					// redirect to status.jsp
					request.getRequestDispatcher("status.jsp").forward(request,response);
				}
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("logout1");
				response.sendRedirect("logout");
			}
		}
		else{
			System.out.println("logout2");
			// redirect to logout
			response.sendRedirect("logout");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
