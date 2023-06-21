<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：入金確認画面
  作成者：松井朱奈
  作成日付：2023/06/21
-->

<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<title>神田ユニフォーム入金確認画面</title>
		<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/style.css">
	</head>

	<body>
		<!-- ブラウザ全体 -->
		<div id="wrap">

			<!--ヘッダー部分-->
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
						<h2>入金確認</h2>
					</div>
				</div>

			</div>

			<!-- 入金確認のコンテンツ部分 -->
			<div id="main" class="container">

				<!-- 注文番号と入金金額 -->
				<table class="payment-table">
					<thead>
						<tr>
							<th>注文番号</th>
							<th>入金金額</th>
						</tr>
					</thead>

					<tbody>
						<tr>
							<td>00001</td>
							<td>55,000円</td>
						</tr>
					</tbody>
				</table>

				<!-- 更新ボタン -->

				<input type="submit" value="入金確認">
			</div>

			<!-- フッター部分 -->
			<%@ include file="/common/footer.jsp" %>

		</div>
	</body>

</html>