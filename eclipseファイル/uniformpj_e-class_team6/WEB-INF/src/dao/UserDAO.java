/*
 * プログラム名：ユニフォーム受注管理システム
 * プログラムの説明：DBアクセスを行うDAOクラス
 * 作成者：嶋田清春
 * 作成日付：2023/06/22
 * 変数の説明：user User情報を格納する箱
 */

package dao;

import java.sql.*;
import bean.User;

public class UserDAO {
	// JDBCドライバ内部のDriverクラスパス
			private static final String RDB_DRIVE = "com.mysql.jdbc.Driver";

			// 接続するMySQLデータベースパス
			private static final String URL = "jdbc:mysql://localhost/uniformdb";

			// データベースのユーザー名
			private static final String USER = "root";

			// データベースのパスワード
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

			public User selectByUser(int managerLogin_id, String manager_password) {
				Connection con = null;
				Statement smt = null;
				User user = new User();

				try {
					con = getConnection();
					smt = con.createStatement();

					String sql = "SELECT * FROM logininfo WHERE managerLogin_id='" + managerLogin_id
							+ "' AND manager_password='" + manager_password + "'";

					ResultSet rs = smt.executeQuery(sql);

					if (rs.next()) {
						user.setManagerLogin_id(rs.getInt("user"));
						user.setManager_password(rs.getString("password"));
						user.setManagere_mail(rs.getString("email"));
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

				return user;
			}
}
