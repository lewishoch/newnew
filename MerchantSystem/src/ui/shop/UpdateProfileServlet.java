package ui.shop;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jms.producer.JMSProducer;
import jms.producer.impl.PtpProducer;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import po.MerchantProfile;
import service.MerchantProfileManager;
import service.impl.MerchantProfileManagerImpl;
import ui.common.SessionLogin;
import util.UploadImage;

/**
 * Servlet implementation class UpdateProfileServlet
 */
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final JMSProducer jmsProducer = PtpProducer.getInstance();
	private final MerchantProfileManager mpm = new MerchantProfileManagerImpl();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession(false);

		if(SessionLogin.sessionLogin(sen)){
			Map map = new HashMap();
			String path = this.getServletContext().getRealPath("/temp/img/logo");
			File f = new File(path);
			
			DiskFileItemFactory factory = new DiskFileItemFactory(10240,f );
			
			ServletFileUpload upload = new ServletFileUpload();
			upload.setFileItemFactory(factory);
			
			List<FileItem> fis=null;
			FileItem fileItem = null;
			
			
				try {
					// file will store in temp folder first
					fis = upload.parseRequest(request);
					
					for(FileItem fi:fis)
					{
						if(fi.isFormField())
						{
							//get form values
							String fieldname = fi.getFieldName();
						    String fieldvalue = fi.getString();
						    map.put(fieldname, fieldvalue);	
						}
						else
						{
							fileItem = fi;
	
						}	
					}
					
					String relativePath = (String) map.get("shopLogoPath"); 
					// if user upload a new logo
					if(!fileItem.getName().isEmpty())
					{
						System.out.println("user has update");
						relativePath = UploadImage.uploadLogo(fileItem, (String)map.get("mName"), this.getServletContext());
					}
					
					// /MerchantSystem/img/logo/Cheers.jpg
					MerchantProfile merchantProfile = new MerchantProfile();
					merchantProfile.setUuid(Long.parseLong((String)map.get("uuid")));
					merchantProfile.setmAccountUuid(Long.parseLong((String)map.get("mAccountUuid")));
					merchantProfile.setmName((String)map.get("mName"));
					merchantProfile.setmGender((String)map.get("mGender"));
					merchantProfile.setmAge(Integer.parseInt((String)map.get("mAge")));
					merchantProfile.setsName((String)map.get("sName"));
					merchantProfile.setsAddr((String)map.get("sAddr"));
					merchantProfile.setsTel((String)map.get("sTel"));
					merchantProfile.setsLogoPath(relativePath);
					
					mpm.updateMerchant(merchantProfile);
					//jmsProducer.sendMsg("profile updated.");
					request.setAttribute("msgType", "succMsg");
					request.setAttribute("msg", "Update successed.");
					
				} catch (NumberFormatException e) {
					e.printStackTrace();
					request.setAttribute("msgType", "errorMsg");
					request.setAttribute("msg", "Update failed. Invalid Input.");
				} catch (FileUploadException e) {
					e.printStackTrace();
					request.setAttribute("msgType", "errorMsg");
					request.setAttribute("msg", "Update failed. Failed to upload logo.");
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("msgType", "errorMsg");
					request.setAttribute("msg", "Update failed.");
				}
				finally{
					request.getRequestDispatcher("control").forward(request, response);
				}
		}
		else
			response.sendRedirect("logout");
	}


}
