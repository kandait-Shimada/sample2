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
</head>
<body>
	<h1 style="text-align: center">神田ユニフォーム</h1>

	<!-- デザイン線 -->
	<hr
		style="text-align: center; height: 5px; background-color: blue; width: 950px">
	<p style="text-align: center; font-size: 24px">メニュー</p>
	<!-- デザイン線 -->
	<hr
		style="text-align: center; height: 2px; background-color: black; width: 950px">
	<!-- 余白の設定 -->
	<div style="margin-bottom: 350px">
		<table style="margin: auto; border: 0;">
			<tr>
				<td><a href="<%=request.getContextPath()%>/view/uniformList.jsp">【商品一覧】</a></td>
			</tr>
			<tr>
				<td><a href="<%=request.getContextPath()%>/cart">【カート内確認】</a></td>
			</tr>

		</table>
	</div>
	<hr
		style="text-align: center; height: 5px; background-color: blue; width: 950px">
	<table
		style="margin: auto; border: 0; width: 950px; text-align: center">
		<tr>
			<td>copyright (c) 2023 all rights reserved.</td>
		</tr>
	</table>
</body>
</html>