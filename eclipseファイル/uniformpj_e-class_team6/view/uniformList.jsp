<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：商品一覧画面
  作成者：網野みさき
  作成日付：2023/06/21
-->

<%@page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<title>神田ユニフォーム商品一覧画面</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>

<body>
	<!-- ブラウザ全体 -->
	<div id="wrap">

		<!--ヘッダー部分  -->
		<%@ include file="/common/header.jsp"%>

		<!-- メニュー部分 -->
		<div id="menu">
			<div class="container">
				<div id="nav">
					<ul>
						<li><a href="<%=request.getContextPath()%>/view/userMenu.jsp">[メニュー]</a></li>
					</ul>
				</div>

				<!-- ページタイトル -->
				<div id="page_title">
					<h2>商品一覧</h2>
				</div>
			</div>
		</div>

		<table style="margin: auto">
			<tr>
				<th style="background-color: #6666ff; width: 200px">商品番号</th>
				<th style="background-color: #6666ff; width: 200px">商品</th>
				<th style="background-color: #6666ff; width: 200px">価格</th>
				<th style="background-color: #6666ff; width: 250px">在庫数</th>
				<th style="background-color: #6666ff; width: 250px"></th>
			</tr>


			<tr>
				<td style="text-align: center; width: 200px">&nbsp;</td>
				<td style="text-align: center; width: 200px">&nbsp;</td>
				<td style="text-align: center; width: 200px">&nbsp;</td>
				<td style="text-align: center; width: 250px" colspan="2">&nbsp;</td>

			</tr>

			<!-- テスト用 -->
			<tbody>
						<tr>
							<td>00001</td>
							<td>サッカーユニフォーム</td>
							<td>5500（税込み）</td>
							<td>8</td>
							<td>カートに入れる</td>
						</tr>


					</tbody>

		</table>
		<!-- フッター部分 -->
		<%@ include file="/common/footer.jsp"%>
	</div>

</body>
</html>
