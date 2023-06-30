<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：ユーザーメニュー画面
  作成者：網野みさき
  作成日付：2023/06/21
-->

<%@page contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>神田ユニフォームメニュー画面</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/user_style6.css">
	</head>
	<body>
		<!-- ブラウザ全体 -->
		<div id="wrap">

			<!-- ヘッダー部分 -->
			<%@ include file="/common/userheader.jsp" %>

			<!-- メニュー部分 -->
			<div id="menu">
				<div class="container">

					<!-- ページタイトル -->
					<div id="page_title">
						<h2>メニュー</h2>
					</div>

				</div>
			</div>


		<!-- コンテンツ(本文) -->
		<div id="main" class="container">
			<table>
				<tr>
					<td><a
						href="<%=request.getContextPath()%>/uniformList">【商品一覧】</a></td>
				</tr>
				<tr>
					<td><a href="<%=request.getContextPath()%>/cart">【カート内確認】</a></td>
				</tr>

			</table>
		</div>

			<!-- フッター部分 -->
			<%@ include file="/common/footer.jsp" %>

		</div>
	</body>
</html>