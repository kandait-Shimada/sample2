<!--
  プログラム名：ユニフォーム受注管理システム
  プログラムの説明：商品一覧画面
  作成者：網野みさき
  作成日付：2023/06/21
-->

<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.Uniform,util.MyFormat"%>

<%
	ArrayList<Uniform> uniform_list = (ArrayList<Uniform>) request.getAttribute("uniform_list");
	MyFormat format = new MyFormat();
%>

<html>
<head>
<title>神田ユニフォーム商品一覧画面</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/user_style6.css">
</head>

<body>
	<!-- ブラウザ全体 -->
	<div id="wrap">

		<!--ヘッダー部分  -->
		<%@ include file="/common/userheader.jsp"%>

		<!-- メニュー部分 -->
		<div id="menu">
			<div class="container">
				<div id="nav">
					<ul>
						<li><a href="<%=request.getContextPath()%>/view/userMenu.jsp">[メニュー]</a></li>
					</ul>
				</div>

				<!-- ページタイトル -->
				<div id="page_title">
					<h2>商品一覧</h2>
				</div>
			</div>
		</div>



		<!-- 書籍情報リスト -->
		<table class="list-table">
			<thead>
				<tr>
					<th>商品番号</th>
					<th>商品名</th>
					<th>在庫数</th>
					<th>価格</th>
					<th>カートに入れる</th>
				</tr>
			</thead>
			<tbody>
				<%
					if (uniform_list != null) {
						for (Uniform uniform : uniform_list) {
				%>
				<tr>
					<td><%=uniform.getUniformid()%></td>
					<td><%=uniform.getUniform_name()%></td>
					<td><%=uniform.getStock()%></td>
					<td><%=format.moneyFormat(uniform.getPrice())%></td>
					<td><a
						href="<%=request.getContextPath()%>/cart?uniform_id=<%=uniform.getUniformid()%>">カートに入れる</a>
					</td>

				</tr>
				<%
					}
					}
				%>
			</tbody>
		</table>
		<!-- 画像表示部分 -->
		<div class="image-container">
		<img src="<%=request.getContextPath()%>/img/uniform.png" alt="ユニフォーム画像">
		</div>





		<!-- フッター部分 -->
		<%@ include file="/common/footer.jsp"%>
	</div>

</body>
</html>
