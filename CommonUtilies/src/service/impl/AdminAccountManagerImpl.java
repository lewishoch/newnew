package service.impl;

import dao.AdminAccountDao;
import dao.impl.AdminAccountDaoImpl;
import po.AdminAccount;
import service.AdminAccountManager;

public class AdminAccountManagerImpl implements AdminAccountManager {

	private AdminAccountDao dao = new AdminAccountDaoImpl();
	
	public AdminAccount loadAdminAccount(String accName) {
		return dao.loadAdmin(accName);
	}

}