<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：エラー画面
  作成者：嶋田清春
  作成日付：2023/06/21
  補足：エラーの場合分け
        遷移先はuserMenu、managerMenu、logout、uniformListです.
        cmdに入れる文字は遷移先のファイル名を拡張子を除いて入力してください

-->

<%@page contentType="text/html; charset=UTF-8"%>

<%
	String error = (String) request.getAttribute("error");
	if (error == null) {
		error = "";
	}
	String cmd = (String) request.getAttribute("cmd");
	if (cmd == null) {
		cmd = "userMenu";
	}
%>

<html>
	<head>
		<title>エラー画面</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/user_style6.css">
	</head>
	<body>
		<!-- ブラウザ全体 -->
		<div id="wrap">
		<!-- ヘッダー部分 -->
		<%@include file="/common/userheader.jsp"%>

			<div class="container">

			<!-- メニュー部分 -->
			<div id="menu">
				<div class="container">
					<!-- ページタイトル -->
					<div id="page_title">
						<h2>■■エラー■■</h2>
					</div>
				</div>
			</div>

			<!-- コンテンツ部分 -->
			<div id="main" class="container">

				<p class="error-msg"><%=error %></p>

				<p class="back-link">
					<%
					if (cmd.equals("userMenu")) {
					%>
						<a href="<%=request.getContextPath()%>/view/userMenu.jsp">[メニューに戻る]</a>
					<%
					} else if (cmd.equals("managerMenu")) {
					%>
						<a href="<%=request.getContextPath()%>/view/managerMenu.jsp">[メニューに戻る]</a>
					<%
					} else if (cmd.equals("logout")) {
					%>
						<a href="<%=request.getContextPath()%>/logout">[ログイン画面へ]</a>
					<%
					} else if (cmd.equals("list")) {
					%>
						<a href="<%=request.getContextPath()%>/uniformList">[ユニフォーム一覧表示に戻る]</a>

					<%
					} else if (cmd.equals("order")) {
					%>
						<a href="<%=request.getContextPath()%>/view/order.jsp">[注文画面に戻る]</a>
					<%
					}
					%>
				</p>
			</div>

			</div>
			<!-- フッター部分 -->
			<%@ include file="/common/footer.jsp" %>



		</div>
	</body>
</html>