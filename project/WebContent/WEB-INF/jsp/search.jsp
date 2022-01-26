<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>検索結果ページ-</title>
		<%@include file="../../css/search.css" %>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>

    </head>

  	<body>

    <header>

    		<h1>
			<a href="top">
			<img src="<%=application.getRealPath("/")%>images\icon.jpg"></a>
			</h1>
			<nav class="hd-nav">
				<ul>
				<li>
		        <input type="text" name="search" value="検索" >
		        </li>

				<li>
			        <select name="select" onChange="location.href=value;">
			        	<option value="#">${user.userName}</option>
			            <option value="callnew">ユーザー登録</option>
			            <option value="callsigninpage">ログイン</option>
			            <option value="shopopen">ショップ開設ガイド</option>
			            <option value="callusersettings">ユーザーアカウント設定</option>
			            <option value="following">フォローしたショップ</option>
			            <option value="follow_items">フォローしたショップの新着商品</option>
			            <option value="users_chatlist">ショップとのチャット</option>
			            <option value="uders_orders">購入履歴</option>
			            <option value="shop_top">ショップ管理</option>
			            <option value="shop_items">商品管理</option>
			            <option value="shop_orders">注文一覧</option>
			            <option value="shop_sales">売上管理</option>
			            <option value="shop_chatlist">ユーザーとのチャット</option>
			            <option value="callopen">ショップ解説ページ</option>
			            <option value="logoutuser">ログアウト</option>
			        </select>
				</li>

		        <li><a href="notification"><i class="far fa-bell"></i>お知らせ</a></li>

		        <li><a href="goodlist"><i class="far fa-heart"></i>いいね</a></li>

		        <li><a href="cart"><i class="fas fa-cart-arrow-down"></i>カート</a></li>

		        </ul>
	        </nav>
    </header>
	<table border="1">
		<c:forEach var = "product" items = "${result}">
			<tr><th>商品名</th><th>サムネ</th></tr>
			<tr><td>${product.item_name}</td><td><img src="${product.main_image_path}"></td></tr>
		</c:forEach>
       </table>
  </body>
<!-- 和泉が作ったサンプル残しておきます
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
                <td><a href="addcart?itemId=${item.itemId}">カートに入れる</a>

            </tr>
        </c:forEach>


        </table>




    </body>
	-->
</html>