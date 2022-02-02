<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shop注文詳細</title>
</head>
<body>
	<h1>item注文	詳細</h1>
	purchasedtime;<p>${result['singleOrderDetails'].purchaseDate}</p><br>
	orderNumber:<p>${result['singleOrderDetails'].orderId}</p><br>
	price:<p>${result['singleOrderDetails'].itemPrice}</p><br>
	itemName:<p>${result['singleOrderDetails'].itemName}</p><br>
	userName:<p>${result['singleOrderDetails'].userName}</p><br>


</body>
</html>