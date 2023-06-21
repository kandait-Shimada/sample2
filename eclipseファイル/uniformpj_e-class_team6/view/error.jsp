<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：エラー画面
  作成者：嶋田清春
  作成日付：2023/06/21
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
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	</head>
	<body>
		<!-- ブラウザ全体 -->
		<div id="wrap">
			<!-- ヘッダー部分 -->
			<%@ include file="/common/header.jsp" %>

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

				[メニューに戻る]

			</div>

			<!-- フッター部分 -->
			<%@ include file="/common/footer.jsp" %>

		</div>
	</body>
</html>