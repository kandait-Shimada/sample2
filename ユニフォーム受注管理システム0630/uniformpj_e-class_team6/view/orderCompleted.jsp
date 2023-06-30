<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：購入完了画面
  作成者：杉崎達也
  作成日付：2023/06/21
-->

<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,bean.Order,util.MyFormat"%>

<%
	//セッションスコープから取得する
	ArrayList<Order> ordered_list = (ArrayList<Order>) request.getAttribute("ordered_list");
	int sum = (int) session.getAttribute("sum");

	MyFormat format = new MyFormat();
%>

<html>
<head>
<title>神田ユニフォーム購入完了画面</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/user_style6.css">
</head>
<body>
	<!-- ブラウザ全体 -->
	<div id="wrap">

		<!-- ヘッダー部分 -->
		<%@ include file="/common/userheader.jsp"%>

		<!-- メニュー部分 -->
		<div id="menu">
			<div class="container">
				<!-- ナビゲーション  -->
				<div id="nav">
					<ul>
						<li><a href="<%=request.getContextPath()%>/view/userMenu.jsp">[メニュー]</a></li>
					</ul>
				</div>

				<!-- ページタイトル -->
				<div id="page_title">
					<h2>購入完了</h2>
				</div>
			</div>
		</div>

		<!-- 購入品確認コンテンツ部分 -->
		<div id="main" class="container">

			<strong class="text-left"> 下記の商品を購入しました。<br>
				ご利用ありがとうございました。
			</strong>

			<table class="list-table">
				<tr>
					<th>商品番号</th>
					<th>商品名</th>
					<th>個数</th>
				</tr>

				<%

				//リクエストスコープから取得
				ArrayList<Order> order_list = (ArrayList<Order>) session.getAttribute("order_list");

				if (ordered_list != null) {
					for (int i = 0; i < ordered_list.size(); i++) {
				%>
				<tr>
					<td><%=ordered_list.get(i).getuniform_id()%></td>
					<td><%=ordered_list.get(i).getUniform_name()%></td>
					<td><%=ordered_list.get(i).getquantitiy()%></td>
				</tr>
				<%	}
				}%>
			</table>

			<table class="orderCompleted-sum">
				<tr>
					<th>合計</th>
				</tr>

				<tr>
					<td><%=format.moneyFormat(sum)%></td>
				</tr>
			</table>

		</div>

		<!-- フッター部分 -->
		<%@ include file="/common/footer.jsp"%>

	</div>
</body>
</html>