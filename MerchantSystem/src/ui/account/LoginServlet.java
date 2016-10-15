package ui.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.MerchantAccount;
import service.MerchantAccountManager;
import service.impl.MerchantAccountManagerImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantAccountManager mm = new MerchantAccountManagerImpl();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession(true);
		String uname = (String)request.getParameter("uname");
		String password = (String)request.getParameter("password");
		
		MerchantAccount merchantAccount = mm.loadMerchantAccount(uname);
		if(merchantAccount==null) System.out.println("null");
		// check if valid
		if(merchantAccount!=null && merchantAccount.getPsd().equals(password)){
			sen.setAttribute("isLogin", true);
			sen.setAttribute("uuid", merchantAccount.getUuid());
			System.out.println("success");
			response.sendRedirect("control");
		}
		else{
			// else
			System.out.println("fail");
			request.setAttribute("msgType", "errorMsg");
			request.setAttribute("Msg", "Wrong user name or password.");
			response.sendRedirect("index.jsp");
		}
	}
}
