package service;

import po.MerchantProfile;

public interface MerchantProfileManager {
	public MerchantProfile loadMerchProfile(long account_uuid);
}
