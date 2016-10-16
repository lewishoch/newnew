package service.impl;

import java.util.List;

import dao.MerchantProfileDao;
import dao.impl.MerchantProfileDaoImpl;
import po.MerchantProfile;
import service.MerchantProfileManager;

public class MerchantProfileManagerImpl implements MerchantProfileManager{
	private MerchantProfileDao dao = new MerchantProfileDaoImpl();
	
	public boolean addMerchantProfile(MerchantProfile mp) {
		return dao.addMerchantProfile(mp);
	}

	public boolean updateMerchant(MerchantProfile mp) {
		return dao.updateMerchantProfile(mp);
	}

	public MerchantProfile loadMerchantProfile(String merchantName) {
		return dao.loadMerchantProfile(merchantName);
	}

	public MerchantProfile loadMerchantProfile(long uuid) {
		return dao.loadMerchantProfile(uuid);
	}
	
	public MerchantProfile loadMerchantProfileByAccountUuid(long accountUuid){
		return dao.loadMerchantProfileByAccountUuid(accountUuid);
	}
	
	public List<MerchantProfile> findAllMerchantProfiles(){
		return dao.findAllMerchantProfiles();
	}
}
