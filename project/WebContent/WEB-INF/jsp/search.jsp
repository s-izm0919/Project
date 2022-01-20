<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>
        <%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>検索結果ページ</title>
    </head>
  	<body>
	<table border="1">
		<c:forEach var = "product" items = "${result}">
			<tr><th>商品名</th><th>サムネ</th></tr>
			<tr><td>${product.item_name}</td><td><img src="${product.main_image_path}"></td></tr>
		</c:forEach>
       </table>
  </body>
</html>