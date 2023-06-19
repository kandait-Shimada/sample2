package jp.co.f1.jdbc.test;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {

	// DB情報 MySQL
	private final static String RDB_DRIVE = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost/testdb";
	private final static String USER = "root";
	private final static String PASSWD = "root123";

	// DBと接続する為のgetConnectionメソッド
	private Connection getConnection() {
		try {
			Class.forName(RDB_DRIVE);
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);

			return con;
			// 例外処理
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public ArrayList<Student> selectAll() {
		// SQL文
		String sql = "SELECT * FROM students ORDER BY id";

		// 配列宣言
		ArrayList<Student> list = new ArrayList<Student>();

		// 変数宣言
		Connection con = null;
		Statement smt = null;

		try {
			// DB接続
			con = getConnection();
			smt = con.createStatement();

			// SQLをDBへ発行
			ResultSet rs = smt.executeQuery(sql);

			// 取得した結果を配列にBooksオブジェクトで格納する
			while (rs.next()) {
				Student student = new Student();
				student.setSid(rs.getInt("sid"));
				student.setName(rs.getString("name"));
				student.setId(rs.getInt("id"));
				student.setScore(rs.getInt("score"));

				list.add(student);
			}

			return list;

		} catch (Exception e) {
			throw new IllegalStateException("selectAll " + e);

		} finally {
			// リソースの開放
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

	// 生徒を追加するinsertメソッド
	public int insert(Student objStu) {

		// SQL文の宣言
		String sql = "insert into students VALUES('" + objStu.getSid() + "','" + objStu.getName() + "','"
				+ objStu.getId() + "', '" + objStu.getScore() + "')";

		// 変数宣言
		Connection con = null;
		Statement smt = null;
		int count = 0;

		try {
			// DB接続
			con = getConnection();
			smt = con.createStatement();

			// SQLをDBへ発行
			count = smt.executeUpdate(sql);

			// 例外処理
		} catch (Exception e) {
			throw new IllegalStateException("insert " + e);

		} finally {
			// リソースの開放
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
		// 追加した件数を戻り値として返す
		return count;
	}

	// 生徒を削除するdeleteメソッド
	public int delete(int id) {

		// SQL文
		String sql = "DELETE FROM students WHERE id = '" + id + "'";

		// 変数宣言
		Connection con = null;
		Statement smt = null;
		int count = 0;

		try {
			// DB接続
			con = getConnection();
			smt = con.createStatement();

			// SQLをDBへ発行
			count = smt.executeUpdate(sql);

			// 例外処理
		} catch (Exception e) {
			throw new IllegalStateException("delete " + e);

		} finally {
			// リソースの開放
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
		// 削除した件数を戻り値として返す
		return count;
	}

}
