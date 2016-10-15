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
	private final JMSProducer jmsProducer = PtpProducer.getInstance();


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean isSuccess = false;
		
		MerchantProfile merchantProfile = null;
		MerchantAccount merchantAccount = null;

		Map map = new HashMap();
		
		String path = this.getServletContext().getRealPath("/temp");
		File f = new File(path);
		
		DiskFileItemFactory factory = new DiskFileItemFactory(10240,f );
		
		ServletFileUpload upload = new ServletFileUpload();
		upload.setFileItemFactory(factory);
		
		List<FileItem> fis=null;
		
		try {
			// file will store in temp folder
			fis = upload.parseRequest(request);
			FileItem fileItem = null;
			for(FileItem fi:fis){
				if(fi.isFormField()){
					//get form values
					String fieldname = fi.getFieldName();
				    String fieldvalue = fi.getString();
				    map.put(fieldname, fieldvalue);	
				}
				else
					fileItem = fi;
			}
			
			// checking existing 
			String uname = (String) map.get("uname");
			String mname = (String)map.get("mname");
			
			merchantAccount = mm.loadMerchantAccount(uname);
			merchantProfile = mpm.loadMerchantProfile(uname);
			
			if(fileItem == null || merchantAccount!=null || merchantProfile!=null)
				isSuccess = false;
			else{
				// merchant account
				merchantAccount = new MerchantAccount();
				merchantAccount.setUname(uname);
				merchantAccount.setPsd((String)map.get("password"));
				
				// merchant profile
				merchantProfile = new MerchantProfile();
				merchantProfile.setmName(mname);
				merchantProfile.setmAge(Integer.parseInt((String)map.get("age")));
				merchantProfile.setmGender((String)map.get("gender"));
				merchantProfile.setsName((String)map.get("shopName"));
				merchantProfile.setsAddr((String)map.get("address"));
				merchantProfile.setsTel((String)map.get("telno"));
				merchantProfile.setsLogoPath(path);
				merchantProfile.setsLogoPath(uploadFile(fileItem, uname));
			}
		}
		catch(FileUploadException e){
			e.printStackTrace();
			request.setAttribute("msgType", "errorType");
			request.setAttribute("msg", "Sign up failed. Shop logo failed to be uploaded.");
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("msgType", "errorType");
			request.setAttribute("msg", "Sign up failed. Invalid field input found.");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msgType", "errorType");
			request.setAttribute("msg", "Sign up failed. Please contact support.");
		}
		
		// select distinct account, shop
		if(isSuccess){
			try{
				mm.addMerchant(merchantAccount);
				mpm.addMerchantProfile(merchantProfile);
				jmsProducer.sendMsg();
				request.setAttribute("msgType", "succMsg");
				request.setAttribute("msg", "Sign up successed. Please sign in again.");
			}
			catch(JMSException e){
				
				System.out.println("Failed to send msg to AdminSystem.");
			}
			catch(Exception e){
				System.out.println("Failed to add merchant account and merchant profile.");
				request.setAttribute("msgType", "errorType");
				request.setAttribute("msg", "Sign up failed. User name or Shop name already exist.");
			}
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	// do upload and return path
	private String uploadFile(FileItem fi, String userName) throws Exception{
		
		String fileRealPath = null;
		String fileRelativePath = null;
		
		try {
			String fileName = fi.getName();
			int index = fileName.lastIndexOf(".");
			if(index <= 0)
				throw new IOException();
			String extension = fileName.substring(index+1);
			fileRealPath = this.getServletContext().getRealPath("/img/logo/" + userName + "." + extension);
			fileRelativePath = this.getServletContext().getContextPath() + "/img/logo/" + userName + "." + extension;
			
			
			InputStream in = fi.getInputStream();
			byte[] bs = new byte[in.available()];
			in.read(bs);
			File storeFile = new File(fileRealPath);
			fi.write(storeFile);
			
			
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
		System.out.println(fileRelativePath);
		return fileRelativePath;
	}
}
