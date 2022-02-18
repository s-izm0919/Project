<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>ショップ情報の編集</title>
        <%@include file="../../../css/shoptop.css" %>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    	<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+P+One&display=swap" rel="stylesheet">
    </head>
    <body>

    <header>

<<<<<<< HEAD
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
			        <li><a href="notification"><i class="far fa-bell"></i> notice</a></li>
			        <li><a href="goodlist"><i class="far fa-heart"></i> like</a></li>
			        <li><a href="cart"><i class="fas fa-cart-arrow-down"></i> cart</a></li>
		        </ul>
	        </nav>
    </header>
    <br>
        <h1 class="color">shop編集画面</h1>
	        <div class="cont_nav size1 ">
				<a class="backgra false" href="callshoptop">ショップ管理</a>
				<a class="backgra true" href="callshopsettings">ショップ情報編集</a>
		    	<a class="backgra false" href="shopitemdetails">商品管理</a>
			    <a class="backgra false" href="showshoporders">注文一覧</a>
	    		<a class="backgra false" href="">売上管理</a>
			    <a class="backgra false" href="">ユーザーとのチャット一覧</a>
			</div>
			<br>
			<div class="content">
		<form method="POST" action="editshopinfo" class="color">

<br>
		ショップ名　　　　<input type="text" name="shopName" maxlength="20" value="${shop.shopName}" required><br>
		<br>ショップの紹介文　<input type="text" name="shopExplanation" maxlength="300"  value="${shop.shopExplanation}"  required><br>
		<br>お礼の一言　　　 <input type="text" name="sellerWord" maxlength="300"  value="${shop.shopSellerword}"  required><br>
<br>

		<input type="submit" value="更新">
		</form></div>
			<br>
			<footer>
		<h2>guide page</h2>

			<div><a href="shopopen">shop open</a></div>
			<br>
    </footer>
    </body>
</html>