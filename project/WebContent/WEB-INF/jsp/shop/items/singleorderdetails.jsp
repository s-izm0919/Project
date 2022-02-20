<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head>
        <title>注文詳細</title>
        <%@include file="../../../../css/singleorderdetails.css" %>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    	<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+P+One&display=swap" rel="stylesheet">
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
						greet.innerHTML = '<li><select name="select" onChange="location.href=value;"><option value="#">${user.userName}</option><option value="callusersettings">ユーザーアカウント設定</option><option value="calldeposite">入金</option><option value="uders_orders">購入履歴</option><option value="shopopen">ショップ開設ガイド</option><option value="logoutuser">ログアウト</option><option value="callindex">デバック</option></select></li>';
						if(shop != ""){
							console.log("if文2");
								greet.innerHTML = '<li><select name="select" onChange="location.href=value;"><option value="#">${user.userName}</option><option value="callusersettings">ユーザーアカウント設定</option><option value="calldeposite">入金</option><option value="displaypurchaseditem">購入履歴</option><option value="callshoptop">ショップ管理</option><option value="logoutuser">ログアウト</option><option value="callindex">デバック</option></select></li>';
						}else{
							console.log("userのみ");

						}

					}
					else{
						console.log("else");
						greet.innerHTML = '<li class="li1"><a href="callnew">登録</a></li><li class="li2"><a href="callsigninpage">ログイン</a></li>';
					}
					</script>
			        <li><a href="notification"><i class="far fa-bell"></i> notice</a></li>
			        <li><a href="goodlist"><i class="far fa-heart"></i> like</a></li>
			        <li><a href="cart"><i class="fas fa-cart-arrow-down"></i> cart</a></li>
		        </ul>
	        </nav>
    </header>
    <br>
        <h1>${shop.shopName}のショップ管理ページ</h1>
	        <div class="cont_nav size1 ">
				<a class="backgra false" href="callshoptop">商品登録</a>
				<a class="backgra false" href="callshopsettings">ショップ情報編集</a>
		    	<a class="backgra false" href="shopitemdetails">商品管理</a>
			    <a class="backgra false" href="showshoporders">注文一覧</a>
			    <a class="backgra true">注文詳細</a>
	    		<a class="backgra false" href="showshopearning">売上管理</a>
			</div>
			<br>
			<div class="content">
				<div class="boxwrap">
		<div class="wrap pattern-3 mhb-20 color">
        <h1>注文詳細</h1>
        <!-- formの属性に[enctype="multipart/form-data"]を追加しました。 -->
		    受注日時;<p>${result['singleOrderDetails'].purchaseDate}</p><br>
			注文番号:<p>${result['singleOrderDetails'].orderId}</p><br>
			商品金額:<p>${result['singleOrderDetails'].itemPrice}</p><br>
			商品名:<p>${result['singleOrderDetails'].itemName}</p><br>
			購入したユーザー名:<p>${result['singleOrderDetails'].userName}</p><br>
        </div>
        </div>
			</div>
			<br>
			<footer>
		<h2>guide page</h2>
    </footer>
    </body>
</html>