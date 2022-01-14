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
		<th>nickname</th>
			<th>userName</th>
			<th>password</th>
				<th>mail</th>
			<th>point</th>
		</tr>
			<tr>
			<td>${user.userIdentifiedName}</td>
				<td>${user.userName}</td>
				<td>${user.userPassword}</td>
				<td>${user.userMail}</td>
				<td>${user.userPoint}</td>
			</tr>
	</table>

</body>
</html>

