<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>カート一覧</title>
    </head>
    <body>
        <h1>カート一覧</h1>
   		<br>

   		カート内の商品は  ${result["itemcount"]}  件あります。

   		<table border="1">

        <c:forEach var="cart" items="${result['viewcart']}">
            <tr>
                <td>${cart.}</td>
                <td><a href="callitempage?itemId=${item.itemId}">${item.itemId}</a></td>
                <td>${item.itemName}</td>
                <td>${item.itemPrice}</td>
                <td>${item.shopName}</td>

                <!-- 	private String shopName;
						private String shopId;
						private String itemName;
						private String itemId;
						private String mainImagePath;
						private int itemPrice;
						private int orderPrice;
						private int orderCount; -->

            </tr>
        </c:forEach>


        </table>

    </body>
</html>