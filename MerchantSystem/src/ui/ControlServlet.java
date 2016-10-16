package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.DishDTO;
import po.Dish;
import po.MerchantAccount;
import po.MerchantProfile;
import service.DishManager;
import service.MerchantAccountManager;
import service.MerchantProfileManager;
import service.impl.DishManagerImpl;
import service.impl.MerchantAccountManagerImpl;
import service.impl.MerchantProfileManagerImpl;
import ui.common.SessionLogin;
import util.UploadImage;
import protocol.AccountStatusProtocol;

/**
 * Servlet implementation class ControlServlet
 */
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MerchantAccountManager mm = new MerchantAccountManagerImpl(); 
	private MerchantProfileManager mpm = new MerchantProfileManagerImpl();
	private DishManager dm = new DishManagerImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sen = request.getSession(false);

		if(SessionLogin.sessionLogin(sen)){
			try{
				Long uuid = (Long)sen.getAttribute("uuid"); // account uuid
				MerchantAccount merchantAccount = mm.loadMerchantAccount(uuid);
				MerchantProfile merchantProfile = mpm.loadMerchantProfileByAccountUuid(uuid);
				
				request.setAttribute("merchantProfile", merchantProfile);
				
				
				// check merchant is accpeted
				if(merchantAccount.getStatus()==0){
					// put...
					System.out.println("control");
					System.out.println("dm: "+dm);
					System.out.println("uuid: "+uuid);
					System.out.println("merchantProfile: "+merchantProfile);
					System.out.println("merchantProfile uuid: "+merchantProfile.getUuid());
					
					List<Dish> dishes = dm.findDishesByMerchantUuid(merchantProfile.getUuid());
					
					List<DishDTO> dishDTO = new ArrayList<DishDTO>();
					for(Dish d : dishes)
					{
						DishDTO temp = new DishDTO();
						List<String> filePaths = UploadImage.getdishPath(this.getServletContext(),d.getDishFolderPath());
						temp.setDishId(d.getDishId());
						temp.setDishName(d.getDishName());
						temp.setDishPath(filePaths);
						dishDTO.add(temp);
					}
					request.setAttribute("dishes", dishDTO);
					
					// redirect to control.jsp
					request.getRequestDispatcher("control.jsp").forward(request,response);
				}
				else{
					System.out.println("status");
					request.setAttribute("status", AccountStatusProtocol.getStatusName(merchantAccount.getStatus()));
					
					// redirect to status.jsp
					request.getRequestDispatcher("status.jsp").forward(request,response);
				}
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("logout1");
				response.sendRedirect("logout");
			}
		}
		else{
			System.out.println("logout2");
			// redirect to logout
			response.sendRedirect("logout");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
