/*
 * プログラム名：ユニフォーム受注管理システム
 * プログラムの説明：注文完了画面を表示するサーブレットクラス
 * 作成者：杉崎達也
 * 作成日付：2023/06/21
 */
package servlet;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.*;
import util.SendMail;
import dao.UniformDAO;
import dao.OrderDAO;
import dao.OrderedItemDAO;
import bean.Uniform;
import bean.Order;
import bean.User;
import bean.OrderedItem;

public class OrderCompletedServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		String cmd = "";

		//オブジェクト化
		OrderedItem oitem = new OrderedItem();
		OrderedItemDAO oitemdao = new OrderedItemDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String strDate = sdf.format(date); //文字列に変換


		//文字コードの設定1
		request.setCharacterEncoding("UTF-8");

		try {

			//注文画面からのパラメーター取得
			String username = request.getParameter("username");
			String address = request.getParameter("address");
			String user_mail = request.getParameter("user_mail");
			String comment = request.getParameter("comment");


			// 名前が未入力の時
			if (username.equals("")) {
				error = "名前が未入力の為、購入処理は行えませんでした。";
				cmd = "order";
				return;
			// 住所が未入荷の時
			} else if (address.equals("")) {
				error = "住所が未入力の為、購入処理は行えませんでした。";
				cmd = "order";
				return;
			// タイトル未入力時
			} else if (user_mail.equals("")) {
				error = "メールアドレスが未入力の為、購入処理は行えませんでした。";
				cmd = "order";
				return;

			}


			// セッションからorder_listを取得する
			HttpSession session = request.getSession();
			ArrayList<Order> order_list = (ArrayList<Order>) session.getAttribute("order_list");
			int sum = (int)session.getAttribute("sum");

			// カートの中身がない場合はerror.jspに遷移する
			if (order_list == null || order_list.isEmpty()) {
				error = "カートの中に何も無かったので購入は出来ません。";
				cmd = "userMenu";
				return;
			}

			//各ユーザーの購入者情報を格納するArrayListオブジェクト生成
			ArrayList<Order> orderCompleted_list = new ArrayList<Order>();

			for(int i = 0; i < order_list.size(); i++) {

				//購入者情報を格納するためのorderオブジェクト生成
				Order orderCompleted = new Order();

				//order.jspで入力したユーザー情報
				orderCompleted.setusername(username);
				orderCompleted.setaddress(address);
				orderCompleted.setuser_mail(user_mail);


				//注文番号
				orderCompleted.setuniform_id(order_list.get(i).getuniform_id());

				//商品名
				orderCompleted.setUniform_name(order_list.get(i).getUniform_name());

				//注文個数
				orderCompleted.setquantitiy(order_list.get(i).getquantitiy());

				//小計
				orderCompleted.setTotal_price(order_list.get(i).getTotal_price());

				//orderCompleted_listに格納
				orderCompleted_list.add(orderCompleted);


				//ここから管理者用の情報
					//商品番号
					oitem.setUniform_id(order_list.get(i).getuniform_id());

					//注文日
					oitem.setPurchase_day(strDate);

					//注文者
					oitem.setUsername(username);

					//住所
					oitem.setAddress(address);

					//メールアドレス
					oitem.setUser_mail(user_mail);

					//購入合計個数
					oitem.setQuantitiy(1);

					//注文合計金額
					oitem.setTotal_price(5500);

					//入金情報
					oitem.setPaymentStatus("未入金");

					//配送情報
					oitem.setSendingStatus("未発送");

					//コメント
					oitem.setComment(comment);

					//注文情報をinsert文でデータベースへ登録する
					oitemdao.INSERT(oitem);

				}

			//リクエストスコープに"ordered_list"という名前で格納する
			request.setAttribute("ordered_list", orderCompleted_list);

			// "order_list"の注文情報内容をメール送信する。
			SendMail sendMail = new SendMail();
			sendMail.setFromInfo("test.sender@kanda-it-school-system.com", "神田ユニフォーム");
			sendMail.setRecipients(oitem.getUser_mail());
			sendMail.setSubject("ユニフォームのご購入ありがとうございます。");
			sendMail.setText(oitem.getUsername()
					+ "様\n\nユニフォームのご購入ありがとうございます。\n以下内容でご注文を受け付けましたので、ご連絡致します。\n");

			sendMail.setText("合計 " + sum + "円\n\nまたのご利用よろしくお願いします。");
			sendMail.forwardMail();

			// セッションのorder_listをクリアする
			session.setAttribute("order_list", null);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、購入は出来ません。";
			cmd = "userMenu";

		} finally {
			// エラーの有無でフォワード先を呼び分ける
			if (error.equals("")) {
				// エラーが無い場合はbuyConfirm.jspにフォワードする
				request.getRequestDispatcher("/view/orderCompleted.jsp").forward(
						request, response);
			} else {
				// エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.setAttribute("cmd", cmd);
				request.getRequestDispatcher("/view/user_error.jsp").forward(
						request, response);
			}
		}
	}
}