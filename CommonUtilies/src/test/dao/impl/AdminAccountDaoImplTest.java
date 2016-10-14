package test.dao.impl;

import org.junit.Test;

import dao.AdminAccountDao;
import dao.impl.AdminAccountImpl;
import po.AdminAccount;

public class AdminAccountDaoImplTest {
	private AdminAccountDao ud = new AdminAccountImpl();
	
	@Test
	public void testLoad()
	{
		AdminAccount ac = ud.loadAdmin("Test");
		System.out.println(ac.getCreatedDtGmt().getTime());
		System.out.println(ac.getLastModifiedDtGmt().getTime());
	}
}
