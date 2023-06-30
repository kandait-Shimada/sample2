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

import bean.User;
import bean.OrderedItem;
import dao.OrderedItemDAO;
import util.SendMail;

public class PaymentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		String cmd = "";

		try {
			// 入力データの文字コードの指定
			request.setCharacterEncoding("UTF-8");

			// purchase_id, paymentStatus等の入力パラメータを取得する
			String str_purchase_id = request.getParameter("purchase_id");
			String str_total_price = request.getParameter("total_price");
			String username = request.getParameter("username");
			String user_mail = request.getParameter("user_mail");

			// オブジェクトを生成する
			OrderedItemDAO objDao = new OrderedItemDAO();

			String paymentStatus = "支払い済み";

			int total_price;
			try {
				// 価格が整数かどうかのチェックを行う
				total_price = Integer.valueOf(str_total_price);
			} catch (NumberFormatException e) {
				cmd = "payment";
				return;
			}

			// setterメソッド intをstringに変えてる
			OrderedItem orderedItem = new OrderedItem();
			try {
				orderedItem.setTotal_price(total_price);
				orderedItem.setPaymentStatus(paymentStatus);
				orderedItem.setUsername(username);
				orderedItem.setUser_mail(user_mail);
				orderedItem.setPurchase_id(Integer.valueOf(str_purchase_id));
			} catch (NumberFormatException e) {
				cmd = "payment";
				return;
			}

			// 設定したorderItemのオブジェクトを引数として、更新メソッドを呼び出す。
			objDao.paymentUpdate(orderedItem);

			request.setAttribute("orderedItem", orderedItem);

			User user = new User();

			// 入金確認完了をメール送信する
			SendMail sendMail = new SendMail();
			sendMail.setFromInfo("test.sender@kanda-it-school-system.com", "神田ユニフォーム");
			sendMail.setRecipients(orderedItem.getUser_mail());
			sendMail.setSubject("お支払いありがとうございます。");
			sendMail.setText(
					orderedItem.getUsername() + "様\n\n" + total_price + "円の入金を確認いたしました。\n\n商品の発送まで今しばらくお待ちください。\n");
			sendMail.forwardMail();

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、入金確認は行えませんでした。";
			cmd = "managerMenu";
		} finally {
			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はpayment.jspにフォワードする
				request.getRequestDispatcher("/view/payment.jsp").forward(request, response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}
	}
}
