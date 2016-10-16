package ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.MerchantAccount;
import protocol.AccountStatusProtocol;
import service.MerchantAccountManager;
import service.SessionManager;
import service.impl.MerchantAccountManagerImpl;
import service.impl.SessionManagerImpl;

/**
 * Servlet implementation class RejectMerchantServlet
 */
public class RejectMerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantAccountManager mam = new MerchantAccountManagerImpl();
	private SessionManager sm = new SessionManagerImpl();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!sm.isSessionValid(request))
			response.sendRedirect("login.jsp");
		else{
			long uuid = Long.parseLong(request.getParameter("uuid"));
	//		System.out.println(uuid);
			MerchantAccount ma = mam.loadMerchAccount(uuid);
			ma.setStatus(AccountStatusProtocol.REJECTED);
			mam.updateMerchAccount(ma);
	//		request.getRequestDispatcher("listPendingMerchant").forward(request, response);
			response.sendRedirect("listPendingMerchant");
		}
	}

}
