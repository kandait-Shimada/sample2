<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：注文詳細画面
  作成者：嶋田清春
  作成日付：2023/06/21
-->
<%@page contentType="text/html; charset=UTF-8"%>


<html>
	<head>
		<title>ユニフォーム注文詳細画面</title>
		<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/style.css">
	</head>

	<body>
		<!-- ブラウザ全体 -->
		<div id="wrap">

			<!--ヘッダー部分  -->
			<%@ include file="/common/header.jsp" %>

			<!-- メニュー部分 -->
			<div id="menu">
				<div class="container">
					<!-- ナビゲーション  -->
					<div id="nav">
						<ul>
							<li>[受注一覧]</li>
							<li><a href ="<%=request.getContextPath()%>/view/managerMenu.jsp">[メニュー]</a></li>
						</ul>
					</div>

					<!-- ページタイトル -->
					<div id="page_title">
						<h2>注文詳細</h2>
					</div>
				</div>
			</div>


				<!-- 受注詳細リスト -->
				<table class="list-table">
					<thead>
						<tr>
							<th>注文番号</th>
							<th>ユーザー名</th>
							<th>住所</th>
							<th>メールアドレス</th>
							<th>合計金額</th>
							<th>入金状況</th>
							<th>発送状況</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>00001</td>
							<td>田中</td>
							<td>東京都千代田区１番１号</td>
							<td>tanaka@gmail.com</td>
							<td>55000</td>
							<td>〇</td>
							<td>〇</td>
						</tr>
					</tbody>
				</table>

				<table class="list-table">
					<thead>
						<tr>
							<th>商品番号</th>
							<th>注文個数</th>
							<th>小計</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>001</td>
							<td>8</td>
							<td>44000</td>
						</tr>
						<tr>
							<td>002</td>
							<td>2</td>
							<td>11000</td>
						</tr>
					</tbody>
				</table>

			</div>

			<!-- フッター部分 -->
			<%@ include file="/common/footer.jsp" %>

		</div>
	</body>
</html>
