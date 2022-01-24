<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<html>
    <head>
        <title>カート一覧</title>
    </head>
    <body>
        <h1>カート一覧</h1>
   		<br>
	<c:forEach var="shop" items="${result['viewcart']}">
		<c:out value="${shop[0].shopName}"/><br>
		<c:forEach var="shopitem" items="${shop[1]}">
			商品名：<c:out value="${shopitem.itemName}"/><br>
			商品価格<c:out value="${shopitem.itemPrice}"/><br>
		</c:forEach>
		<c:forEach var="total" items="${shop[1]}" begin="0" end="0">
			買上点数：<c:out value="${total.orderCount}"/><br>
			合計金額：<c:out value="${total.orderPrice}"/><br>
		</c:forEach>
	</c:forEach>


    </body>
</html>