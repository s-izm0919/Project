<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文詳細</title>
</head>
<body>
	<h1>注文	詳細</h1>
	purchasedtime;<p>${result['singleItemDetails'].purchaseDate}</p><br>
	orderNumber:<p>${result['singleItemDetails'].orderId}</p><br>
	price:<p>${result['singleItemDetails'].itemPrice}</p><br>
	itemName:<p>${result['singleItemDetails'].itemName}</p><br>
	shopId:<p>${result['singleItemDetails'].shopId}</p><br>
	shopName:<p>${result['singleItemDetails'].shopName}</p><br>

</body>
</html>