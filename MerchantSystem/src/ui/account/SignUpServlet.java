package ui.account;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		Map map = new HashMap();
		
		String path = this.getServletContext().getRealPath("/temp");
		File f=new File(path);
		
		DiskFileItemFactory factory=new DiskFileItemFactory(10240,f );
		
		ServletFileUpload upload=new ServletFileUpload();
		upload.setFileItemFactory(factory);
		
		List<FileItem> fis=null;
		
		try {
			
			fis = upload.parseRequest(request);
			for(FileItem fi:fis){
				if(fi.isFormField()){
					String fieldname = fi.getFieldName();
				    String fieldvalue = fi.getString();
				    map.put(fieldname, fieldvalue);	
				}
				else
				{
					// read upload file here
					uploadFile(fi);
				}
			}
			// merchant info
			String uname = (String) map.get("uname");
			String password = (String)map.get("password");
			
			// merchant profile info
			String mname = (String)map.get("mname");
			int age = Integer.parseInt((String)map.get("age"));
			String gender = (String)map.get("gender");
			String shopName = (String)map.get("shopName");
			String address = (String)map.get("address");
			String telno = (String)map.get("telno");
			

			System.out.println(uname);
			System.out.println(password);
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
			
			
		}
		catch(FileUploadException e){
			e.printStackTrace();
		}
		catch (NumberFormatException e) {
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
	private String uploadFile(FileItem fi){
		
		try {
			
			InputStream in= fi.getInputStream();
			byte[] bs=new byte[in.available()];
			in.read(bs);
			File storeFile = new File(this.getServletContext().getRealPath("/real/abc.jpg"));
			fi.write(storeFile);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "";
	}
}
