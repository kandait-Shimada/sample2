<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：管理者メニュー画面
  作成者：嶋田清春
  作成日付：2023/06/21
-->

<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<title>神田ユニフォーム管理者メニュー画面</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
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
						<h2>MENU</h2>
					</div>


				</div>
			</div>

			<!-- コンテンツ(本文) -->
			<div id="main" class="container">
				<ul class="link">
					<li><a href="<%=request.getContextPath()%>/orderList">【受注一覧画面】</a></li>
					<li><a href="<%=request.getContextPath()%>/logout" class="mb50">【ログアウト】</a></li>
				</ul>
			</div>

			<!-- フッター部分 -->
			<%@ include file="/common/footer.jsp" %>

		</div>
	</body>
</html>
