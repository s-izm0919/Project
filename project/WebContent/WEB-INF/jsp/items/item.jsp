<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
</head>
<body>
	<h1>商品データ</h1>
	ID;<p>${result['itemdetails'].itemId}</p>
	Name:<p>${result['itemdetails'].itemName}</p>
	Explanation:<p>${result['itemdetails'].itemExplanation}</p>
	Price<p>${result['itemdetails'].itemPrice}</p>
	ShopName<p>${result['itemdetails'].shopName}</p>
	ShopID:<p>${result['itemdetails'].shopId}</p>

</body>
</html>