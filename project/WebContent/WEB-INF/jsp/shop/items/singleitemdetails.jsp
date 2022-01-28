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
	purchasedtime;<p>${result['singleItemDetails'].purchaseDate}</p><br>
	itemName:<p>${result['singleItemDetails'].itemName}</p><br>
	shopName:<p>${result['singleitemDetails']. shopName}</p><br>

</body>
</html>