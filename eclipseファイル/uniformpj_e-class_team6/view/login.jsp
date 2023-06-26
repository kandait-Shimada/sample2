<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：ログイン画面
  作成者：藤巻健太郎
  作成日付：2023/06/21
-->
<%@page contentType="text/html; charset=UTF-8" %>

<html>
	<head>
		<title>神田ユニフォームログイン画面</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	</head>

	<body>
	<!-- ブラウザ全体 -->
	<div id="wrap">

	<!-- ヘッダー部分 -->
	<%@include file="/common/header.jsp" %>

	<!-- タイトル部分 -->
	<div id="menu">
	<div id="container">

		<div id="page_title">
			<h2>ログイン画面</h2>
		</div>

	</div>
	</div>

	<!-- ログインのコンテンツ部分 -->
	<div id="main" class="container">
		<form action="<%=request.getContextPath()%>/login" method="post">
			<table>
				<tr>
					<td>ユーザー<input type="text" name="name"></td>
				</tr>
				<tr>
					<td>パスワード<input type="text" name="name"></td>
				</tr>
				<tr>
					<td><input type="submit" value="ログイン" ></td>
				</tr>
			</table>
		</form>

	</div>

	<%@include file="/common/footer.jsp" %>

	</div>
	</body>
</html>