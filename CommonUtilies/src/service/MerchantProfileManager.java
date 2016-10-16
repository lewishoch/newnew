package service;

import java.util.List;

import po.MerchantProfile;

public interface MerchantProfileManager {
	public boolean addMerchantProfile(MerchantProfile mp);
	public boolean updateMerchant(MerchantProfile mp);
	public MerchantProfile loadMerchantProfile(String merchantName);
	public MerchantProfile loadMerchantProfile(long uuid);
	public List<MerchantProfile> findAllMerchantProfiles();
}
