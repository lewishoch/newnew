package ui;  	

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;

import po.MerchantProfile;
import dao.MerchantProfileDao;
import dao.impl.MerchantProfileDaoImpl;

/**
 * Servlet implementation class ShowMerchantServlet
 */
public class LoadMerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantProfileDao md = new MerchantProfileDaoImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String merchantName = request.getParameter("sName");
		//System.out.println(merchantName);
		//long uuid = Integer.parseInt(request.getParameter("uuid"));
		//MerchantProfile mpId = md.loadMerchantProfile(uuid);
		MerchantProfile mp = md.loadMerchantProfile(merchantName);
		//System.out.println(mp);
		//System.out.println(mpId);
		request.setAttribute("merchant", mp);
		//request.setAttribute("merchant", mpId);
		request.getRequestDispatcher("MerchantInfo.jsp").forward(request, response);
		
		
		//upload photo
		//String path = new this.getServletContext().getRealPath()
		
	}

}
