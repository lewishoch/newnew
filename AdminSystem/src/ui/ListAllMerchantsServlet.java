package ui;

import java.io.IOException;
import java.util.ArrayList;
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

public class ListAllMerchantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantAccountManager mam = new MerchantAccountManagerImpl();
	private SessionManager sm = new SessionManagerImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!sm.isSessionValid(request))
			response.sendRedirect("login.jsp");
		else{
			String parentPage = request.getParameter("parent");
			List<MerchantAccount> maAcceptedList = mam.listMerchAccountsByStatus(AccountStatusProtocol.ACCEPTED);
			List<MerchantAccount> maFrozenList = mam.listMerchAccountsByStatus(AccountStatusProtocol.FROZON);
			List<MerchantAccount> maList = new ArrayList<MerchantAccount>();
			maList.addAll(maAcceptedList);
			maList.addAll(maFrozenList);
			request.setAttribute("maList", maList);
			request.setAttribute("parentPage", parentPage);
			request.getRequestDispatcher("allMerchantList.jsp").forward(request, response);
		}
	}

}
