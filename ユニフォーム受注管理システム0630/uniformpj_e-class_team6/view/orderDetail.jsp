<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：注文詳細画面
  作成者：嶋田清春
  作成日付：2023/06/21
-->
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, bean.*"%>

<%
		OrderedItem orderedItem = (OrderedItem) request.getAttribute("orderedItem");
%>


<html>
	<head>
		<title>ユニフォーム注文詳細画面</title>
		<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/style.css">
	</head>
	<body>
		<!-- ブラウザ全体 -->
		<div id="wrap">

			<!--ヘッダー部分  -->
			<%@include file="/common/header.jsp"%>

			<!-- メニュー部分 -->
			<div id="menu">
				<div class="container">
					<!-- ナビゲーション  -->
					<div id="nav">
						<ul>
							<li><a href="<%=request.getContextPath()%>/orderList">[受注一覧]</a></li>
							<li><a href="<%=request.getContextPath()%>/view/managerMenu.jsp">[メニュー]</a></li>
						</ul>
					</div>

					<!-- ページタイトル -->
					<div id="page_title">
						<h2>注文詳細</h2>
					</div>
				</div>
			</div>


			<!-- 受注詳細のコンテンツ部分 -->
			<div id="main" class="container">
				<!-- 受注詳細リスト -->
				<table class="list-table">
					<thead>
						<tr>
							<th>注文番号</th>
							<th>ユーザー名</th>
							<th>住所</th>
							<th>メールアドレス</th>
							<th>合計金額</th>
							<th>入金確認ボタン</th>
							<th>発送確認ボタン</th>
						</tr>
					</thead>


					<tbody>
						<tr>
								<td><%=orderedItem.getPurchase_id() %></td>
								<td><%=orderedItem.getUsername() %></td>
								<td><%=orderedItem.getAddress() %></td>
								<td><%=orderedItem.getUser_mail() %></td>
								<td><%=orderedItem.getTotal_price() %></td>
								<td><button onclick="location.href='<%=request.getContextPath()%>/payment?purchase_id=<%=orderedItem.getPurchase_id()%>&cmd=payment&total_price=<%=orderedItem.getTotal_price()%>&user_mail=' + encodeURIComponent('<%=orderedItem.getUser_mail()%>') + '&username=' + encodeURIComponent('<%=orderedItem.getUsername()%>')">入金完了</button></td>
								<td><button onclick="location.href='<%=request.getContextPath()%>/sending?purchase_id=' + encodeURIComponent('<%=orderedItem.getPurchase_id()%>') + '&cmd=sending&address=' + encodeURIComponent('<%=orderedItem.getAddress()%>') + '&user_mail=' + encodeURIComponent('<%=orderedItem.getUser_mail()%>') + '&username=' + encodeURIComponent('<%=orderedItem.getUsername()%>')">発送完了</button></td>



							</tr>
					</tbody>

				</table>

				<table class="list-table">
					<thead>
						<tr>
							<th>商品番号</th>
							<th>注文個数</th>
							<th>小計</th>
						</tr>
					</thead>
					<%
					int total = 0;

					%>
					<tbody>
						<tr>
							<td><%=orderedItem.getUniform_id() %></td>
							<td><%=orderedItem.getQuantitiy() %></td>

							<%
							total = 5500 * orderedItem.getQuantitiy() ;
							%>

							<td><%= total %></td>
						</tr>

					</tbody>
				</table>

				<table class="list-table">
					<thead>
						<tr>
							<th>備考欄</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><%=orderedItem.getComment() %></td>
						</tr>
					</tbody>
				</table>
			</div>

		<!-- ブラウザ全体 -->


			<!-- フッター部分 -->
			<%@ include file="/common/footer.jsp" %>

		</div>
	</body>
</html>
