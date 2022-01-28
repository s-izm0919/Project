<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>注文完了画面</h1>

	注文者からのメッセージ<c:out value="${result['ordercomplete'][0].shopExplanation}"/><br>
	注文番号:<c:out value="${result['ordercomplete'][0].orderId}"/><br>

	<p>購入した商品</p>
	<c:forEach var="item" items="${result['ordercomplete']}">
		<c:out value="${item.itemId}"/><br>
		<c:out value="${item.itemName}"/><br>
		<c:out value="-------------------------"/><br>
	</c:forEach>



</body>
</html>