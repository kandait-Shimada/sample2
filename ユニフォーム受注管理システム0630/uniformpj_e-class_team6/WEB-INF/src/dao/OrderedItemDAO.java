/*
 * プログラム名：ユニフォーム受注管理システム
 * プログラムの説明：データベース関連の処理をまとめたクラスであり、
 * 　　　　　　　　　データベースから購入情報のデータ取得に
 * 　　　　　　　　　関する処理がまとめられている。
 * 作成者：松井　朱奈
 * 作成日付：2023/06/22
 */

package dao;

import java.sql.*;
import java.util.ArrayList;

import bean.OrderedItem;

public class OrderedItemDAO {
	/**
	 * JDBCドライバ内部のDriverクラスパス
	 */
	private static final String RDB_DRIVE = "com.mysql.jdbc.Driver";
	/**
	 * 接続するMySQLデータベースパス
	 */
	private static final String URL = "jdbc:mysql://localhost/uniformdb";
	/**
	 * データベースのユーザー名
	 */
	private static final String USER = "root";
	/**
	 * データベースのパスワード
	 */
	private static final String PASSWD = "root123";

	/**
	 * フィールド変数の情報を基に、DB接続をおこなうメソッド
	 *
	 * @return データベース接続情報]
	 * @throws IllegalStateException メソッド内部で例外が発生した場合
	 */
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

	/**
	 * DBのpurchaseinfoのテーブルから注文詳細情報を全件取得するメソッド
	 */
	public ArrayList<OrderedItem> selectAll() {
		Connection con = null;
		Statement smt = null;
		ArrayList<OrderedItem> ordered_list = new ArrayList<OrderedItem>();

		try {
			con = getConnection();
			smt = con.createStatement();

			String sql = "SELECT * FROM purchaseinfo ORDER BY purchase_id DESC";
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				OrderedItem orderedItem = new OrderedItem();
				orderedItem.setPurchase_id(rs.getInt("purchase_id"));
				orderedItem.setUniform_id(rs.getInt("uniform_id"));
				orderedItem.setPurchase_day(rs.getString("purchase_day"));
				orderedItem.setUsername(rs.getString("username"));
				orderedItem.setAddress(rs.getString("address"));
				orderedItem.setUser_mail(rs.getString("user_mail"));
				orderedItem.setQuantitiy(rs.getInt("quantitiy"));
				orderedItem.setTotal_price(rs.getInt("total_price"));
				orderedItem.setPaymentStatus(rs.getString("paymentStatus"));
				orderedItem.setSendingStatus(rs.getString("sendingStatus"));
				orderedItem.setComment(rs.getString("comment"));

				ordered_list.add(orderedItem);
			}

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
		return ordered_list;
	}

	public void paymentUpdate(OrderedItem _orderedItem) {
		Connection con = null;
		Statement smt = null;
		try {
			con = getConnection();
			smt = con.createStatement();
			String sql = "UPDATE purchaseinfo SET paymentStatus ='" + _orderedItem.getPaymentStatus()
					+ "' WHERE purchase_id ='" + _orderedItem.getPurchase_id() + "'";
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

	public void sendingUpdate(OrderedItem _orderedItem) {
		Connection con = null;
		Statement smt = null;
		try {
			con = getConnection();
			smt = con.createStatement();

			String sql = "UPDATE purchaseinfo SET sendingStatus ='" + _orderedItem.getSendingStatus()
					+ "' WHERE purchase_id ='" + _orderedItem.getPurchase_id() + "'";

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

	public OrderedItem selectByPurchase_id(String _purchase_id) {
		OrderedItem orderedItem = new OrderedItem();
		Connection con = null;
		Statement smt = null;
		try {
			con = getConnection();
			smt = con.createStatement();
			String sql = "SELECT * FROM  purchaseinfo WHERE purchase_id='" + _purchase_id + "'";
			ResultSet rs = smt.executeQuery(sql);

			if (rs.next()) {
				orderedItem.setPurchase_id(rs.getInt("purchase_id"));
				orderedItem.setUniform_id(rs.getInt("uniform_id"));
				orderedItem.setPurchase_day(rs.getString("purchase_day"));
				orderedItem.setUsername(rs.getString("username"));
				orderedItem.setAddress(rs.getString("address"));
				orderedItem.setUser_mail(rs.getString("user_mail"));
				orderedItem.setQuantitiy(rs.getInt("quantitiy"));
				orderedItem.setTotal_price(rs.getInt("total_price"));
				orderedItem.setPaymentStatus(rs.getString("paymentStatus"));
				orderedItem.setSendingStatus(rs.getString("sendingStatus"));
				orderedItem.setComment(rs.getString("comment"));
			}
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
		return orderedItem;
	}

	//注文履歴の更新
	public void INSERT(OrderedItem _orderedItem) {

		Connection con = null;
		Statement smt = null;

		try {

			//データベース接続
			con = getConnection();
			smt = con.createStatement();

			//INSERT文
			String sql = "INSERT INTO purchaseinfo (uniform_id,purchase_day,username,address,user_mail,quantitiy,total_price,paymentStatus,sendingStatus,comment) VALUES("
			+ _orderedItem.getUniform_id() + ",'"
			+ _orderedItem.getPurchase_day() + "','"
			+ _orderedItem.getUsername() + "','"
			+ _orderedItem.getAddress() + "','"
			+ _orderedItem.getUser_mail() + "',"
			+ _orderedItem.getQuantitiy() + ","
			+ _orderedItem.getTotal_price() + ",'"
			+ _orderedItem.getPaymentStatus() + "','"
			+ _orderedItem.getSendingStatus() + "','"
			+ _orderedItem.getComment() + "')";

			//SQL文の実行
			smt.executeUpdate(sql);

		//例外処理
		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			//クローズ処理
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
