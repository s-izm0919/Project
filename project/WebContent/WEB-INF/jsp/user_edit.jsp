<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー編集画面</title>
</head>
<body>
	<h1>ユーザー一覧</h1>
	<table border="1">
		<tr>
		<th>productNumber</th>
			<th>productName</th>
			<th>price</th>
		</tr>
		<c:forEach var="product" items="${result}">
			<tr>
			<td>${product.pid}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
	
