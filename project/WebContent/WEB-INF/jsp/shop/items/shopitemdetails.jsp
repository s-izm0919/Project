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
	<h1>商品一覧</h1>
	<table border="1">
		<tr>
		 <th>itemId</th>
		 <th>productName</th>
		 <th>price</th>
		</tr>
		<c:forEach var="item" items="${result['shopItemResult']}">

			<tr>
			<td>${item.itemId}</td>
				<td>${item.itemName}</td>
				<td>${item.itemPrice}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>