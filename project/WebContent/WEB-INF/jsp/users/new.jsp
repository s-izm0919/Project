<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>ユーザー登録</title>
		<%@include file="../../../css/new.css" %>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
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

		        <li><a href="callnew">ユーザー登録</a></li>

		        <li><a href="callsigninpage">ログイン</a></li>

		        <li><a href="notification"><i class="far fa-bell"></i>お知らせ</a></li>

		        <li><a href="goodlist"><i class="far fa-heart"></i>いいね</a></li>


		        <li><a href="cart"><i class="fas fa-cart-arrow-down"></i>カート</a></li>

		        </ul>
	        </nav>
    </header>
<br><br><br><br>
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