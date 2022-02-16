<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>購入商品一覧</title>
		<%@include file="../../../../css/new.css" %>
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

		        <li><a href="notification"><i class="far fa-bell"></i>お知らせ</a></li>

		        <li><a href="goodlist"><i class="far fa-heart"></i>いいね</a></li>


		        <li><a href="cart"><i class="fas fa-cart-arrow-down"></i>カート</a></li>

		        </ul>
	        </nav>
    </header>
<br><br><br><br>
	<div class="boxwrap">
		<div class="wrap pattern-3 mhb-20">

        <h1>注文一覧</h1>
		<table border="1">
		<tr>
		 <th>商品イメージ</th>
		 <th>商品名</th>
		 <th>購入日時</th>
		</tr>
		<c:forEach var="item" items="${result['purchasedItemResult']}">
			<tr>
			<td><img src="upload/${item.itemImagePath}"></td>
				<td><a href="callitempage?itemId=${item.itemId}">${item.itemName}</a></td>
				<td>${item.purchaseDate}</td>
				 <td><a href="showorderdetail?itemId=${item.itemId}">詳細を見る</a></td>
			</tr>
		</c:forEach>
		</table>
        </div>

	</div>

    </body>


</html>
