<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>カート一覧(いま追加したもの)</title>
    </head>
    <body>
        <h1>カート一覧（いま追加したもの）</h1>
   		<br>

         ショップ名：${result['viewcart'].shopName}<br>
         商品名：${result['viewcart'].itemName}<br>
         商品価格：${result['viewcart'].itemPrice}<br>

		 <a href="callcart">カート全体を見る</a>


    </body>
</html>