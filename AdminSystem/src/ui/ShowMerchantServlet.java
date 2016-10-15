package ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.MerchantProfile;
import service.MerchantAccountManager;
import service.MerchantProfileManager;
import service.impl.MerchantAccountManagerImpl;
import service.impl.MerchantProfileManagerImpl;


public class ShowMerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantAccountManager mam = new MerchantAccountManagerImpl();
	private MerchantProfileManager mpm = new MerchantProfileManagerImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long account_uuid = Long.parseLong(request.getParameter("uuid"));
		
		MerchantProfile mp = mpm.loadMerchProfileByAccountUuid(account_uuid);
//		System.out.println(mp.getsName());
		request.setAttribute("mp", mp);
		request.getRequestDispatcher("merchantInfo.jsp").forward(request, response);
	}

}
