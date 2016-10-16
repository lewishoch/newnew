package ui;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import po.AdminAccount;
import service.AdminAccountManager;
import service.impl.AdminAccountManagerImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminAccountManager aam = new AdminAccountManagerImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String adminName = request.getParameter("adminName");
		String adminPassword = request.getParameter("adminPassword");
		
		AdminAccount aa = aam.loadAdminAccount(adminName);
		if(aa != null && aa.getPassword().equals(adminPassword)){
			HttpSession sen = request.getSession(true);
			sen.setAttribute("isLogin", true);
			sen.setAttribute("name", adminName);
			request.setAttribute("name", adminName);
			response.sendRedirect("showHome");
		}
		else{
			System.out.println("fail");
			request.setAttribute("msgType", "errorMsg");
			request.setAttribute("msg", "Invalid username or password.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
