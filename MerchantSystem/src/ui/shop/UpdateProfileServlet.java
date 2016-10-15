package ui.shop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.MerchantProfile;
import service.MerchantProfileManager;
import service.impl.MerchantProfileManagerImpl;

/**
 * Servlet implementation class UpdateProfileServlet
 */
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final MerchantProfileManager mpm = new MerchantProfileManagerImpl();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long uuid = Long.parseLong(request.getParameter("uuid"));
		long mAccountUuid = Long.parseLong(request.getParameter("mAccountUuid"));
		String mName = request.getParameter("mName");
		String mGender = request.getParameter("mGender");
		int mAge = Integer.parseInt(request.getParameter("mAge"));
		String sName = request.getParameter("sName");
		String sAddr = request.getParameter("sAddr");
		String sTel = request.getParameter("sTel");
		
		MerchantProfile merchantProfile = new MerchantProfile();
		merchantProfile.setUuid(uuid);
		merchantProfile.setmAccountUuid(mAccountUuid);
		merchantProfile.setmName(mName);
		merchantProfile.setmGender(mGender);
		merchantProfile.setmAge(mAge);
		merchantProfile.setsName(sName);
		merchantProfile.setsAddr(sAddr);
		merchantProfile.setsTel(sTel);
		merchantProfile.setsLogoPath("a");
		
		mpm.updateMerchant(merchantProfile);
		
		response.sendRedirect("control");
	}

}
