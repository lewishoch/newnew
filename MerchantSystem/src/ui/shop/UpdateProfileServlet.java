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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import po.MerchantProfile;
import service.MerchantProfileManager;
import service.impl.MerchantProfileManagerImpl;

/**
 * Servlet implementation class UpdateProfileServlet
 */
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final MerchantProfileManager mpm = new MerchantProfileManagerImpl();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map map = new HashMap();
		String path = this.getServletContext().getRealPath("/temp");
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
					relativePath = uploadFile(fileItem, (String)map.get("mName"));
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
				

				response.sendRedirect("control");
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	private String uploadFile(FileItem fi, String userName) throws Exception
	{
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
