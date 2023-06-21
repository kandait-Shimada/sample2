<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：注文画面
  作成者：杉崎達也
  作成日付：2023/06/21
-->

<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<title>神田ユニフォーム注文画面</title>
		<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/style.css">
	</head>
	<body>
		<!-- ブラウザ全体 -->
		<div id="wrap">

			<!-- ヘッダー部分 -->
			<%@ include file="/common/header.jsp" %>

			<!-- メニュー部分 -->
			<div id="menu">
				<div class="container">
				<!-- ナビゲーション  -->
					<div id="nav">
						<ul>
							<li><a href ="<%=request.getContextPath()%>/view/menu.jsp" >[メニュー]</a></li>
						</ul>
					</div>


					<!-- ページタイトル -->
					<div id="page_title">
						<h2>注文</h2>
					</div>
				</div>
			</div>

			<!-- コンテンツ部分 -->
			<div id="main" class="container">

				<!--  入力フォーム -->
				<form action="<%=request.getContextPath()%>/insert">
					<table class="input-table" align="center">
					<tr>
						<th>名前</th>
						<td><input type="text" name="isbn"></td>
					</tr>
					<tr>
						<th>住所</th>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><input type="text" name="price"></td>
					</tr>
					</table>

					<input type="submit" value="購入">
				</form>



			</div>

			<!-- フッター部分 -->
			<%@ include file="/common/footer.jsp" %>

		</div>
	</body>
</html>