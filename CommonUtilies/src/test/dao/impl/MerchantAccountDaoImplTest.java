package test.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import po.MerchantAccount;
import dao.MerchantAccountDao;
import dao.impl.MerchantAccountDaoImpl;

public class MerchantAccountDaoImplTest {
	private MerchantAccountDao mad = new MerchantAccountDaoImpl();
	
	@Test
	public void testLoadByName()
	{
		MerchantAccount m = mad.loadMerchant("Test");
		System.out.println(m.getUuid());
		System.out.println(m.getStatus());
		System.out.println(m.getUname());
		System.out.println(m.getPsd());
		System.out.println(m.getCreDt());
		System.out.println(m.getLastModDt());
	}
	
	@Test
	public void testLoadById()
	{
		MerchantAccount m = mad.loadMerchant(1);
		System.out.println(m.getUuid());
		System.out.println(m.getStatus());
		System.out.println(m.getUname());
		System.out.println(m.getPsd());
		System.out.println(m.getCreDt());
		System.out.println(m.getLastModDt());
	}
	
	@Test
	public void testAdd()
	{
		MerchantAccount m = new MerchantAccount();
		m.setStatus(1);
		m.setUname("Test");
		m.setPsd("Test");
		m.setCreDt(new java.util.Date());
		m.setLastModDt(new java.util.Date());
		mad.addMerchant(m);
	}
	
	@Test
	public void testUpdate()
	{
		MerchantAccount m = mad.loadMerchant(1);
		m.setStatus(0);
		m.setUname("Test Update");
		m.setPsd("Test Update");
		m.setCreDt(new java.util.Date());
		m.setLastModDt(new java.util.Date());
		mad.updateMerchant(m);
	}
	
	@Test
	public void testFindAllMerchants() {
		List<MerchantAccount> ms = mad.findAllMerchants(0);
		Assert.assertTrue(!ms.isEmpty());
		
		System.out.println("Accepted merchants:");
		for (MerchantAccount m: ms) {
			System.out.println(m.getUuid()+"..."+m.getStatus()+"..."+m.getUname()+"..."+m.getPsd()+"..."+m.getCreDt()+"..."+m.getLastModDt());
		}
		
		List<MerchantAccount> ms1 = mad.findAllMerchants(1);
		Assert.assertTrue(!ms1.isEmpty());
		
		System.out.println("Pending merchants:");
		for (MerchantAccount m: ms1) {
			System.out.println(m.getUuid()+"..."+m.getStatus()+"..."+m.getUname()+"..."+m.getPsd()+"..."+m.getCreDt()+"..."+m.getLastModDt());
		}
	}
}
