<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：ログイン画面
  作成者：藤巻健太郎
  作成日付：2023/06/21
-->

<%@page contentType="text/html; charset=UTF-8" %>

<html>
	<head>
		<title>神田ユニフォームカート確認画面</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">

	</head>

	<body>
		<!-- ブラウザ全体 -->
		<div id="wrap">

		<!-- ヘッダー部分 -->
		<%@include file="/common/header.jsp" %>

		<!-- メニュー部分 -->
		<div id="menu">
			<div class="container">
				<div id="nav">
					<ul>
						<li><a href ="<%=request.getContextPath()%>/view/managerMenu.jsp">[メニュー]</a></li>
						<li><a href ="<%=request.getContextPath()%>/view/managerMenu.jsp">[商品一覧]</a></li>
					</ul>
				</div>

				<!-- ページタイトル -->
				<div id="page_title">
					<h2>カート確認画面</h2>
				</div>
			</div>
		</div>

	<div id="main" class="container">

		<strong class="text-left">
			下記の商品をカートに追加しました。
		</strong>


		<table class="cart-table">

			<!-- テーブルヘッダー部分 -->
			<thead>
				<tr>
					<th>商品番号</th>
					<th>商品名</th>
					<th>個数</th>
					<th>変更</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td>001</td>
					<td>サッカー男子日本代表W杯2022モデル</td>
					<td>1</td>
					<td><a href="request."></a>削除</td>
				</tr>
				<tr>
					<td>002</td>
					<td>サッカー男子ブラジル代表W杯2000モデル</td>
					<td>3</td>
					<td>削除</td>
				</tr>
			</tbody>

		</table>
		<table class="show-cart-sum">
			<tr>
				<th>合計</th>
			</tr>

			<tr>
				<td>¥22,000</td>
			</tr>
		</table>

		<input type="submit" value="注文する">

		</div>

		<%@include file="/common/footer.jsp" %>
		</div>
	</body>
</html>
