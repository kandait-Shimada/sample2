<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：購入完了画面
  作成者：杉崎達也
  作成日付：2023/06/21
-->

<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>神田ユニフォーム購入完了画面</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<!-- ブラウザ全体 -->
	<div id="wrap">

		<!-- ヘッダー部分 -->
		<%@ include file="/common/header.jsp"%>

		<!-- メニュー部分 -->
		<div id="menu">
			<div class="container">
				<!-- ナビゲーション  -->
				<div id="nav">
					<ul>
						<li><a href="<%=request.getContextPath()%>/view/menu.jsp">[メニュー]</a></li>
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

				<tr>
					<td>001</td>
					<td>サッカー男子日本代表W杯2022モデル</td>
					<td>1</td>
				</tr>

				<tr>
					<td>002</td>
					<td>WBC2023モデル大谷翔平ネーム入り</td>
					<td>3</td>
				</tr>


				<table class="show-cart-sum">
					<tr>
						<th>合計</th>
					</tr>

					<tr>
						<td>¥22,000</td>
					</tr>
				</table>
		</div>

		<!-- フッター部分 -->
		<%@ include file="/common/footer.jsp"%>

	</div>
</body>
</html>