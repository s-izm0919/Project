<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page isELIgnored="false"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文詳細</title>
</head>
<body>
<h1>今月の売上一覧</h1>
	<table border="1">
		<tr>
		 <th>totalPayment</th>
		 <th>shopId</th>
		 <th>purchasedTime</th>
		</tr>
		<c:forEach var="item" items="${result['shopEarning']}">

			<tr>
			<td>${item. totalPayment}</td>
				<td>${item. shopId}</td>
				<td>${item.purchaseDate}</td>

			</tr>
		</c:forEach>
	</table>


	<h1>お店の売上</h1>
	1ヶ月の売上金額<p>${result['totalEarning']}</p><br>
	<td><a href="singleitemearning">商品ごとの売上を見る</a></td>

</body>
</html>