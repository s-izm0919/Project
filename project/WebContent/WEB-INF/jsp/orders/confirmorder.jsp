<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文確認画面</title>
</head>
<body>
	<h1>注文確認画面</h1>
	<p>注文内容</p>

	ショップ名:<c:out value="${result['confirmorder'][0].shopName}"/><br>
	合計支払金額：<c:out value="${result['confirmorder'][0].orderPrice}"/><br>
	注文件数:<c:out value="${result['confirmorder'][0].orderCount}"/><br>
	---------------------------------------<br>

	<c:forEach var="order" items="${result['confirmorder']}">
		<c:out value="${order.itemName}"/><br>
		<c:out value="${order.totalPayment}"/><br>
		<c:out value="-----------------"/><br>
	</c:forEach>

	ユーザーのポイント:<c:out value="${result['confirmorder'][0].userPoint}"/><br>
	<a href="">入金画面へ</a><br>
	<form action="confirmorder?shopId=${requestScope.shopId}" method="POST">
		<input type="text" name="boost" value="0"/>
		<input type="submit" value="購入する"/>
	</form>



</body>
</html>