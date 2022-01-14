<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			        	<option value="#">${user.userName}</option>
			            <option value="new">ユーザー登録</option>
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

    	<h2 class="future">
        	<p><img src="<%=application.getRealPath("/")%>images\toku.jpg"> &nbsp;</p>
        	<p><img src="<%=application.getRealPath("/")%>images\toku.jpg"> &nbsp;</p>
			<p><img src="<%=application.getRealPath("/")%>images\toku.jpg"></p>
        </h2>

        <h3 class="history">閲覧履歴</h3>

        <ul class="historyimg">
		  <c:forEach begin="1" end="10" step="1" var="i">
		    <li class="flex-item item${i}"><img src="<%=application.getRealPath("/")%>images\rireki.jpg" width="50" height="50"></li>
		  </c:forEach>
		  <button type="button" >もっと見る</button>
		</ul>・漫画、イラスト

	<ul>
        <li>壁紙</li>
        <li>漫画作品</li>
         <li>人物(漫画)</li>
        <li>動物(漫画)</li>
        <li>漫画(その他)</li>
        <li>人物(イラスト)</li>
        <li>動物(イラスト)</li>
        <li>風景(イラスト)</li>
        <li>イラスト(その他)</li>
	</ul>



















・写真

風景(写真)

人物(写真)

動物(写真)

集合

アート写真

モノクロ

写真(その他)

<h1>イラスト作品</h1>

	
    </body>
    <footer>
        <p>ガイドページガイドページガイドページお知らせページ</p>
        <p>ガイドページガイドページガイドページお問い合わせメアド</p>
    </footer>
</html>