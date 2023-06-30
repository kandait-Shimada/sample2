/*
 * プログラム名：ユニフォーム受注管理システム
 * プログラムの説明：受注一覧を表示する為のサーブレットクラス
 * 作成者：松井朱奈
 * 作成日付：2023/06/22
 */

package servlet;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import bean.OrderedItem;
import dao.OrderedItemDAO;

public class OrderListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String cmd = "";

		try {
			// OrderItemDAOをインスタンス化し、関連メソッドを呼び出す
			OrderedItemDAO orderedItemDao = new OrderedItemDAO();

			// 戻り値として、OrderItem オブジェクトのリストを取得する
			ArrayList<OrderedItem> ordered_list = orderedItemDao.selectAll();

			// 取得したListをリクエストスコープに
			request.setAttribute("ordered_list", ordered_list);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、受注確認は出来ません。";
			cmd = "logout";
		} finally {
			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーがない場合は orderList.jsp にフォワードする
				request.getRequestDispatcher("/view/orderList.jsp").forward(request, response);
			} else {
				// エラーがある場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}
	}
}
