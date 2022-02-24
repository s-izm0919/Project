<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー編集画面</title>
<%@include file="../../../css/settings.css" %>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
		<link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+P+One&display=swap" rel="stylesheet">
<script>
		(window.onload = function() {

    		if(${result['duplicateCheck']} == true){
    			console.log("dep動いてる");
    			document.getElementById("nginfo").innerHTML = "そのメールアドレスはすでに使われています";
    		}

    		if(${result['ngpass']} == true){
    			console.log("動いてる");
    			document.getElementById("ngpass").innerHTML = "パスワードが違います";
    		}
    	})();
</script>
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
						greet.innerHTML = '<li><select name="select" onChange="location.href=value;"><option value="#">${user.userName}</option><option value="callusersettings">ユーザーアカウント設定</option><option value="calldeposite">入金</option><option value="uders_orders">購入履歴</option><option value="shopopen">ショップ開設ガイド</option><option value="logoutuser">ログアウト</option><option value="callindex">デバック</option></select></li>';
						if(shop != ""){
							console.log("if文2");
								greet.innerHTML = '<li><select name="select" onChange="location.href=value;"><option value="#">${user.userName}</option><option value="callusersettings">ユーザーアカウント設定</option><option value="calldeposite">入金</option><option value="displaypurchaseditem">購入履歴</option><option value="callshoptop">ショップ管理</option><option value="logoutuser">ログアウト</option><option value="callindex">デバック</option></select></li>';
						}else{
							console.log("userのみ");

						}
					}
					else{
						console.log("else");
						greet.innerHTML = '<li><a href="callnew">ユーザー登録</a></li><li><a href="callsigninpage">ログイン</a></li>';
					}
					</script>

		        <!-- <li><a href="notification"><i class="far fa-bell"></i>お知らせ</a></li>

		        <li><a href="goodlist"><i class="far fa-heart"></i>いいね</a></li> -->


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
			<p id="delete">ユーザー情報を削除したい場合はパスワードを再入力してください</p>
			<form method="POST" action="removeaccount">
				<a class="color">パスワード</a><input type="text" name="userPassword"><br>
				<input type="submit" value="ユーザーを削除する"><br>
				<a> </a>
			</form>
			<p id="nginfo"></p>
			<p id="ngpass"></p>
		</div>
	</div>
	<footer>
		<h2> </h2>
		<div></div>
		<br>
   	</footer>
</body>
</html>