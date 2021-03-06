<!-- これは検索結果のJSPです。 -->

<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>商品一覧</title>
		<%@include file="../../../css/search.css" %>
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
		        <li><a href="cart"><i class="fas fa-cart-arrow-down"></i>カート</a></li>

		        </ul>
	        </nav>
    </header>
    <br><br><br><br>

    <div class="example">
 		<div class="wrap">
 		<div class="color">
    			<div class="a">
    				<p>カテゴリ(大まかなカテゴリ)</p>


					<div class="cp_ipselect cp_sl01">
			        <select name="select" onChange="location.href=value;">
			        	<option value="#">指定なし</option>
			            <option >1</option>
			            <option >2</option>
			            <option >3</option>
			            <option >4</option>
			        </select><br>
					</div>
    				<p>サブカテゴリ(詳細なカテゴリ)</p>


					<div class="cp_ipselect cp_sl01">
			        <select name="select" onChange="location.href=value;">
			        	<option value="#">指定なし</option>
			            <option >1</option>
			            <option >2</option>
			            <option >3</option>
			            <option >4</option>
			        </select><br>
			        </div>
			        <a>金額</a><br>
			        <input type="range" name="speed" min="0" max="20">
			        </div>
			        </div>
			        </div>
		<div class="boxwrap">
			<div class="wrap pattern-3 mhb-20">
			<div class="color">
<div class="b">
        <h1>商品一覧</h1>
   		<br>

   		対象商品が  ${result["itemcount"]}  件ヒットしました。

   		<table border="1">

        <c:forEach var="item" items="${result['itemsearch']}">
            <tr>
                <td>${item.mainImagePath}</td>
                <td><a href="callitempage?itemId=${item.itemId}">${item.itemId}</a></td>
                <td>${item.itemName}</td>
                <td>${item.itemPrice}</td>
                <td>${item.shopName}</td>

            </tr>
        </c:forEach>


        </table>
		</div>
		</div>
		</div>
		</div>
</div>
<footer>
			<h2> </h2>
			<div></div>
			<br>
    	</footer>
    </body>
</html>