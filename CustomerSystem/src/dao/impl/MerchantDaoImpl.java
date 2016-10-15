package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MerchantDao;
import po.Merchant;
import util.DBUtil;

public class MerchantDaoImpl implements MerchantDao {

	public boolean addMerchant(Merchant m) {
		String sql = "insert into merch_account(account_uuid,status,user_name,password,created_dt_gmt,last_modified_dt_gmt) values (merchant_seq.nextval,?,?,?,?,?)";
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
			return false;
		} finally {
			DBUtil.free(con, pst, null);
		}
	}

	
	public boolean updateMerchant(Merchant m) {
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
			return false;
		} finally {
			DBUtil.free(con, pst, null);
		}
	}


	public List<Merchant> findAllMerchants(int status) {
		List<Merchant> ms = new ArrayList<Merchant>();
		
		String sql = "select ACCOUNT_UUID, status, user_name un, password psd, created_dt_gmt cre_dt, last_modified_dt_gmt last_mod_dt from merch_account";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Merchant m = new Merchant();
				
				m.setUuid(rs.getLong("ACCOUNT_UUID"));
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
			DBUtil.free(con, pst, rs);
		}
		
		return ms;
	}
	


	public Merchant loadMerchant(String userName) {
		Merchant m = null;
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
				m = new Merchant();
				
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
	
	public Merchant loadMerchant(long uuid) {
		Merchant m = null;
		String sql = "select uuid, status, user_name un, password psd, created_dt_gmt cre_dt, last_modified_dt_gmt last_mod_dt from merch_account where uuid=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setLong(1, uuid);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				m = new Merchant();
				
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


	public List<Merchant> findAllArpprovedMerchants(int status) {
		// TODO Auto-generated method stub
		return null;
	}

}
