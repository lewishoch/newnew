package service;

import java.util.List;

import po.MerchantAccount;

public interface MerchantAccountManager {
	public MerchantAccount loadMerchAccount(long id);
	public void addMerchAccount(MerchantAccount ma);
	public void updateMerchAccount(MerchantAccount ma);
	public List<MerchantAccount> listAllMerchAccounts();
	public List<MerchantAccount> listMerchAccountsByStatus(int status);
}
