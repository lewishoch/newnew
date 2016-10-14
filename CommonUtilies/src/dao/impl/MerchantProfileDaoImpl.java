package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import dao.MerchantProfileDao;
import po.MerchantProfile;
import util.DBUtil;

public class MerchantProfileDaoImpl implements MerchantProfileDao {
	
	public boolean addMerchantProfile(MerchantProfile mp) {
		String sql = "insert into merchant_profile(merchant_uuid, merch_name, merch_age, merch_gender, shop_name, shop_addr, shop_tel_no, shop_logo_path, created_dt_gmt, last_modified_dt_gmt, account_uuid) values (merchant_profile_seq1.nextval,?,?,?,?,?,?,?,?,?,?)";
		
		Connection con = null;
		PreparedStatement pst = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, mp.getmName());
			pst.setInt(2, mp.getmAge());
			pst.setString(3, mp.getmGender());
			pst.setString(4, mp.getsName());
			pst.setString(5, mp.getsAddr());
			pst.setString(6, mp.getsTel());
			pst.setString(7, mp.getsLogoPath());
			pst.setDate(8, new java.sql.Date(mp.getCreDt().getTime()));
			pst.setDate(9, new java.sql.Date(mp.getLastModDt().getTime()));
			pst.setLong(10, mp.getmAccountUuid());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.free(con, pst, null);
		}
	}

	public boolean updateMerchantProfile(MerchantProfile mp) {
		String sql = "update merchant_profile set merch_name=?, merch_age=?, merch_gender=?, shop_name=?, shop_addr=?, shop_tel_no=?, shop_logo_path=?, created_dt_gmt=?, last_modified_dt_gmt=?, account_uuid=? where merchant_uuid=?";
		Connection con = null;
		PreparedStatement pst = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, mp.getmName());
			pst.setInt(2, mp.getmAge());
			pst.setString(3, mp.getmGender());
			pst.setString(4, mp.getsName());
			pst.setString(5, mp.getsAddr());
			pst.setString(6, mp.getsTel());
			pst.setString(7, mp.getsLogoPath());
			pst.setDate(8, new java.sql.Date(mp.getCreDt().getTime()));
			pst.setDate(9, new java.sql.Date(mp.getLastModDt().getTime()));
			pst.setLong(10, mp.getmAccountUuid());
			pst.setLong(11, mp.getUuid());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.free(con, pst, null);
		}
	}

	public MerchantProfile loadMerchantProfile(String merchantName) {
		MerchantProfile mp = null;
		String sql = "select merchant_uuid, merch_name, merch_age, merch_gender, shop_name, shop_addr, shop_tel_no, shop_logo_path, created_dt_gmt cre_dt, last_modified_dt_gmt last_mod_dt, account_uuid from merchant_profile where merch_name=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, merchantName);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				mp = new MerchantProfile();
				
				mp.setUuid(rs.getLong("merchant_uuid"));
				mp.setmName(rs.getString("merch_name"));
				mp.setmAge(rs.getInt("merch_age"));
				mp.setmGender(rs.getString("merch_gender"));
				mp.setsName(rs.getString("shop_name"));
				mp.setsAddr(rs.getString("shop_addr"));
				mp.setsTel(rs.getString("shop_tel_no"));
				mp.setsLogoPath(rs.getString("shop_logo_path"));
				mp.setCreDt(new Date(rs.getTimestamp("cre_dt").getTime()));
				mp.setLastModDt(new Date(rs.getTimestamp("last_mod_dt").getTime()));
				mp.setmAccountUuid(rs.getLong("account_uuid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, null);
		}
		
		return mp;
	}

	public MerchantProfile loadMerchantProfile(long uuid) {
		MerchantProfile mp = null;
		String sql = "select merchant_uuid, merch_name, merch_age, merch_gender, shop_name, shop_addr, shop_tel_no, shop_logo_path, created_dt_gmt cre_dt, last_modified_dt_gmt last_mod_dt, account_uuid from merchant_profile where merchant_uuid=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setLong(1, uuid);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				mp = new MerchantProfile();
				
				mp.setUuid(rs.getLong("merchant_uuid"));
				mp.setmName(rs.getString("merch_name"));
				mp.setmAge(rs.getInt("merch_age"));
				mp.setmGender(rs.getString("merch_gender"));
				mp.setsName(rs.getString("shop_name"));
				mp.setsAddr(rs.getString("shop_addr"));
				mp.setsTel(rs.getString("shop_tel_no"));
				mp.setsLogoPath(rs.getString("shop_logo_path"));
				mp.setCreDt(new Date(rs.getTimestamp("cre_dt").getTime()));
				mp.setLastModDt(new Date(rs.getTimestamp("last_mod_dt").getTime()));
				mp.setmAccountUuid(rs.getLong("account_uuid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, null);
		}
		
		return mp;
	}

}
