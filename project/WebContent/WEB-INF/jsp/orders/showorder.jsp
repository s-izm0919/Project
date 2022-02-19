<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>注文完了</title>
		<%@include file="../../../css/new.css" %>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
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
    <body>
	<br><br><br><br>

	<h1>注文完了画面</h1>

	注文者からのメッセージ:<c:out value="${result['ordercomplete'][0].shopExplanation}"/><br>
	注文番号:<c:out value="${result['ordercomplete'][0].orderId}"/><br>

	<br><br>
		<div class="boxwrap">
			<div class="wrap pattern-3 mhb-20 color">
			<p>購入した商品</p>
				<c:forEach var="item" items="${result['ordercomplete']}">
					<a href="showorderdetail?itemId=${item.itemId}">商品名:<c:out value="${item.itemName}"/></a><br>
					<c:out value="-----------------------------------------"/><br>
				</c:forEach>
		     </div>
		</div>

		<button type="button" onclick="location.href='displaypurchaseditem'">注文一覧を見る</button>
		<button type="button" onclick="location.href='top'">トップへ戻る</button>

    </body>


</html>
