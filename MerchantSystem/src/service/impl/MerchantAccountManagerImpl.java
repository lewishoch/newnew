package service.impl;

import java.util.List;

import dao.MerchantAccountDao;
import dao.impl.MerchantAccountDaoImpl;
import po.MerchantAccount;
import service.MerchantAccountManager;

public class MerchantAccountManagerImpl implements MerchantAccountManager {
	private MerchantAccountDao dao = new MerchantAccountDaoImpl();
	
	public boolean addMerchant(MerchantAccount m) {
		return dao.addMerchant(m);
	}

	public boolean updateMerchant(MerchantAccount m) {
		return dao.updateMerchant(m);
	}
	
	public List<MerchantAccount> findAllMerchants() {
		return dao.findAllMerchants();
	}

	public List<MerchantAccount> findMerchantsByStatus(int status) {
		return dao.findMerchantsByStatus(status);
	}

	public MerchantAccount loadMerchantAccount(String userName) {
		return dao.loadMerchant(userName);
	}

	public MerchantAccount loadMerchantAccount(long uuid) {
		return dao.loadMerchant(uuid);
	}
	
}
