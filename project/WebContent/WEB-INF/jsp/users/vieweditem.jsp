
<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+P+One&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<title>閲覧履歴</title>
</head>
<body>
<p>閲覧履歴</p>
<table>
<c:forEach var="historylist" items="${result['historyList']}" >
	<tr><td><c:out value="${historylist.itemName}"/></td></tr>
	<tr><td><c:out value="${historylist.shopName}"/></td></tr>
	<tr><td><a href="deletehistory?itemId=${historylist.itemId}">履歴を消す</a>
</c:forEach>
<br>
<a href="deleteallhistory">履歴をすべて消す</a>
</table>
</body>
</html>