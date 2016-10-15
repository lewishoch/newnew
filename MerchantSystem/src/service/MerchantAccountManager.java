package service;

import java.util.List;

import po.MerchantAccount;

public interface MerchantAccountManager {
	public boolean addMerchant(MerchantAccount m);
	public boolean updateMerchant(MerchantAccount m);
	public List<MerchantAccount> findAllMerchants();
	public List<MerchantAccount> findMerchantsByStatus(int status);
	public MerchantAccount loadMerchantAccount(String userName);
	public MerchantAccount loadMerchantAccount(long uuid);
}
