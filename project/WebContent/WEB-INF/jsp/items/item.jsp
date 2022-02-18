<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <head>
        <title>商品の詳細ページ</title>
		<%@include file="../../../css/item.css" %>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
		<link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+P+One&display=swap" rel="stylesheet">

	<script>
		(window.onload = function() {
			console.log(${result['checkBought']});
			if(${result['checkBought']}==true){
				document.getElementById("cart").style.visibility ="hidden";
				document.getElementById("order").innerHTML = '<a href="showorderdetail?itemId=${result['itemdetails'].itemId}">購入済み商品</a>'
			}

	    })();
	</script>
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

				<div id="greet" class="else">
						<li>
				 			<select name="select" onChange="location.href=value;">
				    	    	<option value="${user.userName}" id="user">${user.userName}</option>
				        		<option value="${shop.shopName}" id="shop">${shop.shopName}</option>
				        	</select>
				        </li>
					</div>
					<script>
					var greet = document.getElementById('greet');

					var user = 0;
					user = document.getElementById('user').textContent;
					console.log(user);
					var shop = 0;
					shop = document.getElementById('shop').value;
					console.log(shop);
					if(user != ""){
						console.log("if文1");
						greet.innerHTML = '<li><select name="select" onChange="location.href=value;"><option value="#">${user.userName}</option><option value="shopopen">ショップ開設ガイド</option><option value="callusersettings">ユーザー設定</option><option value="following">フォローしたショップ</option><option value="follow_items">フォローしたショップの新着商品</option><option value="users_chatlist">ショップとのチャット</option><option value="uders_orders">購入履歴</option><option value="logoutuser">ログアウト</option></select></li>';
						if(shop != ""){
							console.log("if文2");
								greet.innerHTML = '<li><select name="select" onChange="location.href=value;"><option value="#">${user.userName}</option><option value="callusersettings">ユーザー設定</option><option value="following">フォローしたショップ</option><option value="follow_items">フォローしたショップの新着商品</option><option value="users_chatlist">ショップとのチャット</option><option value="uders_orders">購入履歴</option><option value="shop_top">ショップ管理</option><option value="shop_items">商品管理</option><option value="shop_orders">注文一覧</option><option value="shop_sales">売上管理</option><option value="shop_chatlist">ユーザーとのチャット</option><option value="callopen">ショップ解説ページ</option><option value="logoutuser">ログアウト</option></select></li>';
						}else{
							console.log("userのみ");

						}

					}
					else{
						console.log("else");
						greet.innerHTML = '<li class="li1"><a href="callnew">ユーザー登録</a></li><li class="li2"><a href="callsigninpage">ログイン</a></li>';
					}
					</script>

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
					<img src='upload\<c:out value="${result['itemdetails'].mainImagePath}"/>'>
				</p>
				Explanation:<p>${result['itemdetails'].itemExplanation}</p>
				</div>
				<!--カートに入れるなど -->
				<div>
				ShopName<p>${result['itemdetails'].shopName}</p>
				Name:<p>${result['itemdetails'].itemName}</p>
				<input type="submit" value="いいねする"><br>
				Price<p>${result['itemdetails'].itemPrice}</p>
				<input type="submit" value="カートに入れる" onclick="location.href='addcart?itemId=${result['itemdetails'].itemId}'" id="cart">
				<div id="order"></div>
				</div>
				</div>
				</div>
			</div>
		</div>

	<p>--ショップ新着情報--</p>

	<br>

	<c:forEach var="newItemList" items="${result['newItemList']}">
		<a href="callitempage?itemId=${newItemList.itemId}"><img src='upload\<c:out value="${newItemList.mainImagePath}"/>'></a><br>
		商品名:<c:out value="${newItemList.itemName}"/>
		価格:<c:out value="${newItemList.itemPrice}"/><br>
	</c:forEach>
</body>
</html>