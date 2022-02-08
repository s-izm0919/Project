<!-- これは検索結果のJSPです。 -->

<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>商品検索結果</title>
		<%@include file="../../../css/search.css" %>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
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
<<<<<<< HEAD
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

=======
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
				            <option value="callshoptop">ショップ管理</option>
				            <option value="shopitemdetails">商品管理</option>
				            <option value="showshoporders">注文一覧</option>
				            <option value="shop_sales">売上管理</option>
				            <option value="shop_chatlist">ユーザーとのチャット</option>
				            <option value="callopen">ショップ解説ページ</option>
				            <option value="logoutuser">ログアウト</option>
				        </select>
				</li>
>>>>>>> branch 'JSP' of git@github.com:s-izm0919/Project.git

		        <li><a href="notification"><i class="far fa-bell"></i>お知らせ</a></li>

		        <li><a href="goodlist"><i class="far fa-heart"></i>いいね</a></li>

		        <li><a href="cart"><i class="fas fa-cart-arrow-down"></i>カート</a></li>

		        </ul>
	        </nav>
    </header>

    <br><br><br><br>

        <h1>商品一覧</h1>
   		<br>

 <div class="nonemargin">
 	<div class="example">
    	<div class="a">
			<div class="wrapleft">
 				<div class="color">
 				<p>検索設定</p>
				<form method="POST" action="searchitemdetail">
    				<input type="hidden" name="searchword" value="${result['searchword']}">
    				<p>カテゴリ</p>
					<div class="cp_ipselect cp_sl01">
						<select name="category">
							<option value="0">指定なし</option>
							<option value="1">風景・自然の写真</option>
							<option value="2">人物・キャラクターの写真</option>
							<option value="3">食べ物の写真</option>
							<option value="4">植物・動物の写真</option>
							<option value="5">その他の写真</option>
							<option value="6">風景・自然のイラスト</option>
							<option value="7">人物・キャラクターのイラスト</option>
							<option value="8">食べ物のイラスト</option>
							<option value="9">植物・動物のイラスト</option>
							<option value="10">その他のイラスト</option>
							</select><br>
					</div>
    				<p>ソート</p><!-- 1:新着 2:いいね順 3:価格が高い順 4:価格が低い順-->

					<div class="cp_ipselect cp_sl01">
						<select name="sort">
							<option value="1">新着</option>
							<option value="2">いいね順</option>
							<option value="3">価格が高い順</option>
							<option value="4">価格が低い順</option>
						</select><br>
					</div>
					<a>金額</a><br>
					<p>\0 ～ \<span id="current-value" name="maxprice"></span></p>
					<input type="range" id="Money" name="maxprice" min="0" max="5000" step="250" value="5000">
					<script>
						const inputElem = document.getElementById('Money'); // input要素
						const currentValueElem = document.getElementById('current-value'); // 埋め込む先のspan要素

						// 現在の値をspanに埋め込む関数
						const setCurrentValue = (val) => {
							var money = Money.value;
	  						if(money > 4900)
	  						{
		  						currentValueElem.innerText = val + '+';
	  						}else{
		  						currentValueElem.innerText = val;
	 						}
						}

						// inputイベント時に値をセットする関数
						const rangeOnChange = (e) =>{
  							setCurrentValue(e.target.value);
						}
						window.onload = () => {
  							inputElem.addEventListener('input', rangeOnChange); // スライダー変化時にイベントを発火
  							setCurrentValue(inputElem.value); // ページ読み込み時に値をセット
						}


						</script><br><br>


					<input type="submit" value="検索">
				</form>
				</div>
			</div>
		</div>
		<div class="b">
			<div class="boxwrap">
				<div class="wrap pattern-3 mhb-20">
					<div class="color">
        				<h1>商品一覧</h1><br>
				   		対象商品が  ${result["itemcount"]}  件ヒットしました。
   						<table border="1">
        					<c:forEach var="item" items="${result['itemsearch']}">
            					<tr>
                					<td>${item.mainImagePath}</td>
                					<td><a href="callitempage?itemId=${item.itemId}">アイテム詳細情報へ${item.itemId}</a></td>
                					<td>${item.itemName}</td>
                					<td>${item.itemPrice}</td>
                					<td><a href="shopinfo?shopId=${item.shopId}">ショップ詳細情報へ${item.shopId}</td>
                					<td>${item.shopName}</td>
	                				<!--使わない<td><a href="addcart?itemId=${item.itemId}">カートに入れる</a>-->
    	        				</tr>
        					</c:forEach>
        				</table>
        			</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>