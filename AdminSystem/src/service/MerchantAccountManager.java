package service;

import java.util.List;

import po.MerchantAccount;

public interface MerchantAccountManager {
	public MerchantAccount loadMerchAccount(int id);
	public void addMerchAccount(MerchantAccount ma);
	public void updateMerchAccount(MerchantAccount ma);
	public List<MerchantAccount> listAllMerchAccounts();
}
