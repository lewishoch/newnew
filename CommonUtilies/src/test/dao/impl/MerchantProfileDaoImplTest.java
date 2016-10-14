package test.dao.impl;

import org.junit.Test;

import po.MerchantProfile;
import dao.MerchantProfileDao;
import dao.impl.MerchantProfileDaoImpl;

public class MerchantProfileDaoImplTest {
	private MerchantProfileDao mpd = new MerchantProfileDaoImpl();
	
	@Test
	public void testLoadByName()
	{
		MerchantProfile mp = mpd.loadMerchantProfile("Test");
		System.out.println(mp.getUuid());
		System.out.println(mp.getmName());
		System.out.println(mp.getmAge());
		System.out.println(mp.getmGender());
		System.out.println(mp.getsName());
		System.out.println(mp.getsAddr());
		System.out.println(mp.getsTel());
		System.out.println(mp.getsLogoPath());
		System.out.println(mp.getCreDt());
		System.out.println(mp.getLastModDt());
		System.out.println(mp.getmAccountUuid());
	}
	
	@Test
	public void testLoadById()
	{
		MerchantProfile mp = mpd.loadMerchantProfile(7);
		System.out.println(mp.getUuid());
		System.out.println(mp.getmName());
		System.out.println(mp.getmAge());
		System.out.println(mp.getmGender());
		System.out.println(mp.getsName());
		System.out.println(mp.getsAddr());
		System.out.println(mp.getsTel());
		System.out.println(mp.getsLogoPath());
		System.out.println(mp.getCreDt());
		System.out.println(mp.getLastModDt());
		System.out.println(mp.getmAccountUuid());
	}
	
	@Test
	public void testAdd()
	{
		MerchantProfile mp = new MerchantProfile();
		mp.setmName("Test1");
		mp.setmAge(30);
		mp.setmGender("M");
		mp.setsName("Shop Name Test");
		mp.setsAddr("Shop Addr Test");
		mp.setsTel("22222222");
		mp.setsLogoPath("Shop Logo Path Test");
		mp.setCreDt(new java.util.Date());
		mp.setLastModDt(new java.util.Date());
		mp.setmAccountUuid(7);
		mpd.addMerchantProfile(mp);
	}
	
	@Test
	public void testUpdate()
	{
		MerchantProfile mp = mpd.loadMerchantProfile(7);
		mp.setmName("Test Update");
		mp.setmAge(15);
		mp.setmGender("F");
		mp.setsName("Shop Name Test Update");
		mp.setsAddr("Shop Addr Test Update");
		mp.setsTel("22222222");
		mp.setsLogoPath("Shop Logo Path Test Update");
		mp.setCreDt(new java.util.Date());
		mp.setLastModDt(new java.util.Date());
		mp.setmAccountUuid(6);
		mpd.updateMerchantProfile(mp);
	}
}
