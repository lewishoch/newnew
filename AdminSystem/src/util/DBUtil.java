package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	
	private final static String userName="oocl_user14";
	private final static String psd="oocl123";
	private final static String db_url="jdbc:oracle:thin:@hkln456p.oocl.com:1521/testdb.oocl";
	private final static String driver_classname="oracle.jdbc.OracleDriver";
	private static BasicDataSource ds;
	static {
		ds = new BasicDataSource();
		
		//ds.setMaxActive(2);
		ds.setUrl(db_url);
		ds.setDriverClassName(driver_classname);
		ds.setUsername(userName);
		ds.setPassword(psd);
	}
	
	public static Connection createConnection() {
		Connection con = null;
		
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void free(Connection con, PreparedStatement pst, ResultSet rs) {
		try {
			// Close from small to big
			if (rs != null) // Not all cases need all components
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
