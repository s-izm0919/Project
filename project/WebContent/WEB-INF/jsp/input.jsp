<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録</title>
</head>
<body>
	<h1>商品登録</h1>
	<form method="POST" action="add">
	productnumber<input type="text" name="pid"><br>
		productname<input type="text" name="name"><br>
		price<input type="text" name="price">
		<input type="submit" value="登録">
	</form>
</body>
</html>