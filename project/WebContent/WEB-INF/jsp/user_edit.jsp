<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー編集画面</title>
</head>
<body>

	<h1>ユーザー一覧</h1>
	<table border="1">
		<tr>
		<th>nickname</th>
			<th>username</th>
			<th>password</th>
				<th>mail</th>
			<th>point</th>

		</tr>
		<c:forEach var="users" items="${result}">
			<tr>
			<td>${users.userIdentifiedName}</td>
				<td>${users.userName}</td>
				<td>${users.userPassword}</td>
				<td>${product.userMail}</td>
				<td>${product.userPoint}</td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>