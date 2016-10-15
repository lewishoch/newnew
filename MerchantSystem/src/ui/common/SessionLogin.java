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
			MerchantAccount m = (MerchantAccount) sen.getAttribute("merchantAccount");
			String loginName = m.getUname();
			String loginPassword = m.getPsd();
			String matchPassword = mam.loadMerchantAccount(loginName).getPsd();
			
			return loginPassword.equals(matchPassword);
		}
		catch(Exception e){
			return false;
		}
	}
}
