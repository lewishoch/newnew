package service.impl;

import dao.MerchantProfileDao;
import dao.impl.MerchantProfileDaoImpl;
import po.MerchantProfile;
import service.MerchantProfileManager;

public class MerchantProfileManagerImpl implements MerchantProfileManager {
	private MerchantProfileDao mpd = new MerchantProfileDaoImpl();
	
	public MerchantProfile loadMerchProfile(long merchAccountId) {
		return mpd.loadMerchantProfile(merchAccountId);
	}

}
