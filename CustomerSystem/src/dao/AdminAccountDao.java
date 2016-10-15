package dao;

import po.AdminAccount;

public interface AdminAccountDao {
	public AdminAccount loadAdmin(String accName);
}
