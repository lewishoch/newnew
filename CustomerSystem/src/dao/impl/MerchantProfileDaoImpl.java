package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MerchantProfileDao;
import po.MerchantProfile;
import util.DBUtil;

public class MerchantProfileDaoImpl implements MerchantProfileDao {

	
	public boolean addMerchantProfile(MerchantProfile mp) {
		String sql = "insert into merchant_profile(merchant_uuid,merch_name,merch_age,merch_gender,shop_name,shop_addr,shop_tel_no,shop_logo_path,created_dt_gmt,last_modified_dt_gmt,account_uuid) values (merchant_profile_seq.nextval,?,?,?,?,?,?,?,?,?,?)";
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
			return false;
		} finally {
			DBUtil.free(con, pst, null);
		}
	}

	
	public boolean updateMerchant(MerchantProfile mp) {
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
			pst.setDate(8, (Date) mp.getCreDt());
			pst.setDate(9, new java.sql.Date(mp.getLastModDt().getTime()));
			pst.setLong(10, mp.getmAccountUuid());
			pst.setLong(11, mp.getUuid());
			
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		} finally {
			DBUtil.free(con, pst, null);
		}
	}

	
	public MerchantProfile loadMerchantProfile(String shopName) {
		MerchantProfile mp = null;
		String sql = "select merchant_uuid, merch_name, merch_age, merch_gender, shop_name, shop_addr, shop_tel_no, shop_logo_path, created_dt_gmt cre_dt, last_modified_dt_gmt last_mod_dt, account_uuid from merchant_profile where shop_name=?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, shopName);
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
				//mp.setsLogoPath(rs.getString("shop_logo_path"));
				//mp.setCreDt(rs.getDate("cre_dt"));
				//mp.setCreDt(rs.getDate("last_mod_dt"));
				//mp.setmAccountUuid(rs.getLong("account_uuid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, rs);
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
				mp.setCreDt(rs.getDate("cre_dt"));
				mp.setCreDt(rs.getDate("last_mod_dt"));
				mp.setmAccountUuid(rs.getLong("account_uuid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, rs);
		}
		
		return mp;
	}


	public List<MerchantProfile> loadAllMerchantProfile(int status) {
		List<MerchantProfile> mp = new ArrayList<MerchantProfile>();
		String sql = "select merchant_uuid, merch_name, merch_age, merch_gender, shop_name, shop_addr, shop_tel_no from merchant_profile mp, merch_account ma where mp.account_uuid = ma.account_uuid AND ma.status=0";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = DBUtil.createConnection();
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				MerchantProfile m = new MerchantProfile();
				
				m.setUuid(rs.getLong("merchant_uuid"));
				m.setmName(rs.getString("merch_name"));
				m.setmAge(rs.getInt("merch_age"));
				m.setmGender(rs.getString("merch_gender"));
				m.setsName(rs.getString("shop_name"));
				m.setsAddr(rs.getString("shop_addr"));
				m.setsTel(rs.getString("shop_tel_no"));
				//mp.setsLogoPath(rs.getString("shop_logo_path"));
				//mp.setCreDt(rs.getDate("cre_dt"));
				//mp.setCreDt(rs.getDate("last_mod_dt"));
				//mp.setmAccountUuid(rs.getLong("account_uuid"));
				mp.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(con, pst, rs);
		
		}
		return mp;
	}
	
	

	

}
