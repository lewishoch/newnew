package service.impl;

import java.util.List;

import dao.MerchantAccountDao;
import dao.impl.MerchantAccountDaoImpl;
import po.MerchantAccount;
import service.MerchantAccountManager;

public class MerchantAccountManagerImpl implements MerchantAccountManager {
	private MerchantAccountDao ma = new MerchantAccountDaoImpl();
	
	public MerchantAccount loadMerchAccount(long id) {
		return ma.loadMerchant(id);
	}

	public void addMerchAccount(MerchantAccount m) {
		ma.addMerchant(m);		
	}

	public void updateMerchAccount(MerchantAccount m) {
		ma.updateMerchant(m);		
	}

	public List<MerchantAccount> listAllMerchAccounts() {
		
		return ma.findAllMerchants();
	}

	public List<MerchantAccount> listMerchAccountsByStatus(int status) {
		
		return ma.findMerchantsByStatus(status);
	}

}
