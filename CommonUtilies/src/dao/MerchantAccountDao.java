package dao;

import java.util.List;

import po.MerchantAccount;

public interface MerchantAccountDao {
	public boolean addMerchant(MerchantAccount m);
	public boolean updateMerchant(MerchantAccount m);
	public List<MerchantAccount> findAllMerchants(int status);
	public MerchantAccount loadMerchant(String userName);
	public MerchantAccount loadMerchant(long uuid);
}
