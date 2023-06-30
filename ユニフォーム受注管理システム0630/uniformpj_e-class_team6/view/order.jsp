<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：ユーザー情報を入力し、購入画面に遷移する
  作成者：藤巻健太郎
  作成日付：2023/06/26
-->

<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%

//もしかしたらこの欄にリクエストスコープ（カート商品情報）をしゅとくするかも

%>
<html>
	<head>
		<title>神田ユニフォーム注文画面</title>
		<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/user_style6.css">
	</head>
	<body>
		<!-- ブラウザ全体 -->
		<div id="wrap">

			<!-- ヘッダー部分 -->
			<%@ include file="/common/userheader.jsp" %>

			<!-- メニュー部分 -->
			<div id="menu">
				<div class="container">
				<!-- ナビゲーション  -->
					<div id="nav">
						<ul>
							<li><a href ="<%=request.getContextPath()%>/view/userMenu.jsp" >[メニュー]</a></li>
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
				<form action="<%=request.getContextPath()%>/orderCompleted" method="post">
					<table class="input-table">
					<tr>
						<th>名前</th>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<th>住所</th>
						<td><input type="text" name="address"></td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><input type="text" name="user_mail"></td>
					</tr>
					<tr>
						<th>備考欄</th>
						<td><textarea name="comment" rows="3" cols="30"></textarea></td>
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