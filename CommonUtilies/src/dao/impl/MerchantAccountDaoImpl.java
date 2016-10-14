package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MerchantAccountDao;
import po.MerchantAccount;
import util.DBUtil;

public class MerchantAccountDaoImpl implements MerchantAccountDao {

	@Override
	public boolean addMerchant(MerchantAccount m) {
		String sql = "insert into merch_account(account_uuid,status,user_name,password,created_dt_gmt,last_modified_dt_gmt) values (merchant_acc_seq1.nextval,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement pst = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, m.getStatus());
			pst.setString(2, m.getUname());
			pst.setString(3, m.getPsd());
			pst.setDate(4, new java.sql.Date(m.getCreDt().getTime()));
			pst.setDate(5, new java.sql.Date(m.getLastModDt().getTime()));
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.free(con, pst, null);
		}
	}

	@Override
	public boolean updateMerchant(MerchantAccount m) {
		String sql = "update merch_account set status=?, user_name=?, password=?, created_dt_gmt=?, last_modified_dt_gmt=? where account_uuid=?";
		Connection con = null;
		PreparedStatement pst = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, m.getStatus());
			pst.setString(2, m.getUname());
			pst.setString(3, m.getPsd());
			pst.setDate(4, new java.sql.Date(m.getCreDt().getTime()));
			pst.setDate(5, new java.sql.Date(m.getLastModDt().getTime()));
			pst.setLong(6, m.getUuid());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.free(con, pst, null);
		}
	}

	@Override
		List<MerchantAccount> ms = new ArrayList<MerchantAccount>();
		
		String sql = "select account_uuid, status, user_name un, password psd, created_dt_gmt cre_dt, last_modified_dt_gmt last_mod_dt from merch_account where status=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, status);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				MerchantAccount m = new MerchantAccount();
				
				m.setUuid(rs.getLong("account_uuid"));
				m.setStatus(rs.getInt("status"));
				m.setUname(rs.getString("un"));
				m.setPsd(rs.getString("psd"));
				m.setCreDt(rs.getDate("cre_dt"));
				m.setCreDt(rs.getDate("last_mod_dt"));
				
				ms.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, null);
		}
		
		return ms;
	}
	
	public List<MerchantAccount> findMerchantsByStatus(int status) {
		List<MerchantAccount> ms = new ArrayList<MerchantAccount>();
		
		String sql = "select uuid, status, user_name un, password psd, created_dt_gmt cre_dt, last_modified_dt_gmt last_mod_dt from merch_account where status=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1,status);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				MerchantAccount m = new MerchantAccount();
				
				m.setUuid(rs.getLong("uuid"));
				m.setStatus(rs.getInt("status"));
				m.setUname(rs.getString("un"));
				m.setPsd(rs.getString("psd"));
				m.setCreDt(rs.getDate("cre_dt"));
				m.setCreDt(rs.getDate("last_mod_dt"));
				
				ms.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, null);
		}
		
		return ms;
	}

	@Override
	public MerchantAccount loadMerchant(String userName) {
		MerchantAccount m = null;
		String sql = "select uuid, status, user_name un, password psd, created_dt_gmt cre_dt, last_modified_dt_gmt last_mod_dt from merch_account where user_name=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				m = new MerchantAccount();
				
				m.setUuid(rs.getLong("uuid"));
				m.setStatus(rs.getInt("status"));
				m.setUname(rs.getString("un"));
				m.setPsd(rs.getString("psd"));
				m.setCreDt(rs.getDate("cre_dt"));
				m.setCreDt(rs.getDate("last_mod_dt"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, null);
		}
		
		return m;
	}
	
	public MerchantAccount loadMerchant(long uuid) {
		MerchantAccount m = null;
		String sql = "select account_uuid, status, user_name un, password psd, created_dt_gmt cre_dt, last_modified_dt_gmt last_mod_dt from merch_account where account_uuid=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setLong(1, uuid);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				m = new MerchantAccount();
				
				m.setUuid(rs.getLong("account_uuid"));
				m.setStatus(rs.getInt("status"));
				m.setUname(rs.getString("un"));
				m.setPsd(rs.getString("psd"));
				m.setCreDt(rs.getDate("cre_dt"));
				m.setCreDt(rs.getDate("last_mod_dt"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, null);
		}
		
		return m;
	}

}
