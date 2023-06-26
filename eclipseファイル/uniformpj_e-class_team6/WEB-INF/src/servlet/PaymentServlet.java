/*
 * プログラム名：ユニフォーム受注管理システム
 * プログラムの説明：入金確認を行うためのサーブレット
 * 作成者：松井朱奈
 * 作成日付：2023/06/23
 */
package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import bean.OrderedItem;
import dao.OrderedItemDAO;


public class PaymentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";
		String cmd = "";

		try {
			// 入力データの文字コードの指定
			request.setCharacterEncoding("UTF-8");

			// � purchase_id, paymentStatus等の入力パラメータを取得する
			String str_purchase_id = request.getParameter("purchase_id");
			String str_total_price = request.getParameter("total_price");

			int total_price;
			try {
				// 価格が整数かどうかのチェックを行う
				total_price = Integer.valueOf(str_total_price);
			} catch (NumberFormatException e) {
				cmd = "orderDetil";
				return;
			}

			// BookDAOオブジェクトを生成する
			OrderedItemDAO objDao = new OrderedItemDAO();


			// Bookのオブジェクトを生成し、各setterメソッドを利用し、isbn,title,priceを設定する。
			OrderedItem orderedItem = new OrderedItem();
			try {
			orderedItem.setPurchase_id(Integer.valueOf(str_purchase_id));
			} catch (NumberFormatException e) {
				cmd = "orderDetil";
				return;
			}

			// 設定したBookのオブジェクトを引数として、更新メソッドを呼び出す。
			objDao.paymentUpdate(orderedItem);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、書籍更新処理は行えませんでした。";
			cmd = "menu";
		} finally {
			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はListServletにフォワードする
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

