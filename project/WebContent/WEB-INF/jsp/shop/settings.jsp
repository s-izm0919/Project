<<<<<<< HEAD
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
=======
<<<<<<< HEAD
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
			<input type="hidden" name="shopId"  value="${shopresult.shopId}" ><br>
			<input type="hidden" name="userId"  value="${shopresult.userId}" ><br>

		shopName<input type="text" name="shopName" maxlength="20" value="${shopresult.shopName}" required><br>
		explanation<input type="text" name="shopExplanation" maxlength="300"  value="${shopresult.shopExplanation}"  required><br>
		sellerWord<input type="text" name="sellerWord" maxlength="300"  value="${shopresult.shopSellerword}"  required><br>
		<input type="submit" value="更新">
		</form>

</body>
=======
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
			<input type="hidden" name="shopId"  value="${shopresult.shopId}" ><br>
			<input type="hidden" name="userId"  value="${shopresult.userId}" ><br>

		shopName<input type="text" name="shopName" maxlength="20" value="${shopresult.shopName}" required><br>
		explanation<input type="text" name="shopExplanation" maxlength="300"  value="${shopresult.shopExplanation}"  required><br>
		sellerWord<input type="text" name="sellerWord" maxlength="300"  value="${shopresult.shopSellerword}"  required><br>
		<input type="submit" value="更新">
		</form>

</body>
>>>>>>> branch 'shop_function' of git@github.com:s-izm0919/Project.git
>>>>>>> branch 'shop_function' of git@github.com:s-izm0919/Project.git
</html>