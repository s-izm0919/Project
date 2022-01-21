<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>商品一覧</title>
    </head>
    <body>
        <h1>商品一覧</h1>
   		<br>

   		対象商品が  ${result["itemcount"]}  件ヒットしました。

   		<table border="1">

        <c:forEach var="item" items="${result['itemsearch']}">
            <tr>
                <td>${item.mainImagePath}</td>
                <td><a href="callitempage?itemId=${item.itemId}">${item.itemId}</a></td>
                <td>${item.itemName}</td>
                <td>${item.itemPrice}</td>
                <td>${item.shopName}</td>

            </tr>
        </c:forEach>


        </table>




    </body>
</html>