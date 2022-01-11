<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>商品一覧</title>
    </head>
    <body>
        <h1>商品一覧</h1>
		<h2>商品検索</h2>
		<form method="POST" action="searchitemcommand">
            検索項目<input type="text" name="itemName" maxlength="20" ><br>
        	<input type="submit" value="検索">
   		</form>

   		<br>

   		<table border="1">

        <c:forEach var="item" items="${result}">
            <tr>
                <td>${item.itemId}</td>
                <td>${item.itemName}</td>
                <td>${item.itemPrice}</td>
            </tr>
        </c:forEach>


        </table>




    </body>
</html>