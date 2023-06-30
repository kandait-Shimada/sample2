package dao;

import java.sql.*;
import java.util.ArrayList;

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

	public ArrayList<Order> selectAll() {
		Connection con = null;
		Statement smt = null;

		ArrayList<Order> order_list = new ArrayList<Order>();

		try {
			con = getConnection();
			smt = con.createStatement();

			String sql =  "SELECT * FROM purchaseinfo ORDER BY purchase_info";
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				Order order = new Order();
				order.setpurchase_id(rs.getInt("purchase_id"));
				order.setuniform_id(rs.getInt("uniform_id"));
				order.setpurchase_day(rs.getString("purchase_day"));
				order.setusername(rs.getString("username"));
				order.setaddress(rs.getString("address"));
				order.setuser_mail(rs.getString("user_mail"));
				order.setquantitiy(rs.getInt("quantitiy"));
				order.setTotal_price(rs.getInt("total_price"));
				order.setpaymentStatus(rs.getString("paymentStatus"));
				order.setsendingStatus(rs.getString("sendingStatus"));
				order.setcomment(rs.getString("comment"));

				order_list.add(order);
			}

			return order_list;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {

				}
			}
		}
	}

	public void insert(Order order) {
		Connection con = null;
		Statement smt = null;
		try {
			con = getConnection();
			smt = con.createStatement();

			String sql = "INSERT INTO orderinfo VALUES(NULL,'"
					+ order.getuniform_id() + "','" + order.getUniform_name() + "','"
					+ order.getquantitiy() +"','"
					+order.getTotal_price()+ "',CURDATE())";

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