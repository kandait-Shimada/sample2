/*
 * プログラム名：商品一覧機能
 * プログラムの説明：商品一覧を表示するサーブレットクラス
 * 作成者：網野みさき
 * 作成日付：2023/06/25
 */

package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Uniform;
import dao.UniformDAO;

public class UniformListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String cmd = "";

		try {
			// uniformDAOをインスタンス化する
			UniformDAO objDao = new UniformDAO();

			// 関連メソッドを呼び出し、戻り値としてオブジェクトのリストを取得する
			ArrayList<Uniform> uniformList = objDao.selectAll();

			// 上記で取得したListをリクエストスコープに格納する
			request.setAttribute("uniform_list", uniformList);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、一覧表示は行えませんでした。";
			cmd = "menu";
		} finally {
			// � エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はlist.jspにフォワード
				request.getRequestDispatcher("/view/uniformList.jsp").forward(request, response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}
}
