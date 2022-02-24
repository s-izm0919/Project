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
	<h1>個別商品売上表</h1>
	<table border="1">
		<tr>
		 <th>商品名</th>
		 <th>販売個数</th>
		 <th>売上</th>
		</tr>
		<c:forEach var="item" items="${result['singleItemEarning']}">

			<tr>
			<td>${item.itemName}</td>
				<td>${item.count}</td>
				<td>${item. earning}</td>

			</tr>
		</c:forEach>
	</table>
<footer>
			<h2> </h2>
			<div></div>
			<br>
    	</footer>
</body>
</html>