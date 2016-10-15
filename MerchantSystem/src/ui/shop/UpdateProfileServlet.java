package ui.shop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jms.producer.JMSProducer;
import jms.producer.impl.PtpProducer;
import service.MerchantProfileManager;
import service.impl.MerchantProfileManagerImpl;

/**
 * Servlet implementation class UpdateProfileServlet
 */
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final MerchantProfileManager mpm = new MerchantProfileManagerImpl();
	private final JMSProducer jmsProjecter = PtpProducer.getInstance();


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession(false);
		
		if(sen!=null){
			
			
		}
		else
			response.sendRedirect("index.jsp");
	}

}
