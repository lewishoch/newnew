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
 * Servlet implementation class AcceptMerchantServlet
 */
public class AcceptMerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantAccountManager mam = new MerchantAccountManagerImpl();
	private SessionManager sm = new SessionManagerImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(!sm.isSessionValid(req))
			resp.sendRedirect("login.jsp");
		else{
			long uuid = Long.parseLong(req.getParameter("uuid"));
	//		System.out.println(uuid);
			MerchantAccount ma = mam.loadMerchAccount(uuid);
			ma.setStatus(AccountStatusProtocol.ACCEPTED);
			mam.updateMerchAccount(ma);
	//		req.getRequestDispatcher("listPendingMerchant").forward(req, resp);
			resp.sendRedirect("listPendingMerchant");
		}
	}
}
