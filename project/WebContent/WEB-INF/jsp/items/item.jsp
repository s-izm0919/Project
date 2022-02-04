<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <title>商品の詳細ページ</title>
		<%@include file="../../../css/item.css" %>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    </head>
    <body>
    <header>

    		<h1>
			<a href="top">
			<img src="images\icon.jpg"></a>
			</h1>
			<nav class="hd-nav">
				<ul>
					<li>
						<form method="POST" action="searchitem">
				    		<input type="text" name="itemName" placeholder="商品検索" maxlength="20" >
				      		<input type="submit" value="検索">
				   		</form>
					</li>
		   			<li>
		   				<form method="POST" action="searchshop">
			    			<input type="text" name="shopName" placeholder="ショップ検索" maxlength="20" >
			      			<input type="submit" value="検索">
		   				</form>
			        </li>
					<li>

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
    <br><br><br><br>

		<div class="boxwrap">
			<div class="wrap pattern-3 mhb-20">
			<div class="color">
			<div class="example">
			<!--商品画像など -->
			<div><a></a>
				<p class="item">
					<img src="<%=application.getRealPath("/")%>images\item.jpg">
				</p>
				Explanation:<p>${result['itemdetails'].itemExplanation}</p>
				</div>
				<!--カートに入れるなど -->
				<div>
				ShopName<p>${result['itemdetails'].shopName}</p>
				Name:<p>${result['itemdetails'].itemName}</p>
				<input type="submit" value="いいねする"><br>
				Price<p>${result['itemdetails'].itemPrice}</p>
				<input type="submit" value="カートに入れる" onclick="location.href='addcart?itemId=${result['itemdetails'].itemId}'">
				</div>
				</div>
				</div>
			</div>
		</div>

	<p>-ショップ新着情報も</p>
	<br>

	<c:forEach var="newItemList" items="${result['newItemList']}">
		<c:out value="${newItemList.itemName}"/><br>
		<c:out value="${newItemList.itemPrice}"/><br>
	</c:forEach>
</body>
</html>