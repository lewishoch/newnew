package ui;  	

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import po.Dish;
import po.MerchantProfile;
import dao.DishDao;
import dao.MerchantProfileDao;
import dao.impl.DishDaoImpl;
import dao.impl.MerchantProfileDaoImpl;
import dto.DishDTO;

/**
 * Servlet implementation class ShowMerchantServlet
 */
public class LoadMerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantProfileDao md = new MerchantProfileDaoImpl();
	private DishDao dd = new DishDaoImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String merchantName = request.getParameter("sName");

		long uuid = Long.parseLong((String) request.getParameter("uuid"));
		MerchantProfile mp = md.loadMerchantProfile(uuid);
		
		List<Dish> dishes = dd.findDishesByMerchantUuid(uuid);
		List<DishDTO> dishDTO = new ArrayList<DishDTO>();
		
		for(Dish d : dishes)
		{
			DishDTO temp = new DishDTO();
			List<String> filePaths = getdishPath(this.getServletContext(),d.getDishFolderPath());
			temp.setDishId(d.getDishId());
			temp.setDishName(d.getDishName());
			temp.setDishPath(filePaths);
			dishDTO.add(temp);
		}
		request.setAttribute("merchant", mp);
		request.setAttribute("dishes", dishDTO);
		
		
		request.getRequestDispatcher("MerchantInfo.jsp").forward(request, response);
		
		
	}
	
	private ArrayList<String> getdishPath(ServletContext servletContext, String fileFolderPath)
	{	
		String str = servletContext.getRealPath("");
		str = str.replace("\\CustomerSystem", "\\MerchantSystem");
		str += fileFolderPath;
		
		
		ArrayList<String> result = new ArrayList<String>();
		String a  = servletContext.getContextPath();
		File folder = new File(str);
		File[] listOfFiles = folder.listFiles();
		if(listOfFiles != null){
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		    	  result.add("/MerchantSystem"+ fileFolderPath + "/"+listOfFiles[i].getName());
		      } 
		    }
		}
		return result;
		
	}

}
