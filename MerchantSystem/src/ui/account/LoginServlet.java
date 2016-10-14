package ui.account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.Merchant;
import service.MerchantManager;
import service.impl.MerchantManagerImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantManager mm = new MerchantManagerImpl();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession(true);
		String uname = (String)request.getParameter("uname");
		String password = (String)request.getParameter("password");
		
		Merchant merchant = mm.loadMerchant(uname);
		
		// check if valid
		if(merchant!=null && merchant.getPsd().equals(password)){
			sen.setAttribute("id", merchant.getUuid());
			request.getRequestDispatcher("control.jsp").forward(request,response);
		}
		else{
			// else
			request.setAttribute("loginMsg", "Wrong user name or password.");
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}
	}
}
