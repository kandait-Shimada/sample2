/*
 * プログラム名：ユニフォーム受注管理システム
 * プログラムの説明：ログイン情報を確認し各画面に遷移するシステム
 * 作成者：藤巻健太郎
 * 作成日付：2023/06/23
 */

package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import dao.*;
import bean.*;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 例外処理用の変数宣言
		String error = "";
		String cmd = "";

		try {
			// パラメーター取得
			String str_managerLogin_id = request.getParameter("user");
			String manager_password = request.getParameter("password");

			// UserDAOクラスオブジェクト生成
			UserDAO UserDao = new UserDAO();

			// String型のstr_managerLogin_idをint型に変換するための変数
			int managerLogin_id;

			try {
				// String型のstr_managerLogin_idをint型のmanagerLogin_idに変換
				managerLogin_id = Integer.parseInt(str_managerLogin_id);

				// 入力された値が文字列だったらエラー
			} catch (NumberFormatException e) {
				error = "ユーザー名が不正の為、ログイン出来ませんでした。";
				cmd = "login";
				return;
			}

			// Userオブジェクトを生成し、引数のデータを参照して全データを検索、格納
			User User = UserDao.selectByUser(managerLogin_id, manager_password);

			//login.jspで入力したuserのチェック
			if (User.getManagerLogin_id() != managerLogin_id || !(User.getManager_password().equals(manager_password))) {
				error = "入力データが間違っています。";
				cmd = "login";
				return;
			}

			// sessionオブジェクト生成
			HttpSession session = request.getSession();

			// セッションスコープに登録
			session.setAttribute("User", User);

			// userクッキーオブジェクト生成()
			Cookie userCookie = new Cookie("user", Integer.valueOf(User.getManagerLogin_id()).toString());
			// 保存期間を5日間に設定
			userCookie.setMaxAge(60 * 60 * 24 * 5);
			response.addCookie(userCookie);

			// passwordクッキーオブジェクト生成
			Cookie passCookie = new Cookie("password", User.getManager_password());
			passCookie.setMaxAge(60 * 60 * 24 * 5);
			response.addCookie(passCookie);
			// userとpasswordをクッキーに登録

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、ログインは出来ません。";
			cmd = "logout";
			// DBに接続できるかチェック
		} finally {
			if (error.equals("")) {
				request.getRequestDispatcher("/view/managerMenu.jsp").forward(request, response);
				// エラーが無い場合、menu.jspに遷移
			} else {
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				if (cmd.equals("login")) {
					request.getRequestDispatcher("/view/login.jsp").forward(request, response);
					// ユーザー情報エラーの場合login.jspに遷移
				} else {
					request.getRequestDispatcher("/view/error.jsp").forward(request, response);
					// 他のエラー場合、error.jspに遷移
				}
			}
		}

	}

}
