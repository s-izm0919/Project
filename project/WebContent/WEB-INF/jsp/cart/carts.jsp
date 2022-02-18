<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isErrorPage="true" %>

<html>
    <head>
        <title>カート一覧</title>
		<%@include file="../../../css/new.css" %>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
		<link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+P+One&display=swap" rel="stylesheet">

	<script>
		(window.onload = function() {
    		if(${result['noitem']} == true){
    			document.getElementById("noitem").innerHTML = "カートは空です";
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
			        <li><a href="notification"><i class="far fa-bell"></i> おしらせ</a></li>
			        <li><a href="goodlist"><i class="far fa-heart"></i> いいね</a></li>
			        <li><a href="callcart"><i class="fas fa-cart-arrow-down"></i> カート</a></li>
		        </ul>
	        </nav>
    </header>
    <br><br><br><br>


		<div class="color">
        <h1>カート一覧</h1>
   		<br>
   		<div id="noitem"></div>
	<c:forEach var="shop" items="${result['viewcart']}">

	<div class="boxwrap">
		<div class="wrap pattern-3 mhb-20 color">
		<c:out value="${shop[0].shopName}"/><br>

		<c:forEach var="shopitem" items="${shop[1]}">
		<img src='upload\<c:out value="${shopitem.mainImagePath}"/>'><br>
			商品名：<c:out value="${shopitem.itemName}"/><br>
			商品価格<c:out value="${shopitem.itemPrice}"/><br>
			<a href="removecartitem?itemId=${shopitem.itemId}">カートから取り除く</a><br>
		</c:forEach>
		<c:forEach var="total" items="${shop[1]}" begin="0" end="0">
			買上点数：<c:out value="${total.orderCount}"/><br>
			合計金額：<c:out value="${total.orderPrice}"/><br>
			<a href="removecartitemshop?shopId=${total.shopId}">ショップごとカートから取り除く</a><br>
			<a href="callconfirmpassword?shopId=${total.shopId}">購入画面に進む</a><br><br>
		</c:forEach>
		</div>
		</div>
		</div>
	</c:forEach>
</div>
    </body>
</html>