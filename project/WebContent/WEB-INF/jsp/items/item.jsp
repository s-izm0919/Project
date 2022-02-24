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
		(window.onload = function() {console.log(${result['checkBought']});
		if(${result['checkBought']}==true){document.getElementById("cart").style.visibility ="hidden";
		document.getElementById("order").innerHTML = '<a href="showorderdetail?itemId=${result['itemdetails'].itemId}">購入済み商品</a>'}})();
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
						greet.innerHTML = '<li><a href="callnew">ユーザー登録</a></li><li><a href="callsigninpage">ログイン</a></li>';
					}
					</script>
		        <li><a href="callcart"><i class="fas fa-cart-arrow-down"></i> カート</a></li>

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
				商品説明:<p>${result['itemdetails'].itemExplanation}</p>
				</div>
				<!--カートに入れるなど -->
				<div>
				ショップ名<p><a href="shopinfo?shopId=${result['itemdetails'].shopId}">${result['itemdetails'].shopName}</a></p>
				商品名:<p>${result['itemdetails'].itemName}</p>
				<!-- <input type="submit" value="いいねする"><br>-->
				価格<p>${result['itemdetails'].itemPrice}</p>
				<input type="submit" value="カートに入れる" onclick="location.href='addcart?itemId=${result['itemdetails'].itemId}'" id="cart">
				<div id="order"></div>
				</div>
				</div>
				</div>
			</div>
		</div>

	<p>--ショップ新着情報--</p>

	<br>
	<p class="ni">
		<c:forEach var="newItemList" items="${result['newItemList']}">
			<a href="callitempage?itemId=${newItemList.itemId}"><img src='upload\<c:out value="${newItemList.mainImagePath}" />'><br>
			商品名：${newItemList.itemName}<br>
			価格：${newItemList.itemPrice}<br>
			</a>
		</c:forEach>
	</p>
</body>
<footer>
			<h2> </h2>
			<div></div>
			<br>
</footer>
</html>