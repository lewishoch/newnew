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
		
		AdminAccount aa = aam.loadAdminAccount(adminName);
		if(aa != null){
			HttpSession sen = request.getSession(true);
			sen.setAttribute("isLogin", true);
			sen.setAttribute("name", adminName);
			request.setAttribute("name", adminName);
			response.sendRedirect("index.jsp");
		}
		else{
			System.out.println("fail");
			response.getWriter().write("Invalid name");
//			response.sendRedirect("login.jsp");			
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
