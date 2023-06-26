package dao;

import java.sql.*;

import bean.Order;

public class OrderDAO {
	private static final String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/uniformdb";
	private static final String USER = "root";
	private static final String PASSWD = "root123";

	private static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(RDB_DRIVE);
			con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public void insert(Order order) {
		Connection con = null;
		Statement smt = null;
		try {
			con = getConnection();
			smt = con.createStatement();

			String sql = "INSERT INTO orderinfo VALUES(NULL, '" + order.getuniform_id() + "', CURDATE(), '"
					+ order.getusername() + "', '" + order.getaddress() + "', '\" + order.getuser_mail() + \"', '\" + order.getquantity() + \"', '\" + order.gettotal_price() + \"', '\" + NULL + \"', '\" + NULL \"')";
			smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
	}

}