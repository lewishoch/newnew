package ui.dish;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import po.Dish;
import service.DishManager;
import service.impl.DishManagerImpl;
import ui.common.SessionLogin;
import util.UploadImage;

public class UpdateDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final DishManager dm = new DishManagerImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession(false);
		
		if(SessionLogin.sessionLogin(sen)){
			
			Map map = new HashMap();
			String path = this.getServletContext().getRealPath("/temp/img/dish");
			File f = new File(path);
			
			DiskFileItemFactory factory = new DiskFileItemFactory(10240,f );
			
			ServletFileUpload upload = new ServletFileUpload();
			upload.setFileItemFactory(factory);
			
			List<FileItem> fis=null;
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
				}
				
				long mid = Long.parseLong((String)map.get("mid"));
				long did = Long.parseLong((String)map.get("did"));
				String dname = (String)map.get("dname");
				
				String oldDName = (String)map.get("oldDName");
				String dpath = this.getServletContext().getRealPath("/img/dish/"+mid + "_" + oldDName);
				String savePath = "/img/dish/"+mid + "_" + dname;
				//delete image
				UploadImage.deleteImage(dpath);
				
				for(FileItem fi:fis)
				{
					if(!fi.isFormField() && !fi.getName().isEmpty())
					{
						UploadImage.uploadDishImage(fi,this.getServletContext().getRealPath("/img/dish/"+mid + "_" + dname));
					}	
				}
				
				Dish d = new Dish();
				d.setMerchantUuid(mid);
				d.setDishId(did);
				d.setDishName(dname);
				d.setDishFolderPath(savePath);
				
				if(dm.updateDish(d)){
					request.setAttribute("msgType", "succMsg");
					request.setAttribute("msg", "Record has been updated.");
				}
				else{
					request.setAttribute("msgType", "errorMsg");
					request.setAttribute("msg", "Failed to update the record.");
				}
				request.getRequestDispatcher("control").forward(request, response);

				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
			response.sendRedirect("logout");
	}

}
