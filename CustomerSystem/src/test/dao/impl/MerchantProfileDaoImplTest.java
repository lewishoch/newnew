package test.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import po.Merchant;
import po.MerchantProfile;
import dao.MerchantProfileDao;
import dao.impl.MerchantProfileDaoImpl;

public class MerchantProfileDaoImplTest {

	private MerchantProfileDao mpd = new MerchantProfileDaoImpl();
	Date date = new Date();
	@Test
	public void testAddMerchantProfile() {
		Merchant m = new Merchant();
		
		m.setUname("john");
		m.setStatus(0);
		m.setPsd("1234");
		m.setCreDt(date);
		m.setLastModDt(date);
	}

	@Test
	public void testUpdateMerchant() {
		MerchantProfile mp = mpd.loadMerchantProfile(3);
		
		mp.setmName("kfg");
		mp.setmAge(50);
		mp.setmGender("F");
		mp.setsAddr("testTestAddr");
		mp.setsTel("13579");
		mp.setLastModDt(date);
		mpd.updateMerchant(mp);
		MerchantProfile mp1 = mpd.loadMerchantProfile(3);
		System.out.println(mp.getmName());
		System.out.println(mp1.getmName());
		Assert.assertTrue(mp1.getmName().equals("kfg"));
		
	}

	@Test
	public void testLoadMerchantProfile() {
		MerchantProfile m1 = mpd.loadMerchantProfile("kfc001");
		MerchantProfile m2 = mpd.loadMerchantProfile("MDS002");
		Assert.assertTrue(m1!=null);
		Assert.assertTrue(m2==null);
	}

	@Test
	public void testLoadMerchantProfile1() {
		MerchantProfile m1 = mpd.loadMerchantProfile(3);
		MerchantProfile m2 = mpd.loadMerchantProfile(6);
		Assert.assertTrue(m1!=null);
		Assert.assertTrue(m2==null);
	}

	@Test
	public void testLoadAllMerchantProfile() {
		List<MerchantProfile> m = mpd.loadAllMerchantProfile(0);
		Assert.assertTrue(!m.isEmpty());
		
		for (MerchantProfile mp: m){
			System.out.println(mp.getmAccountUuid()+".."+mp.getmName()+".."+mp.getmAge()+".."+mp.getmGender());
			System.out.println(mp.getsName()+".."+mp.getsTel()+".."+mp.getsAddr()+"..");
		}
	
	}
}
