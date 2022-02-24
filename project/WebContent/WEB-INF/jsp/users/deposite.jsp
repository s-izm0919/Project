<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>入金ページ</title>
		<%@include file="../../../css/deposite.css" %>
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
						greet.innerHTML = '<li><select name="select" onChange="location.href=value;"><option value="#">${user.userName}</option><option value="shopopen">ショップ開設ガイド</option><option value="callusersettings">ユーザー設定</option><option value="uders_orders">購入履歴</option><option value="logoutuser">ログアウト</option></select></li>';
						if(shop != ""){
							console.log("if文2");
								greet.innerHTML = '<li><select name="select" onChange="location.href=value;"><option value="#">${user.userName}</option><option value="callusersettings">ユーザー設定</option><option value="displaypurchaseditem">購入履歴</option><option value="callshoptop">ショップ管理</option><option value="logoutuser">ログアウト</option></select></li>';
						}else{
							console.log("userのみ");

						}

					}
					else{
						console.log("else");
						greet.innerHTML = '<li class="li1"><a href="callnew">ユーザー登録</a></li><li class="li2"><a href="callsigninpage">ログイン</a></li>';
					}
					</script>
					        <li><a href="callcart"><i class="fas fa-cart-arrow-down"></i> カート</a></li>
				        </ul>
			        </nav>
		    </header>
<br><br><br><br>

		<div class="boxwrap">
			<div class="wrap pattern-3 mhb-20 color">
			<h1>入金</h1>
		あなたのポイント:${user.userPoint}<br><br>

		<form method="POST" action="deposite">
			<input type="number" min="0" max="1000000"name="userPoint"/>
			<input type="submit" value="入金する"/>
	 	</form>
	 	</div>
	</div></div>
<footer>
			<h2> </h2>
			<div></div>
			<br>
    	</footer>
	</body>
</html>