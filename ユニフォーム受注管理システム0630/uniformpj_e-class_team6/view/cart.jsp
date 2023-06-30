<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：CartServletから送られるカート情報を画面に表示するシステム
  作成者：藤巻健太郎
  作成日付：2023/06/23
-->

<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList, bean.Order, util.MyFormat"%>
<html>
<head>
<title>神田ユニフォームカート確認画面</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/user_style6.css">
</head>

<body>
	<!-- ブラウザ全体 -->
	<div id="wrap">

		<!-- ヘッダー部分 -->
		<%@include file="/common/userheader.jsp"%>

		<!-- メニュー部分 -->
		<div id="menu">
			<div class="container">
				<div id="nav">
					<ul>
						<li><a href="<%=request.getContextPath()%>/view/userMenu.jsp">[メニュー]</a></li>
						<li><a href="<%=request.getContextPath()%>/uniformList">[商品一覧]</a></li>
					</ul>
				</div>

				<!-- ページタイトル -->
				<div id="page_title">
					<h2>カート確認画面</h2>
				</div>
			</div>
		</div>

		<div id="main" class="container">

			<strong class="text-left"> 下記の商品がカートに入っています。 </strong>


			<table class="cart-table">

				<!-- テーブルヘッダー部分 -->
				<thead>
					<tr>
						<th>商品番号</th>
						<th>商品名</th>
						<th>個数</th>
						<th>価格</th>
						<th>削除</th>
					</tr>
				</thead>

				<%
					//MyFormatオブジェクト生成
					MyFormat myFormat = new MyFormat();
					//セッションからsumを取得
					int sum = (int) session.getAttribute("sum");

					//リクエストスコープから取得
					ArrayList<Order> order_list = (ArrayList<Order>) session.getAttribute("order_list");
					//order_listにデータが入っているなら全て表示させる
					if (order_list != null) {
						for (int i = 0; i < order_list.size(); i++) {
				%>

				<tbody>
					<tr>
						<td><%=order_list.get(i).getuniform_id()%></td>
						<td><%=order_list.get(i).getUniform_name()%></td>
						<td><%=order_list.get(i).getquantitiy()%></td>
						<td><%=myFormat.moneyFormat(order_list.get(i).getTotal_price())%></td>
						<td><a
							href="<%=request.getContextPath()%>/cart?delno=<%=i%>&uniform_id=<%=order_list.get(i).getuniform_id()%>">削除</a></td>
					</tr>
				</tbody>
				<%
					}
					}
				%>
			</table>
			<table class="show-cart-sum">
				<tr>
					<th>合計</th>
				</tr>

				<tr>
					<td><%=myFormat.moneyFormat(sum)%></td>
				</tr>
			</table>
			<form action="<%=request.getContextPath()%>/view/order.jsp">
				<input type="submit" value="注文する">
			</form>
		</div>

		<%@include file="/common/footer.jsp"%>
	</div>
</body>
</html>

