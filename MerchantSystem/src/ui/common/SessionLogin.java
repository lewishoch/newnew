package ui.common;

import javax.servlet.http.HttpSession;

import po.MerchantAccount;
import service.MerchantAccountManager;
import service.impl.MerchantAccountManagerImpl;

public class SessionLogin {
	private static final MerchantAccountManager mam = new MerchantAccountManagerImpl();
	
	public static boolean sessionLogin(HttpSession sen){
		if(sen == null) return false;
		
		try{
			// check in case is null;
			boolean isLogin = Boolean.parseBoolean((String) sen.getAttribute("isLogin"));
			long uuid = Long.parseLong((String) sen.getAttribute("uuid"));
			
			return isLogin; 
		}
		catch(Exception e){
			return false;
		}
	}
}
