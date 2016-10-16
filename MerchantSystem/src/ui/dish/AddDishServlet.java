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

/**
 * Servlet implementation class AddDishServlet
 */
public class AddDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DishManager dm = new DishManagerImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession(false);
		

		if(sen!=null && SessionLogin.sessionLogin(sen))
		{
			Map map = new HashMap();
			String path = this.getServletContext().getRealPath("/temp/img/dish");
			File f = new File(path);
			
			DiskFileItemFactory factory = new DiskFileItemFactory(10240,f );
			
			ServletFileUpload upload = new ServletFileUpload();
			upload.setFileItemFactory(factory);
			
			List<FileItem> fis=null;
			System.out.println("try");
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
				System.out.println("before mid");
				long mid = Long.parseLong((String)map.get("mid"));
				String dname = (String)map.get("dname");
				String dpath = "/img/dish/"+mid + "_" + dname;
				System.out.println("after mid");
				if (dm.loadDish(dname, mid) != null) {
					System.out.println("exist");
					request.setAttribute("msgType", "errorType");
					request.setAttribute("msg", "The dish name exists in your shop already.");
				}
				else {
					System.out.println("not exist");
					for(FileItem fi:fis)
						if(!fi.isFormField() && !fi.getName().isEmpty())
							UploadImage.uploadDishImage(fi,this.getServletContext().getRealPath("/img/dish/"+mid + "_" + dname));
					
					System.out.println("before op");
					Dish d = new Dish();
					d.setMerchantUuid(mid);
					d.setDishName(dname);
					d.setDishFolderPath(dpath);
					System.out.println("after po");
					if (dm.addDish(d)) {
						System.out.println("succ");
						request.setAttribute("msgType", "succType");
						request.setAttribute("msg", "Dish is added successfully.");
					}
					else {
						System.out.println("fail");
						request.setAttribute("msgType", "errorType");
						request.setAttribute("msg", "Problem with database! Please try later.");
					}
				}
				System.out.println("to control");
				request.getRequestDispatcher("control").forward(request, response);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				request.setAttribute("msgType", "errorType");
				request.setAttribute("msg", "Unexpected problem happen! Please try later.");
				request.getRequestDispatcher("control").forward(request, response);
			}
			
		}
		else
			response.sendRedirect("logout");
	}
	
	

}
