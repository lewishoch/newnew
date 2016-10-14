package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

import dao.AdminAccountDao;
import po.AdminAccount;
import util.DBUtil;

public class AdminAccountImpl implements AdminAccountDao {

	
	public AdminAccount loadAdmin(String accName) {
		AdminAccount adminAccount = null;
		
		String sql = "SELECT ACCOUNT_ID, USER_NAME, PASSWORD, CREATED_DT_GMT, LAST_MODIFIED_DT_GMT FROM ADMIN_ACCOUNT WHERE USER_NAME = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = DBUtil.createConnection();
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1,accName);
			rs = pst.executeQuery();
			
			if(rs.next()) 
			{
				adminAccount = new AdminAccount();
				adminAccount.setAccountUuid(rs.getLong("ACCOUNT_ID"));
				adminAccount.setUserName(rs.getString("USER_NAME"));
				adminAccount.setPassword(rs.getString("PASSWORD"));
				adminAccount.setCreatedDtGmt(new Date(rs.getTimestamp("CREATED_DT_GMT").getTime()));
				adminAccount.setLastModifiedDtGmt(new Date(rs.getTimestamp("LAST_MODIFIED_DT_GMT").getTime()));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		
		return adminAccount;
	}

}
