package service.impl;

import dao.AdminAccountDao;
import dao.impl.AdminAccountDaoImpl;
import po.AdminAccount;
import service.AdminAccountManager;

public class AdminAccountManagerImpl implements AdminAccountManager {
	private AdminAccountDao aa = new AdminAccountDaoImpl();
	
	public AdminAccount loadAdminAccount(String accName) {
		return aa.loadAdmin(accName);
	}

	public void addAdminAccount(AdminAccount aa) {
		
		
	}

	public void updateAdminAccount(AdminAccount aa) {
		// TODO Auto-generated method stub
		
	}

}
