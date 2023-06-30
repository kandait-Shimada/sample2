package dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import bean.Uniform;

public class UniformDAO {

	// DB接続準備
	private static final String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/uniformdb";
	private static final String USER = "root";
	private static final String PASSWD = "root123";

	// DB接続
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

	// 以下全データを取得する

	public ArrayList<Uniform> selectAll() {
		Connection con = null;
		Statement smt = null;
		ArrayList<Uniform> uniformList = new ArrayList<Uniform>();

		try {
			con = getConnection();
			smt = con.createStatement();

			String sql = "SELECT * FROM uniforminfo ORDER BY uniform_id";
			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				Uniform uniform = new Uniform();
				uniform.setUniformid(rs.getInt("uniform_id"));
				uniform.setUniform_name(rs.getString("uniform_name"));
				uniform.setStock(rs.getInt("stock"));
				uniform.setPrice(rs.getInt("price"));
				uniformList.add(uniform);
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
		return uniformList;
	}
// 選択したデータの取得

	public Uniform selectByUniformid(int _uniform_id) {
		Uniform uniform = new Uniform();
		Connection con = null;
		Statement smt = null;
		try {
			con = getConnection();
			smt = con.createStatement();
			String sql = "SELECT * FROM uniforminfo WHERE uniform_id='" + _uniform_id + "'";
			ResultSet rs = smt.executeQuery(sql);

			if (rs.next()) {
				uniform.setUniformid(rs.getInt("uniform_id"));
				uniform.setUniform_name(rs.getString("uniform_name"));
				uniform.setStock(rs.getInt("stock"));
				uniform.setPrice(rs.getInt("price"));
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
		return uniform;
	}

// データを削除する

	public void delete(int _uniform_id) {
		Connection con = null;
		Statement smt = null;
		try {
			con = getConnection();
			smt = con.createStatement();
			String sql = "DELETE FROM uniforminfo WHERE uniform_id='" + _uniform_id + "'";
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
