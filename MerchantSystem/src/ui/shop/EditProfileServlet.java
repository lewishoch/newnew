package ui.shop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jms.producer.JMSProducer;
import jms.producer.impl.PtpProducer;
import po.MerchantProfile;
import service.MerchantProfileManager;
import service.impl.MerchantProfileManagerImpl;
import ui.common.SessionLogin;

/**
 * Servlet implementation class UpdateProfileServlet
 */
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final MerchantProfileManager mpm = new MerchantProfileManagerImpl();
	private final JMSProducer jmsProjecter = PtpProducer.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession(false);
		
		if(sen!=null && SessionLogin.sessionLogin(sen)){
			
			int id = Integer.parseInt(request.getParameter("muuid"));
			MerchantProfile merchantProfile = mpm.loadMerchantProfile(id);
			request.setAttribute("merchantProfile", merchantProfile);
			request.getRequestDispatcher("updateProfileForm.jsp").forward(request, response);
			
			
		}
		else{
			response.sendRedirect("logout");
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession(false);
		
		if(sen!=null){
			
			
		}
		else
			response.sendRedirect("index.jsp");
	}

}
