package ui;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ListPendingMerchantServlet
 */
public class ListPendingMerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantAccountManager mam = new MerchantAccountManagerImpl();
	private SessionManager sm = new SessionManagerImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!sm.isSessionValid(request))
			response.sendRedirect("login.jsp");
		else{
			List<MerchantAccount> mal = mam.listMerchAccountsByStatus(AccountStatusProtocol.PENDING); 
	//		System.out.println(mal.size());
			request.setAttribute("maList", mal);
			request.getRequestDispatcher("pendingMerchantList.jsp").forward(request, response);
		}
	}

}
