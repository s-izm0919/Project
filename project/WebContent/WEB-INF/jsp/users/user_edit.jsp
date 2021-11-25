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
			<tr>
			<td>${result.userIdentifi}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
			</tr>
	</table>

</body>
</html>

