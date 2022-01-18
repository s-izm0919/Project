<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー編集画面</title>
<%@include file="../../../css/settings.css" %>
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
			        	<option value="#">${user.userName}</option>
			            <option value="callnew">ユーザー登録</option>
			            <option value="callsigninpage">ログイン</option>
			            <option value="guide_shop">ショップ開設ガイド</option>
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

		        <li><a href="notification"><i class="far fa-bell"></i>お知らせ</a></li>

		        <li><a href="goodlist"><i class="far fa-heart"></i>いいね</a></li>


		        <li><a href="cart"><i class="fas fa-cart-arrow-down"></i>カート</a></li>

		        </ul>
	        </nav>
    </header>
<br><br><br>
	<div class="boxwrap">
		<div class="wrap pattern-3 mhb-20">
			<h1 class="yohaku">ユーザー編集画面</h1>
			<form method="POST" action="editaccount">
				<input type="hidden" name="userId"  value="${user.userId}" ><br>
				<input type="hidden" name="userIdentifiedName" maxlength="20" value="${user.userIdentifiedName}" ><br>
				<a class="color">ユーザー名の変更</a><input type="text" name="userName" maxlength="20" value="${user.userName}" required><br>
				<a class="color">メールアドレスの変更</a><input type="email" name="mail" maxlength="300"  value="${user.userMail}"  required><br>
				<input type="submit" value="更新"><br><br>
			</form>
			<form method="POST" action="removeaccount">
				<a class="color">ユーザーの削除</a><input type="text" name="userPassword"><br>
				<input type="submit" value="ユーザーを削除する"><br>
				<a>　</a>
			</form>
		</div>
	</div>
</body>
</html>