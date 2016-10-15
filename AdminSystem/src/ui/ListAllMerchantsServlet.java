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
import service.impl.MerchantAccountManagerImpl;

/**
 * Servlet implementation class ListAllMerchantsServlet
 */
public class ListAllMerchantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantAccountManager mam = new MerchantAccountManagerImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MerchantAccount> maAcceptedList = mam.listMerchAccountsByStatus(AccountStatusProtocol.ACCEPTED);
		List<MerchantAccount> maFrozenList = mam.listMerchAccountsByStatus(AccountStatusProtocol.FROZON);
		List<MerchantAccount> maList = new ArrayList<MerchantAccount>();
		maList.addAll(maAcceptedList);
		maList.addAll(maFrozenList);
		request.setAttribute("maList", maList);
		request.getRequestDispatcher("allMerchantList.jsp").forward(request, response);
	}

}
