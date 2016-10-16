package dao;

import java.util.List;

import po.Merchant;
import po.MerchantProfile;

public interface MerchantDao {
	public boolean addMerchant(Merchant m);
	public boolean updateMerchant(Merchant m);
	public List<Merchant> findAllMerchants(int status);
	public Merchant loadMerchant(MerchantProfile mp);
	public Merchant loadMerchant(long uuid);
}
