<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>トップページ</title>
		<%@include file="../../css/top.css" %>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
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
		</ul>

		<h1 class="cate_title">カテゴリー</h1>
		<h2>illustration</h2>

		<div class="cate">

			<div class="cate_human">
				<img src="<%=application.getRealPath("/")%>images\human.jpg" class="human">
				<div class="mask">
					<div class="caption">人物</div>
				</div>
			</div>

			<div class="cate_animal">
				<img src="<%=application.getRealPath("/")%>images\animal.jpg" class="animal">
				<div class="mask">
					<div class="caption">動物</div>
				</div>
			</div>

			<div class="cate_wallpaper">
				<img src="<%=application.getRealPath("/")%>images\wallpaper.jpg" class="wallpaper">
				<div class="mask">
					<div class="caption">壁紙</div>
				</div>
			</div>

			<div class="cate_comic">
				<img src="<%=application.getRealPath("/")%>images\comic.jpg" class="comic">
				<div class="mask">
					<div class="caption">漫画</div>
				</div>
			</div>

			<div class="cate_other">
				<img src="<%=application.getRealPath("/")%>images\other.jpg" class="other">
				<div class="mask">
					<div class="caption">その他</div>
				</div>
			</div>

		</div>

		<h2>photograph</h2>

		<div class="cate">

			<div class="cate_human-p">
				<img src="<%=application.getRealPath("/")%>images\human-p.jpg" class="human-p">
				<div class="mask">
					<div class="caption">人物</div>
				</div>
			</div>

			<div class="cate_animal-p">
				<img src="<%=application.getRealPath("/")%>images\animal-p.jpg" class="animal-p">
				<div class="mask">
					<div class="caption">動物</div>
				</div>
			</div>

			<div class="cate_landscape">
				<img src="<%=application.getRealPath("/")%>images\landscape.jpg" class="landscape">
				<div class="mask">
					<div class="caption">風景</div>
				</div>
			</div>

		</div>
    </body>
    <footer>
        <p>ガイドページガイドページガイドページお知らせページ</p>
        <p>ガイドページガイドページガイドページお問い合わせメアド</p>
    </footer>
</html>