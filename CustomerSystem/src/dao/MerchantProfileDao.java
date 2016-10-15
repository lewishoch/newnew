package dao;

import java.util.List;

import po.MerchantProfile;

public interface MerchantProfileDao {
	public boolean addMerchantProfile(MerchantProfile mp);
	public boolean updateMerchant(MerchantProfile mp);
	public MerchantProfile loadMerchantProfile(String shopName);
	public MerchantProfile loadMerchantProfile(long uuid);
	public List<MerchantProfile> loadAllMerchantProfile(int status);
}
