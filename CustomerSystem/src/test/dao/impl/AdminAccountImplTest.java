package test.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.AdminAccountDao;
import dao.impl.AdminAccountDaoImpl;
import po.AdminAccount;

public class AdminAccountImplTest {

	private AdminAccountDao ud = new AdminAccountDaoImpl();
	
	@Test
	public void testLoad()
	{
		AdminAccount ac = ud.loadAdmin("Test");
		System.out.println(ac.getCreatedDtGmt().getTime());
		System.out.println(ac.getLastModifiedDtGmt().getTime());
	}

}
