<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+P+One&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<title>パスワードの再発行</title>
		<%@include file="../../../css/reissue.css" %>
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

		        <li><a href="callnew">ユーザー登録</a></li>


		        <li><a href="callsigninpage">ログイン</a></li>
		        <li><a href="cart"><i class="fas fa-cart-arrow-down"></i>カート</a></li>

		        </ul>
	        </nav>
    </header>
	<br><br><br><br>
	<div class="boxwrap">
		<div class="wrap pattern-3 mhb-20 color">
			<h1>パスワードの再発行</h1>
			<form method="POST" action="passwordremainder">
				<p>パスワードの再発行には、自身の登録しているメールアドレスを入力してください。</p>
				<input type="email" placeholder="メールアドレス"   name="email">
				<input type="submit" value="登録">
			</form>
		</div>
	</div>
	<footer>
			<h2> </h2>
			<div></div>
			<br>
    	</footer>
</body>
</html>