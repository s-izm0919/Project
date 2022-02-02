<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文リスト</title>
</head>
<body>
	<h1>shop注文一覧</h1>
	<table border="1">
		<tr>
		 <th>purchasedDate</th>
		 <th>price</th>
		 <th>userName</th>
		</tr>
		<c:forEach var="item" items="${result['shopOrdersResult']}">

			<tr>
			<td>${item.purchaseDate}</td>
			<td>${item.orderPrice }</td>
				<td>${item.userName}</td>

 <td><a href="showsingleorderdetails?orderId=${item.orderId}">詳細を見る</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>