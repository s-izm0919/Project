<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page isELIgnored="false"%>
<html>
    <head>
        <title>ショップ管理ページ-</title>
        <%@include file="../../../../css/shopearning.css" %>
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
						greet.innerHTML = '<li class="li1"><a href="callnew">登録</a></li><li class="li2"><a href="callsigninpage">ログイン</a></li>';
					}
					</script>
			        <li><a href="cart"><i class="fas fa-cart-arrow-down"></i> カート</a></li>
		        </ul>
	        </nav>
    </header>
    <br>
        <h1>${shop.shopName}のショップ管理ページ</h1>
	        <div class="cont_nav size1 ">
				<a class="backgra false" href="callshoptop">商品登録</a>
				<a class="backgra false" href="callshopsettings">ショップ情報編集</a>
		    	<a class="backgra false" href="shopitemdetails">商品管理</a>
			    <a class="backgra false" href="showshoporders">注文一覧</a>
	    		<a class="backgra true" href="showshopearning">売上管理</a>
			</div>
			<br>
			<div class="content">
				<div class="boxwrap">
		<div class="wrap pattern-3 mhb-20 color">
        <h1>売上管理</h1>

        <!-- 今月の処理 -->
        <div id="thisMonth">
        <h2>今月の売上明細</h2>
        <!-- formの属性に[enctype="multipart/form-data"]を追加しました。 -->
        <table border="1">
		<tr>
		 <th>売上金額</th>
		 <th>ブースト金額</th>
		 <th>売上日時</th>
		</tr>
		<c:forEach var="item" items="${result['shopEarning']}">

			<tr>
				<td>${item. totalPayment}</td>
				<td>${item. boostAmount}</td>
				<td>${item.purchaseDate}</td>
				<td nowrap><a href="showsingleorderdetails?orderId=${item.orderId}">注文詳細を見る</a></td>
			</tr>
		</c:forEach>
		</table>


			<h2>今月の合計売上</h2>
			今月の売上金額<p>${result['totalEarning']}円</p><br>
			<button type="button" onclick="changeMonth(1)">前月の売上を見る</button>
		</div>

		<!-- 前月の処理 -->
		<div id="lastmonth">
		<h2>前月の売上明細</h2>
        <!-- formの属性に[enctype="multipart/form-data"]を追加しました。 -->
        <table border="1">
		<tr>
		 <th>売上金額</th>
		 <th>ブースト金額</th>
		 <th>売上日時</th>
		</tr>
		<c:forEach var="item" items="${result['lastMonthEarning']}">

			<tr>
				<td>${item. totalPayment}</td>
				<td>${item. boostAmount}</td>
				<td>${item.purchaseDate}</td>
				<td nowrap><a href="showsingleorderdetails?orderId=${item.orderId}">注文詳細を見る</a></td>
			</tr>
		</c:forEach>
		</table>


			<h2>前月の合計売上</h2>
			前月の売上金額<p>${result['lastMonthTotalEarning']}円</p><br>
			<button type="button" onclick="changeMonth(0)">今月の売上を見る</button>
		</div>

        </div>
        </div>
		</div>
			<br>
			<footer>
			<h2> </h2>
			<div></div>
			<br>
    	</footer>
    </body>
     <script>
    	function changeMonth(number){
    		if(number == 0){
    			document.getElementById("thisMonth").style.display = "block";
    			document.getElementById("lastmonth").style.display = "none";
    		}
    		else{
    			document.getElementById("thisMonth").style.display = "none";
    			document.getElementById("lastmonth").style.display = "block";
    		}
    	}

    	(function(){
    		changeMonth(0);
    	}());
    </script>
</html>