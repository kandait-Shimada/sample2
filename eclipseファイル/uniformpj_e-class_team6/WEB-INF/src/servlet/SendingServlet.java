/*
 * プログラム名：ユニフォーム受注管理システム
 * プログラムの説明：カート内容を表示するサーブレットクラス
 * 作成者：嶋田清春
 * 作成日付：2023/06/21
 */

package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.OrderedItem;
import dao.OrderedItemDAO; ;

public class SendingServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";
		String cmd = "";

		try {
			// 入力データの文字コードの指定
			request.setCharacterEncoding("UTF-8");

			// e等の入力パラメータを取得する
			String purchase_id = request.getParameter("purchase_id");
			String address = request.getParameter("address");


			// BookDAOオブジェクト生成
			OrderedItemDAO objDao = new OrderedItemDAO();


			// オブジェクトを生成し、各setterメソッドを利用し、purchase_id、addressを設定する。
			OrderedItem orderedItem = new OrderedItem();
			orderedItem.setPurchase_id(purchase_id);
			orderedItem.setAddress(address);

			// 設定したBookのオブジェクトを引数として、更新メソッドを呼び出す。
			objDao.sendingUpdate(orderedItem);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、書籍更新処理は行えませんでした。";
			cmd = "menu";
		} finally {
			// �エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はListServletにフォワード
				request.getRequestDispatcher("/list")
						.forward(request, response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(
						request, response);
			}
		}
	}
}


