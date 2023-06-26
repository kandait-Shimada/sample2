/*
 * プログラム名：ユニフォーム受注管理システム
 * プログラムの説明：セッションを削除してログアウトするシステム
 * 作成者：藤巻健太郎
 * 作成日付：2023/06/23
 */
package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class LogoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションオブジェクト生成後、セッション情報をクリアする
		HttpSession session = request.getSession();
		session.invalidate();

		//login.jspに遷移する。
		request.getRequestDispatcher("/view/login.jsp").forward(request, response);


	}
}
