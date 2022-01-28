<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
</head>
<body>
	<h1>注文一覧</h1>
	<table border="1">
		<tr>
		 <th>itemImagePath</th>
		 <th>itemNameName</th>
		 <th>purchasedTime</th>
		</tr>
		<c:forEach var="item" items="${result['purchasedItemResult']}">

			<tr>
			<td>${item. itemImagePath}</td>
				<td>${item.itemName}</td>
				<td>${item.purchaseDate}</td>
				 <td><a href="showorderdetail?itemId=${item.itemId}">詳細を見る</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>