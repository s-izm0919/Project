<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>ショップ管理ページ-</title>
        <%@include file="../../../css/shoptop.css" %>
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
				            <option value="shop_top">ショップ管理</option>
				            <option value="shop_items">商品管理</option>
				            <option value="shop_orders">注文一覧</option>
				            <option value="shop_sales">売上管理</option>
				            <option value="shop_chatlist">ユーザーとのチャット</option>
				            <option value="callopen">ショップ解説ページ</option>
				            <option value="logoutuser">ログアウト</option>
				        </select>
					</li>
			        <li><a href="notification"><i class="far fa-bell"></i> notice</a></li>
			        <li><a href="goodlist"><i class="far fa-heart"></i> like</a></li>
			        <li><a href="cart"><i class="fas fa-cart-arrow-down"></i> cart</a></li>
		        </ul>
	        </nav>
    </header>
    <br>
    	<div class="siro">
        <h1>ショップ管理ページ</h1>
        <ul class="d">
			<p><a href="top">ショップ管理のページ</a></p>
			<p><a href="open">ショップ情報編集のページ</a></p>
	    	<p><a href="item">商品管理のページ</a></p>
		    <p><a href="orders">注文一覧ページ</a></p>
    		<p><a href="open">売上管理ページ</a></p>
		    <p><a href="chat_list">ユーザーとのチャット一覧ページ</a></p>
		</ul>
		</div>
    </body>
</html>