<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>出品商品編集</title>
        <%@include file="../../../../../css/edit.css" %>
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
			        <li><a href="cart"><i class="fas fa-cart-arrow-down"></i> カート</a></li>
		        </ul>
	        </nav>
    </header>
    <br>
        <h1>${shop.shopName}のショップ管理ページ</h1>
	        <div class="cont_nav size1 ">
				<a class="backgra false" href="callshoptop">商品登録</a>
				<a class="backgra false" href="callshopsettings">ショップ情報編集</a>
		    	<a class="backgra false" href="shopitemdetails">商品管理</a>
		    	<a class="backgra true" href="shopitemdetails">商品編集</a>
			    <a class="backgra false" href="showshoporders">注文一覧</a>
	    		<a class="backgra false" href="showshopearning">売上管理</a>
			</div>
			<br>
			<div class="content">
				<div class="boxwrap">
		<div class="wrap pattern-3 mhb-20 color">
        <h1>出品商品を編集</h1>
        <!-- formの属性に[enctype="multipart/form-data"]を追加しました。 -->
        <form method="POST" action="edititem?itemId=${result['singleItemResult'].itemId }" enctype="multipart/form-data">
            商品タイトル<input type="text" name="itemName" value="${result['singleItemResult'].itemName}" maxlength="50" required><br>
            価格<input type="number" min="0" max="1000000"name="itemPrice" value="${ result['singleItemResult'].itemPrice}" required><br>
            サムネイル<input type="file" name="mainImagePath" required><br>
            商品説明<br><textarea cols="25" rows="8" name="itemExplanation">${ result['singleItemResult'].itemExplanation}</textarea><br>
            カテゴリ <select name="categoryName" required>
            			<option name="categoryName"></option>
                        <option name="categoryName" value="1">風景・自然の写真</option>
                        <option name="categoryName" value="2">人物・キャラクターの写真</option>
                        <option name="categoryName" value="3">食べ物の写真</option>
                        <option name="categoryName" value="4">植物・動物の写真</option>
                        <option name="categoryName" value="5">その他の写真</option>
                        <option name="categoryName" value="6">風景・自然のイラスト</option>
                        <option name="categoryName" value="7">人物・キャラクターのイラスト</option>
                        <option name="categoryName" value="8">食べ物のイラスト</option>
                        <option name="categoryName" value="9">植物・動物のイラスト</option>
                        <option name="categoryName" value="10">その他のイラスト</option>
			</select><br>
            データ本体<input type="file" name="itemDataPath" required><br>
            <input type="radio" name="itemIsOpen" value="1" checked>公開
            <input type="radio" name="itemIsOpen" value="0">非公開
            <input type="submit" value="登録">
        </form>
        <!--
        <form method="POST" action="additem" enctype="multipart/form-data">
            商品タイトル<input type="text" name="itemName" maxlength="50" required><br>
            価格<input type="number" name="itemPrice" value="0" required><br>
            サムネイル<input type="file" name="mainImagePath" required><br>
            商品説明<br><textarea cols="25" rows="8" name="itemExplanation"></textarea><br>
            カテゴリ
            <select name="categoryName" required>
            			<option name="categoryName"></option>
                        <option name="categoryName" value="1">風景・自然の写真</option>
                        <option name="categoryName" value="2">人物・キャラクターの写真</option>
                        <option name="categoryName" value="3">食べ物の写真</option>
                        <option name="categoryName" value="4">植物・動物の写真</option>
                        <option name="categoryName" value="5">その他の写真</option>
                        <option name="categoryName" value="6">風景・自然のイラスト</option>
                        <option name="categoryName" value="7">人物・キャラクターのイラスト</option>
                        <option name="categoryName" value="8">食べ物のイラスト</option>
                        <option name="categoryName" value="9">植物・動物のイラスト</option>
                        <option name="categoryName" value="10">その他のイラスト</option>
			</select><br>
            データ本体<input type="file" name="itemDataPath" required><br>
            <input type="radio" name="itemIsOpen" value="1" checked>公開
            <input type="radio" name="itemIsOpen" value="0">非公開
            <input type="submit" value="登録">
        </form>
        -->
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