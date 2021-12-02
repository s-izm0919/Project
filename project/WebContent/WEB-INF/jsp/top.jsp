<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>トップページ</title>
		<%@include file="../../css/top.css" %>
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
			        	<option value="#">ユーザー名</option>
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
			            <option value="">ログアウト</option>
			        </select>
					</li>

		        <li><a href=notification""><i class="far fa-bell"></i>お知らせ</a></li>

		        <li><a href="goodlist"><i class="far fa-heart"></i>いいね</a></li>


		        <li><a href="cart"><i class="fas fa-cart-arrow-down"></i>カート</a></li>

		        </ul>
	        </nav>
    </header>

    	<h1 class="future">
        	特集ページ左 &nbsp; 特集ページ中 &nbsp; 特集ページ右
        </h1>

        <h1>閲覧履歴 &nbsp; もっと見る</h1>

        <p>カテゴリ&nbsp;&nbsp;カテゴリ&nbsp;&nbsp;カテゴリ&nbsp;&nbsp;カテゴリ&nbsp;&nbsp;カテゴリ</p>
        <p>カテゴリ&nbsp;&nbsp;カテゴリ&nbsp;&nbsp;カテゴリ&nbsp;&nbsp;カテゴリ&nbsp;&nbsp;カテゴリ</p>
        <p>カテゴリ&nbsp;&nbsp;カテゴリ&nbsp;&nbsp;カテゴリ&nbsp;&nbsp;カテゴリ&nbsp;&nbsp;カテゴリ</p>
        <p>カテゴリ&nbsp;&nbsp;カテゴリ&nbsp;&nbsp;カテゴリ&nbsp;&nbsp;カテゴリ&nbsp;&nbsp;カテゴリ</p>
        <p>カテゴリ&nbsp;&nbsp;カテゴリ&nbsp;&nbsp;カテゴリ&nbsp;&nbsp;カテゴリ&nbsp;&nbsp;カテゴリ</p>
    </body>
    <footer>
        <p>ガイドページガイドページガイドページお知らせページ</p>
        <p>ガイドページガイドページガイドページお問い合わせメアド</p>
    </footer>
</html>