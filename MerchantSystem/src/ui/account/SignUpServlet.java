package ui.account;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.jms.JMSException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import po.MerchantAccount;
import po.MerchantProfile;
import service.MerchantAccountManager;
import service.MerchantProfileManager;
import service.impl.MerchantAccountManagerImpl;
import service.impl.MerchantProfileManagerImpl;
import jms.producer.JMSProducer;
import jms.producer.impl.PtpProducer;



/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final MerchantAccountManager mm = new MerchantAccountManagerImpl();
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
		MerchantAccount merchant = null;

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
			// read upload file here
			uploadFile(request);

			System.out.println(mname);
			System.out.println(age);
			System.out.println(gender);
			System.out.println(shopName);
			System.out.println(address);
			System.out.println(telno);
			
			// create po
			merchant = new MerchantAccount();
			merchant.setUname(uname);
			merchant.setPsd(password);
			
			merchantProfile = new MerchantProfile();
			merchantProfile.setmAge(age);
			merchantProfile.setmGender(gender);
			merchantProfile.setmName(mname);
			
			merchantProfile.setsName(shopName);
			merchantProfile.setsAddr(address);
			merchantProfile.setsTel(telno);
			//merchantProfile.setsLogoPath(sLogoPath);
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// failed in validation
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

		// query db find all user
		isValidAccount = mm.loadMerchantAccount(merchant.getUname())!=null;
		isValidShop = mpm.loadMerchantProfile(merchantProfile.getmName())!=null;
		
		//request.getRequestDispatcher("listAllUsers").forward(request,response);
		
		
		// select distinct account, shop
		
		if(isValidAccount && isValidShop){
			// db insert
			mm.addMerchant(merchant);
			mpm.addMerchantProfile(merchantProfile);
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
	
	// do upload and return path
	private String uploadFile(HttpServletRequest request){
		
		String path=this.getServletContext().getRealPath("/temp");
		File f=new File(path);
		
		DiskFileItemFactory factory=new DiskFileItemFactory(102,f );
		
		ServletFileUpload upload=new ServletFileUpload();
		upload.setFileItemFactory(factory);
		
		List<FileItem> fis=null;
		try {
			fis= upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(FileItem fi:fis){
			
			if(fi.isFormField()){
				System.out.println(fi.getFieldName() +"......."+fi.getString());
			}
			else{
//				InputStream in= fi.getInputStream();
//				byte[] bs=new byte[in.available()];
//				in.read(bs);
				//fi.write(file);
				System.out.println(fi.getSize());
			}
		}
		
		return "";
	}
}
