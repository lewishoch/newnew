package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.DishDao;
import po.Dish;
import util.DBUtil;

public class DishDaoImpl implements DishDao {

	public Dish loadDish(long dishUuid) {
		Dish dish = null;
		
		String sql = "SELECT DISH_ID, DISH_NAME, DISH_FOLDER_PATH, CREATED_DT_GMT, LAST_MODIFIED_DT_GMT, MERCHANT_UUID FROM DISH WHERE DISH_ID = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = DBUtil.createConnection();
		
		try {
			pst = con.prepareStatement(sql);
			pst.setLong(1,dishUuid);
			rs = pst.executeQuery();
			
			if(rs.next()) 
			{
				dish = new Dish();
				dish.setDishId(rs.getLong("DISH_ID"));
				dish.setDishName(rs.getString("DISH_NAME"));
				dish.setDishFolderPath(rs.getString("DISH_FOLDER_PATH"));
				dish.setCreatedDtGmt(new Date(rs.getTimestamp("CREATED_DT_GMT").getTime()));
				dish.setLastModifiedDtGmt(new Date(rs.getTimestamp("LAST_MODIFIED_DT_GMT").getTime()));
				dish.setMerchantUuid(rs.getLong("MERCHANT_UUID"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		
		return dish;
	}
	
	public Dish loadDish(String dishName, long merchantId) {
		Dish dish = null;
		
		String sql = "SELECT DISH_ID, DISH_NAME, DISH_FOLDER_PATH, CREATED_DT_GMT, LAST_MODIFIED_DT_GMT, MERCHANT_UUID FROM DISH WHERE MERCHANT_UUID = ? AND DISH_NAME = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = DBUtil.createConnection();
		
		try {
			pst = con.prepareStatement(sql);
			pst.setLong(1,merchantId);
			pst.setString(2,dishName);
			rs = pst.executeQuery();
			
			if(rs.next()) 
			{
				dish = new Dish();
				dish.setDishId(rs.getLong("DISH_ID"));
				dish.setDishName(rs.getString("DISH_NAME"));
				dish.setDishFolderPath(rs.getString("DISH_FOLDER_PATH"));
				dish.setCreatedDtGmt(new Date(rs.getTimestamp("CREATED_DT_GMT").getTime()));
				dish.setLastModifiedDtGmt(new Date(rs.getTimestamp("LAST_MODIFIED_DT_GMT").getTime()));
				dish.setMerchantUuid(rs.getLong("MERCHANT_UUID"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		
		return dish;
	}

	public boolean addDish(Dish dish) {
		
		String sql = "INSERT INTO DISH(DISH_ID, DISH_NAME, DISH_FOLDER_PATH, CREATED_DT_GMT, LAST_MODIFIED_DT_GMT, MERCHANT_UUID) values(dish_seq1.nextval,?,?,systimestamp,systimestamp,?)";
		Connection con = null;
		PreparedStatement pst = null;
		con = DBUtil.createConnection();
		
		try {
			pst = con.prepareStatement(sql);
	
			pst.setString(1, dish.getDishName());
			pst.setString(2, dish.getDishFolderPath());
			pst.setLong(3, dish.getMerchantUuid());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally{
			DBUtil.free(con, pst, null);
			
		}
		return true;
	}
	
	public boolean updateDish(Dish dish) {
		String sql = "UPDATE DISH SET DISH_NAME = ?, DISH_FOLDER_PATH = ?, LAST_MODIFIED_DT_GMT = systimestamp, MERCHANT_UUID = ? WHERE DISH_ID = ?";
		Connection con = null;
		PreparedStatement pst = null;
		con = DBUtil.createConnection();
		
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, dish.getDishName());
			pst.setString(2, dish.getDishFolderPath());
			pst.setLong(3, dish.getMerchantUuid());
			pst.setLong(4, dish.getDishId());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally{
			DBUtil.free(con, pst, null);
		}
		return true;
		
	}

	public boolean deleteDish(long dishUuid) {
		String sql = "DELETE FROM DISH WHERE DISH_ID = ?";
		Connection con = null;
		PreparedStatement pst = null;
		con = DBUtil.createConnection();
		
		
		try {
			pst = con.prepareStatement(sql);
			pst.setLong(1, dishUuid);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally{
			DBUtil.free(con, pst, null);
		}
		return true;
	}

	public List<Dish> findAllDishes() {
		List<Dish> dishes = new ArrayList<Dish>();
		
		String sql = "SELECT DISH_ID, DISH_NAME, DISH_FOLDER_PATH, CREATED_DT_GMT, LAST_MODIFIED_DT_GMT, MERCHANT_UUID FROM DISH";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = DBUtil.createConnection();
		
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				Dish dish = new Dish();
				dish.setDishId(rs.getLong("DISH_ID"));
				dish.setDishName(rs.getString("DISH_NAME"));
				dish.setDishFolderPath(rs.getString("DISH_FOLDER_PATH"));
				dish.setCreatedDtGmt(new Date(rs.getTimestamp("CREATED_DT_GMT").getTime()));
				dish.setLastModifiedDtGmt(new Date(rs.getTimestamp("LAST_MODIFIED_DT_GMT").getTime()));
				dish.setMerchantUuid(rs.getLong("MERCHANT_UUID"));
				dishes.add(dish);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		
		return dishes;
	}

	public List<Dish> findDishesByMerchantUuid(long merchantUuid) {
		List<Dish> dishes = new ArrayList<Dish>();
		
		String sql = "SELECT DISH_ID, DISH_NAME, DISH_FOLDER_PATH, CREATED_DT_GMT, LAST_MODIFIED_DT_GMT, MERCHANT_UUID FROM DISH WHERE MERCHANT_UUID = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = DBUtil.createConnection();
		
		try {
			pst = con.prepareStatement(sql);
			pst.setLong(1, merchantUuid);
			rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				Dish dish = new Dish();
				dish.setDishId(rs.getLong("DISH_ID"));
				dish.setDishName(rs.getString("DISH_NAME"));
				dish.setDishFolderPath(rs.getString("DISH_FOLDER_PATH"));
				dish.setCreatedDtGmt(new Date(rs.getTimestamp("CREATED_DT_GMT").getTime()));
				dish.setLastModifiedDtGmt(new Date(rs.getTimestamp("LAST_MODIFIED_DT_GMT").getTime()));
				dish.setMerchantUuid(rs.getLong("MERCHANT_UUID"));
				dishes.add(dish);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtil.free(con, pst, rs);
		}
		
		return dishes;
	}
}
