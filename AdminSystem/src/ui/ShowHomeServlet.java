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


public class ShowHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantAccountManager mam = new MerchantAccountManagerImpl();
	private SessionManager sm = new SessionManagerImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!sm.isSessionValid(request))
			response.sendRedirect("login.jsp");
		else{
			List<MerchantAccount> mal1 = mam.listMerchAccountsByStatus(AccountStatusProtocol.PENDING);
			request.setAttribute("size1", mal1.size());
//			System.out.println(mal.size());
			List<MerchantAccount> mal2 = mam.listMerchAccountsByStatus(AccountStatusProtocol.ACCEPTED);
			List<MerchantAccount> mal3 = mam.listMerchAccountsByStatus(AccountStatusProtocol.REJECTED);
			request.setAttribute("size2", mal2.size()+mal3.size());
			request.getRequestDispatcher("index.jsp").forward(request, response);
//			response.sendRedirect("index.jsp");
		}
	}

}
