<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：ログイン画面
  作成者：藤巻健太郎
  作成日付：2023/06/23
-->
<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="bean.User" %>
<%
	//各データをセッションから取得
	String user = "";
	String password = "";
	String error = (String) request.getAttribute("error");
	Cookie[] cookieList = request.getCookies();
	//クッキーの取得

	//クッキーがあるか判定
	if (cookieList != null) {
		for (Cookie cookie : cookieList) {
			//クッキーからユーザー情報の取得
			if (cookie.getName().equals("user")) {
				user = cookie.getValue();
			}
			//クッキーからパスワード情報の取得
			if (cookie.getName().equals("password")) {
				password = cookie.getValue();
			}
		}
	}
	if (error == null) {
		error = "";
	}
%>
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
					<td>ユーザー<input type="text" name="user" value="<%=user%>"></td>
				</tr>
				<tr>
					<td>パスワード<input type="text" name="password" value="<%=password%>"></td>
				</tr>
				<tr>
					<td><input type="submit" value="ログイン" ></td>
				</tr>
				<tr>
					<td>
						<%if(error != null){%>
						<%=error %>
						<%} %>
					</td>
				</tr>

			</table>
		</form>

	</div>

	<%@include file="/common/footer.jsp" %>

	</div>
	</body>
</html>