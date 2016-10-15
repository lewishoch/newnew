package service.impl;

import dao.MerchantProfileDao;
import dao.impl.MerchantProfileDaoImpl;
import po.MerchantProfile;
import service.MerchantProfileManager;

public class MerchantProfileManagerImpl implements MerchantProfileManager {
	private MerchantProfileDao mpd = new MerchantProfileDaoImpl();
	
	public MerchantProfile loadMerchProfileByAccountUuid(long merchAccountId) {
		return mpd.loadMerchantProfileByAccountUuid(merchAccountId);
	}

}
