package ui.common;

import javax.servlet.http.HttpSession;

import po.MerchantAccount;
import service.MerchantAccountManager;
import service.impl.MerchantAccountManagerImpl;

public class SessionLogin {
	private static final MerchantAccountManager mam = new MerchantAccountManagerImpl();
	
	public static boolean sessionLogin(HttpSession sen){
		System.out.println("enter");
		if(sen == null) return false;
		
		try{
			// check in case is null
			boolean isLogin = (boolean)sen.getAttribute("isLogin");
			long uuid = (Long) sen.getAttribute("uuid");
			return isLogin;
		}
		catch(Exception e){
			System.out.println("fail");
			return false;
		}
	}
}
