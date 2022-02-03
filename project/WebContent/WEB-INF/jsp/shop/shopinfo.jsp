
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ショップの情報</title>
</head>
<body>
shopId:${result['shopInfo'].shopId}<br>
shopName:${result['shopInfo'].shopName}<br>
説明:${result['shopInfo'].shopExplanation}<br>

<table>

	<c:forEach var="itemlist" items="${result['itemList'] }">
	<tr>
		<td><c:out value="${itemlist.itemName }"/></td>
		<td><c:out value="${itemlist.itemPrice }"/></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>