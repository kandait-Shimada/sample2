/*
 * プログラム名：ユニフォーム受注管理システム
 * プログラムの説明：カート内容を表示するサーブレットクラス
 * 作成者：嶋田清春
 * 作成日付：2023/06/21
 */
package servlet;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.OrderedItem;
import dao.OrderedItemDAO;

public class OrderDetailServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String cmd = "";

		try {

			// 入力データの文字コードの指定
			request.setCharacterEncoding("UTF-8");


			String purchase_id = request.getParameter("purchase_id");
			cmd = request.getParameter("cmd");

			// OrderedItemDAOをインスタンス化し、関連メソッドを呼び出す
			OrderedItemDAO objDao = new OrderedItemDAO();

			// 書籍情報を検索し、戻り値としてBookオブジェクトを取得する
			OrderedItem orderedItem = objDao.selectByPurchase_id(purchase_id);

			// 取得したListをリクエストスコープに
			request.setAttribute("orderedItem", orderedItem);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、購入状況確認は出来ません。";
			cmd = "managerMenulogout";
		} finally {
			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はorderDetail.jspにフォワードする
				request.getRequestDispatcher("/view/orderDetail.jsp").forward(request, response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}

}
