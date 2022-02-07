<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文詳細</title>
</head>
<body>
	<h1>注文	詳細</h1>
	itemImage;<p><img src='upload\<c:out value="${result['singleItemDetails'].itemImagePath}"/>'/><br>
	purchasedtime;<p>${result['singleItemDetails'].purchaseDate}</p><br>
	orderNumber:<p>${result['singleItemDetails'].orderId}</p><br>
	price:<p>${result['singleItemDetails'].itemPrice}</p><br>
	itemName:<p>${result['singleItemDetails'].itemName}</p><br>
	shopId:<p>${result['singleItemDetails'].shopId}</p><br>
	shopName:<p>${result['singleItemDetails'].shopName}</p><br>
	<a href='<%=application.getRealPath("/")%>download\<c:out value="${result['singleItemDetails'].itemDataPath}"/>' download='download.jpg'>PDFをダウンロード</a>

</body>
</html>