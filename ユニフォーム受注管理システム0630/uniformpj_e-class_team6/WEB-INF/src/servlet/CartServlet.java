/*
 * プログラム名：ユニフォーム受注管理システム
 * プログラムの説明：カート内容を表示するサーブレットクラス
 * 作成者：藤巻健太郎、網野みさき
 * 作成日付：2023/06/25
 */

package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Order;
import bean.Uniform;
import dao.UniformDAO;

public class CartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = "";
		String cmd = "";

		try {

			HttpSession session = request.getSession();

			// � セッションからorder_listのList配列を取得する
			ArrayList<Order> order_list = (ArrayList<Order>) session.getAttribute("order_list");

			// 取得できなかった場合はArrayList<Order>配列を新規で作成する
			if (order_list == null) {
				order_list = new ArrayList<Order>();
			}

			// 削除機能

			// � delnoの入力パラメータを取得する
			String delno = (String) request.getParameter("delno");

			// � delnoが「null」でない場合、order_listから該当書籍を削除する
			if (delno != null) {
				order_list.remove(Integer.parseInt(delno));
				session.setAttribute("order_list", order_list);
			} else {
				// uniformList.jspからuniformidを取得
				String struniformid = request.getParameter("uniform_id");

				if (struniformid != null) {

					// Stringからintに変換
					int uniformid = Integer.parseInt(struniformid);

					// UniformDAOのインスタンス化と検索
					UniformDAO uniformDaoObj = new UniformDAO();
					Uniform uniform = uniformDaoObj.selectByUniformid(uniformid);

					// � Orderのインスタンスを生成し、各setterメソッドを利用し、商品番号、商品名,数量（1固定）を設定する
					Order order = new Order();
					order.setuniform_id(uniform.getUniformid());
					order.setUniform_name(uniform.getUniform_name()); // 内部キー設定でエラー解除するのみ。そのほか大丈夫なはず！！！
					order.setquantitiy(1);
					order.setTotal_price(uniform.getPrice());
					order_list.add(order);
					session.setAttribute("order_list", order_list);
				} else {
					// カートの中身をみたいだけ"
				}

			}

			// 合計値
			int sum = 0;

			for (int i = 0; i < order_list.size(); i++) {

				sum += order_list.get(i).getTotal_price();
			}

			// 合計金額をセッションスコープに登録
			session.setAttribute("sum", sum);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、カートに追加は出来ません。";
			cmd = "userMenu";
		} finally {
			// � エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はorder.jspにフォワード
				request.getRequestDispatcher("/view/cart.jsp").forward(request, response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}

		}
	}
}
