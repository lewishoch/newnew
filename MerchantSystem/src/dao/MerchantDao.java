package dao;

import java.util.List;

import po.Merchant;

public interface MerchantDao {
	public boolean addMerchant(Merchant m);
	public boolean updateMerchant(Merchant m);
	public List<Merchant> findAllMerchants(int status);
	public Merchant loadMerchant(String userName);
	public Merchant loadMerchant(long uuid);
}
