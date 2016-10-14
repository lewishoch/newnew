package service.impl;

import java.util.List;

import dao.MerchantDao;
import dao.impl.MerchantDaoImpl;
import po.Merchant;
import service.MerchantManager;

public class MerchantManagerImpl implements MerchantManager {
	private MerchantDao dao = new MerchantDaoImpl();
	
	public boolean addMerchant(Merchant m) {
		return dao.addMerchant(m);
	}

	public boolean updateMerchant(Merchant m) {
		return dao.updateMerchant(m);
	}

	public List<Merchant> findAllMerchants(int status) {
		return dao.findAllMerchants(status);
	}

	public Merchant loadMerchant(String userName) {
		return dao.loadMerchant(userName);
	}

	public Merchant loadMerchant(long uuid) {
		return dao.loadMerchant(uuid);
	}
	
}
