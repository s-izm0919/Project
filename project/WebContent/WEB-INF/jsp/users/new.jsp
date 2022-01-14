<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>ユーザー登録</title>
		<%@include file="../../../css/new.css" %>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    </head>
    <body>
        <header>

    		<h1>
			<a href="top">
			<img src="<%=application.getRealPath("/")%>images\icon.jpg"></a>
			</h1>
			<nav class="hd-nav">
				<ul>
				<li>
		        <input type="text" name="search" value="検索" >
		        </li>

				<li>
			        <select name="select" onChange="location.href=value;">

			            <option value="new">ユーザー登録</option>
			            <option value="sign_in">ログイン</option>
			            <option value="guide_shop">ショップ開設ガイド</option>
			            <option value="setting">ユーザーアカウント設定</option>
			            <option value="following">フォローしたショップ</option>
			            <option value="follow_items">フォローしたショップの新着商品</option>
			            <option value="users_chatlist">ショップとのチャット</option>
			            <option value="uders_orders">購入履歴</option>
			            <option value="shop_top">ショップ管理</option>
			            <option value="shop_items">商品管理</option>
			            <option value="shop_orders">注文一覧</option>
			            <option value="shop_sales">売上管理</option>
			            <option value="shop_chatlist">ユーザーとのチャット</option>
			            <option value="logoutuser">ログアウト</option>
			        </select>
					</li>

		        <li><a href="notification"><i class="far fa-bell"></i>お知らせ</a></li>

		        <li><a href="goodlist"><i class="far fa-heart"></i>いいね</a></li>


		        <li><a href="cart"><i class="fas fa-cart-arrow-down"></i>カート</a></li>

		        </ul>
	        </nav>
    </header>
<br><br><br><br><br><br>
	<div class="boxwrap">
		<div class="wrap pattern-3 mhb-20">

        <h1 class="yohaku">ユーザー登録</h1>
        <form method="POST" action="adduser">
           	<input type="text" name="userName" placeholder="ユーザー名" maxlength="20" required><br><br>
            <input type="text" name="userIdentifiedName" placeholder="ユーザーID（半角英数）" maxlength="20" pattern="^[a-zA-Z0-9]+$" required><br><br>
            <input type="password" name="userPassword" placeholder="パスワード（半角英数）" maxlength="20" pattern="^[a-zA-Z0-9]+$"  required><br><br>
            <input type="email" name="userMail" placeholder="メールアドレス" maxlength="300" required><br><br>
            <input type="submit" value="登録する">
        </form>
        </div>

	</div>

    </body>


</html>