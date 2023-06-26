<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：発送確認画面
  作成者：松井朱奈
  作成日付：2023/06/21
-->


<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,bean.OrderedItem"%>

<%
	ArrayList<OrderedItem> ordered_list = (ArrayList<OrderedItem>) request
			.getAttribute("ordered_list");
%>

<html>
	<head>
		<title>神田ユニフォーム発送確認画面</title>
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
						<h2>発送確認</h2>
					</div>
				</div>

			</div>

			<!-- 発送確認のコンテンツ部分 -->
			<div id="main" class="container">

				<!-- 注文番号と住所 -->
				<table class="sending-table">
					<thead>
						<tr>
							<th>注文番号</th>
							<th>住所</th>
						</tr>
					</thead>

<%
					if (ordered_list != null) {
						for (OrderedItem ordered : ordered_list) {

					%>
					<tbody>
						<tr>
							<td><%=ordered.getPurchase_id() %></td>
							<td><%=ordered.getAddress() %></td>
						</tr>
					</tbody>
					<%
						}
					}
					%>
				</table>

				<!-- 更新ボタン -->

				<input type="submit" value="発送完了">
			</div>

			<!-- フッター部分 -->
			<%@ include file="/common/footer.jsp" %>

		</div>
	</body>

</html>