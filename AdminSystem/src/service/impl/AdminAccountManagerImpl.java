package service.impl;

import dao.AdminAccountDao;
import dao.impl.AdminAccountImpl;
import po.AdminAccount;
import service.AdminAccountManager;

public class AdminAccountManagerImpl implements AdminAccountManager {
	private AdminAccountDao aa = new AdminAccountImpl();
	
	public AdminAccount loadAdminAccount(String accName) {
		return aa.loadAdmin(accName);
	}

	public void addAdminAccount(AdminAccount aa) {
		
		
	}

	public void updateAdminAccount(AdminAccount aa) {
		// TODO Auto-generated method stub
		
	}

}
