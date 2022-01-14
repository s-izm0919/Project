<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shop編集画面</title>
</head>
<body>
	<h1>shop編集画面</h1>
		<form method="POST" action="editshopinfo">


		shopName<input type="text" name="shopName" maxlength="20" value="${shop.shopName}" required><br>
		explanation<input type="text" name="shopExplanation" maxlength="300"  value="${shop.shopExplanation}"  required><br>
		sellerWord<input type="text" name="sellerWord" maxlength="300"  value="${shop.shopSellerword}"  required><br>


		<input type="submit" value="更新">
		</form>

</body>
</html>