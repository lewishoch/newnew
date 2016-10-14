package service;

import po.*;

public interface AdminAccountManager {
	public AdminAccount loadAdminAccount(String accName);
	public void addAdminAccount(AdminAccount aa);
	public void updateAdminAccount(AdminAccount aa);
}
