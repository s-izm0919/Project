<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>トップページ</title>
		<link rel="stylesheet" href="css/top.css">
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
				            <option value="callshoptop">ショップ管理</option>
				            <option value="shopitemdetails">商品管理</option>
				            <option value="showshoporders">注文一覧</option>
				            <option value="shop_sales">売上管理</option>
				            <option value="shop_chatlist">ユーザーとのチャット</option>
				            <option value="callopen">ショップ解説ページ</option>
				            <option value="logoutuser">ログアウト</option>
				            <option value="callindex">デバック</option>
				        </select>
					</li>
			        <li><a href="notification"><i class="far fa-bell"></i> notice</a></li>
			        <li><a href="goodlist"><i class="far fa-heart"></i> like</a></li>
			        <li><a href="callcart"><i class="fas fa-cart-arrow-down"></i> cart</a></li>
		        </ul>
	        </nav>
    </header>

    	<h2 class="future">
        	<p><img src="images\toku.jpg"> &nbsp;</p>
        	<p><img src="images\toku.jpg"> &nbsp;</p>
			<p><img src="images\toku.jpg"></p>
        </h2>

        <br>

        <h2 class="history">history</h2>

        <ul class="historyimg">
		  <c:forEach begin="1" end="5" step="1" var="item" items="${result['historyList']}">
		    <li><a href="callitempage?itemId=${item.itemId}"><img src='upload/${item.mainImagePath}'></a></li>
		  </c:forEach>
		</ul>

		<h1 class="cate_title">category</h1>
		<h2>photograph</h2>

		<div class="cate">

			<div class="cate_child">
				<img src="images\category_01.jpg" class="ca">
				<div class="mask">
					<div class="caption"><a href="searchcategory?categoryId=1">nature</a></div>
				</div>
			</div>

			<div class="cate_child">
				<img src="images\category_02.jpg" class="ca">
				<div class="mask">
					<div class="caption"><a href="searchcategory?categoryId=2">human</a></div>
				</div>
			</div>

			<div class="cate_child">
				<img src="images\category_03.jpg" class="ca">
				<div class="mask">
					<div class="caption"><a href="searchcategory?categoryId=3">food</a></div>
				</div>
			</div>

			<div class="cate_child">
				<img src="images\category_04.jpg" class="ca">
				<div class="mask">
					<div class="caption"><a href="searchcategory?categoryId=4">Animals and plants</a></div>
				</div>
			</div>

			<div class="cate_child">
				<img src="images\category_05.jpg" class="ca">
				<div class="mask">
					<div class="caption"><a href="searchcategory?categoryId=5">other</a></div>
				</div>
			</div>

		</div>

		<h2>illustration</h2>

		<div class="cate">

			<div class="cate_child">
				<img src="images\category_06.jpg" class="ca">
				<div class="mask">
					<div class="caption"><a href="searchcategory?categoryId=6">nature</a></div>
				</div>
			</div>

			<div class="cate_child">
				<img src="images\category_07.jpg" class="ca">
				<div class="mask">
					<div class="caption"><a href="searchcategory?categoryId=7">human</a></div>
				</div>
			</div>

			<div class="cate_child">
				<img src="images\category_08.jpg" class="ca">
				<div class="mask">
					<div class="caption"><a href="searchcategory?categoryId=8">food</a></div>
				</div>
			</div>

			<div class="cate_child">
				<img src="images\category_09.jpg" class="ca">
				<div class="mask">
					<div class="caption"><a href="searchcategory?categoryId=9">Animals and plants</a></div>
				</div>
			</div>

			<div class="cate_child">
				<img src="images\category_10.jpg" class="ca">
				<div class="mask">
					<div class="caption"><a href="searchcategory?categoryId=10">other</a></div>
				</div>
			</div>
		</div>
		<br>
		<br>
		<br>
		<footer>
			<h2>guide page</h2>
			<div><a href="shopopen">shop open</a></div>
			<br>
    	</footer>
    </body>

</html>