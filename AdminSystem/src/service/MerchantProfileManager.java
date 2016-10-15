package service;

import po.MerchantProfile;

public interface MerchantProfileManager {
	public MerchantProfile loadMerchProfileByAccountUuid(long account_uuid);
}
