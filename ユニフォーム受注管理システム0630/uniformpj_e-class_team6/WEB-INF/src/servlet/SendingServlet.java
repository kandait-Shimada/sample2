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

import bean.User;
import bean.OrderedItem;
import dao.OrderedItemDAO;
import util.SendMail;

public class SendingServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String cmd = "";

		try {
			// 入力データの文字コードの指定
			request.setCharacterEncoding("UTF-8");

			// purchase_id, paymentStatus等の入力パラメータを取得する
			String str_purchase_id = request.getParameter("purchase_id");
			String address = request.getParameter("address");
			String username = request.getParameter("username");
			String user_mail = request.getParameter("user_mail");

			// OrderedItemDAOオブジェクトを生成する
			OrderedItemDAO objDao = new OrderedItemDAO();

			String sendingStatus = "発送済み";

			// Orderedtemのオブジェクトを生成し、各setterメソッドを利用し、設定する。
			OrderedItem orderedItem = new OrderedItem();
			try {
				orderedItem.setPurchase_id(Integer.valueOf(str_purchase_id));
				orderedItem.setAddress(address);
				orderedItem.setSendingStatus(sendingStatus);
				orderedItem.setUsername(username);
				orderedItem.setUser_mail(user_mail);
			} catch (NumberFormatException e) {
				cmd = "sendingl";
				return;
			}

			// 設定したBookのオブジェクトを引数として、更新メソッドを呼び出す。
			objDao.sendingUpdate(orderedItem);

			// purchase_idと住所の情報をリクエストスコープにセットする
			request.setAttribute("orderedItem", orderedItem);

			// 入金確認完了をメール送信する
			SendMail sendMail = new SendMail();
			sendMail.setFromInfo("test.sender@kanda-it-school-system.com", "神田ユニフォーム");
			sendMail.setRecipients(orderedItem.getUser_mail());
			sendMail.setSubject("商品を発送いたしました。");
			sendMail.setText(
					orderedItem.getUsername() + "様\n\n" + address + "宛てに商品を発送いたしました。\n\n商品の到着まで今しばらくお待ちください。\"\n");
			sendMail.forwardMail();

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、発送完了処理は行えませんでした。";
			cmd = "managerMenu";
		} finally {
			// �エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はOrderDetailServletにフォワード

				request.getRequestDispatcher("/view/sending.jsp").forward(request, response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
