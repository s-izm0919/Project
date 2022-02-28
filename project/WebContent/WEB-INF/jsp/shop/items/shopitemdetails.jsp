<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>

<html>
    <head>
        <title>出品商品一覧</title>
        <%@include file="../../../../css/shopitemdetails.css" %>
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    	<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+P+One&display=swap" rel="stylesheet">
	<script>
		function check(){
    		if(window.confirm('削除した商品は元に戻せません。よろしいですか？')){ // 確認ダイアログを表示

    			return true; // 「OK」時は送信を実行

    		}
    		else{ // 「キャンセル」時の処理

    			window.alert('キャンセルされました'); // 警告ダイアログを表示
    			return false; // 送信を中止

    		}

		}
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
						greet.innerHTML = '<li class="li1"><a href="callnew">登録</a></li><li class="li2"><a href="callsigninpage">ログイン</a></li>';
					}
					</script>
			        <li><a href="cart"><i class="fas fa-cart-arrow-down"></i> カート</a></li>
		        </ul>
	        </nav>
    </header>
    <br>
        <h1>${shop.shopName}のショップ管理ページ</h1>
	        <div class="cont_nav size1 ">
				<a class="backgra false" href="callshoptop">商品登録</a>
				<a class="backgra false" href="callshopsettings">ショップ情報編集</a>
		    	<a class="backgra true" href="shopitemdetails">商品管理</a>
			    <a class="backgra false" href="showshoporders">注文一覧</a>
	    		<a class="backgra false" href="showshopearning">売上管理</a>
			</div>
			<br>
			<div class="content">
				<div class="boxwrap">
					<div class="color">
        <!-- formの属性に[enctype="multipart/form-data"]を追加しました。 -->
        <h1>出品商品一覧</h1>
						<c:forEach var="item" items="${result['shopItemResult']}">

							<div class="wrap2 pattern-3 mhb-20 color">
							<div class="example">
								<div class="a">
									<img src='upload\<c:out value="${item.mainImagePath}"/>'>
								</div>
								<div class="b">
								<br>
									<a href="callitempage?itemId=${item.itemId}"></a>
									<a>商品名<br>${item.itemName}</a><br><br>
									<a>売値<br>${item.itemPrice}円</a><br><br>
						 			<a href="itemdetails?itemId=${item.itemId}">編集する　</a>
									<a href="removeitem?itemId=${item.itemId}" onclick="return check()">削除する</a>
								</div>
							</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<br>
			<footer>
			<h2> </h2>
			<div></div>
			<br>
    	</footer>
    </body>
</html>