<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>注文確認</title>
		<%@include file="../../../css/new.css" %>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    </head>
    <script>
    	var userPoint = 0;
    	var amountPay = 0;
    	(window.onload = function() {
	    	userPoint = parseInt(${result['confirmorder'][0].userPoint});
	    	amountPay = parseInt(${result['confirmorder'][0].orderPrice});
			if(userPoint < amountPay){
				document.getElementById("submit_button").setAttribute('disabled', true);
				document.getElementById("notenough").innerHTML = "ポイントが足りません";

			}

	    })();

    	function check(){
			var boostPay = parseInt(document.getElementById("boost").value);
			console.log(boostPay);
				if(userPoint < boostPay+amountPay){
					window.alert('ユーザーポイントが足りません');
					return false; // 送信を中止
				}else{
		    		if(window.confirm('購入を確定します。よろしいですか？')){ // 確認ダイアログを表示

		    			return true; // 「OK」時は送信を実行

		    		}
		    		else{ // 「キャンセル」時の処理

		    			window.alert('キャンセルされました'); // 警告ダイアログを表示
		    			return false; // 送信を中止

		    		}
				}
    	}
    </script>
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
						greet.innerHTML = '<li><select name="select" onChange="location.href=value;"><option value="#">${user.userName}</option><option value="callusersettings">ユーザーアカウント設定</option><option value="calldeposite">入金</option><option value="displaypurchaseditem">購入履歴</option><option value="shopopen">ショップ開設ガイド</option><option value="logoutuser">ログアウト</option><option value="callindex">デバック</option></select></li>';
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
			        <li><a href="callcart"><i class="fas fa-cart-arrow-down"></i> カート</a></li>
		        </ul>
	        </nav>
    </header>
<br><br><br><br>


	<h1>注文確認画面</h1>
	<p>注文内容をご確認ください</p>
		<div class="boxwrap">
			<div class="wrap pattern-3 mhb-20 color">
				ショップ名:<c:out value="${result['confirmorder'][0].shopName}"/><br><br>
				合計支払金額：<c:out value="${result['confirmorder'][0].orderPrice}"/>円<br>
				注文件数:<c:out value="${result['confirmorder'][0].orderCount}"/><br>
				---------------------------------------<br>

				<c:forEach var="order" items="${result['confirmorder']}">
					商品名：<c:out value="${order.itemName}"/><br>
					商品価格：<c:out value="${order.totalPayment}"/>円<br>
					<c:out value="---------------------------------------"/><br>
				</c:forEach>
		     </div>
		</div>
		<div class="boxwrap">
			<div class="wrap pattern-3 mhb-20 color">
			あなたのポイント:<c:out value="${result['confirmorder'][0].userPoint}"/><br>
			<a href="calldeposite">入金画面へ</a><br><br>
			<form action="confirmorder?shopId=${requestScope.shopId}" method="POST" onSubmit="return check()">
				ブースト金額を入力<br>
				<input type="number" name="boost" min="0" max="1000000" value="0" id="boost"/>
				<input id="submit_button" type="submit" value="購入する" /><br>
				<div id="notenough"></div>
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



