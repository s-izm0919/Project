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
	あなたのポイント:${user.userPoint}<br>
	<form method="POST" action="deposite">
		<input type="text" name="userPoint"/>
		<input type="submit" value="入金する"/>
 	</form>

</body>
</html>