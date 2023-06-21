<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：受注一覧画面
  作成者：松井朱奈
  作成日付：2023/06/21
-->


<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<title>神田ユニフォーム受注一覧画面</title>
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
				<div id="nav">
						<ul>
							<li><a href ="<%=request.getContextPath()%>/view/managerMenu.jsp">[メニュー]</a></li>
						</ul>
				</div>

					<!-- ページタイトル -->
					<div id="page_title">
						<h2>受注一覧</h2>
					</div>
				</div>
			</div>

			<!-- 受注一覧のコンテンツ部分 -->
			<div id="main" class="container">

				<!-- 受注リスト -->
				<table class="orderList-table">
					<thead>
						<tr>
							<th>注文番号</th>
							<th>ユーザー名</th>
							<th>入金状況</th>
							<th>発送状況</th>
						</tr>
					</thead>

					<tbody>
						<tr>
							<td>00001</td>
							<td>田中</td>
							<td>〇</td>
							<td>×</td>
						</tr>

						<tr>
							<td>00002</td>
							<td>佐藤</td>
							<td>×</td>
							<td>×</td>
						</tr>

					</tbody>

				</table>

			</div>

			<!-- フッター部分 -->
			<%@ include file="/common/footer.jsp" %>


		</div>

	</body>
</html>