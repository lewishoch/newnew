package ui.account;

import java.io.IOException;

import javax.jms.JMSException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import po.MerchantProfile;
import service.MerchantManager;
import service.MerchantProfileManager;
import service.impl.MerchantManagerImpl;
import service.impl.MerchantProfileManagerImpl;
import jms.producer.JMSProducer;
import jms.producer.impl.PtpProducer;



/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final MerchantManager mm = new MerchantManagerImpl();
	private final MerchantProfileManager mpm = new MerchantProfileManagerImpl();
	private final JMSProducer jmsProjecter = PtpProducer.getInstance();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean isValidAccount = false;
		boolean isValidShop = false;
		boolean isSuccess = false;
		
		MerchantProfile merchantProfile = null;
		Merchant merchant = null;

		try {
			// merchant info
			String uname = (String)request.getParameter("uname");
			String password = (String)request.getParameter("password");
			
			// merchant profile info
			String mname = (String)request.getParameter("mname");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = (String)request.getParameter("gender");
			String shopName = (String)request.getParameter("shopName");
			String address = (String)request.getParameter("address");
			String telno = (String)request.getParameter("telno");

			System.out.println(mname);
			System.out.println(age);
			System.out.println(gender);
			System.out.println(shopName);
			System.out.println(address);
			System.out.println(telno);
			
			// create po
			merchant = new Merchant();
			merchant.setUname(uname);
			merchant.setPsd(password);
			
			merchantProfile = new MerchantProfile();
			merchantProfile.setmAge(age);
			merchantProfile.setmGender(gender);
			merchantProfile.setsName(mname);
			merchantProfile.setsName(shopName);
			merchantProfile.setsAddr(address);
			merchantProfile.setsTel(telno);
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// failed in validation
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		// query db find all user
		isValidAccount = mm.loadMerchant(merchant.getUname())!=null;
		
		
		//request.getRequestDispatcher("listAllUsers").forward(request,response);
		
		
		// select distinct account, shop
		
		if(isValidAccount && isValidShop){
			// db insert
			isSuccess = true;
			
			if(isSuccess){
				sendMsg("hello");
			}
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void sendMsg(String msg){
		try {
			jmsProjecter.sendMsg(msg);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private boolean uploadFile(){
		return false;
	}
}
