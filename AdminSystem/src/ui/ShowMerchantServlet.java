package ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.MerchantProfile;
import service.MerchantProfileManager;
import service.SessionManager;
import service.impl.MerchantProfileManagerImpl;
import service.impl.SessionManagerImpl;


public class ShowMerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private MerchantAccountManager mam = new MerchantAccountManagerImpl();
	private MerchantProfileManager mpm = new MerchantProfileManagerImpl();
	private SessionManager sm = new SessionManagerImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!sm.isSessionValid(request))
			response.sendRedirect("login.jsp");
		else{
			long account_uuid = Long.parseLong(request.getParameter("uuid"));
			
			MerchantProfile mp = mpm.loadMerchProfileByAccountUuid(account_uuid);
	//		System.out.println(mp.getsName());
			request.setAttribute("mp", mp);
			request.getRequestDispatcher("merchantInfo.jsp").forward(request, response);
		}
	}

}
