<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー編集画面</title>
</head>
<body>
	<h1>ユーザー編集画面</h1>
		<form method="POST" action="add">
		ユーザー名の変更<input type="text" name="userName" required><br>
		メールアドレスの変更<input type="text" name="userMail" required><br>
		<input type="submit" value="更新">
		</form>
</body>
</html>