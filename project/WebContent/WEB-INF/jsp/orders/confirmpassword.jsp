<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>パスワードを再入力</p>
	<form method="POST" action="confirmpassword?shopId=${requestScope.shopId}">
		<input type="text" name="password"/>
		<input type="submit" value="入力"/>
	</form>

</body>
</html>