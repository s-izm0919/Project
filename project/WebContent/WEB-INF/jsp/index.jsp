<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ページ移動画面</title>
</head>
<body>

	<h1>簡易ページリンク一覧(未作成はhtml方式)</h1>
	user名:${user.userName}<br>
	shop名:${shop.shopName}
	<a href=""></a>
	<p>ユーザー系</p>
	<a href="callnew">ユーザー登録</a>
	<a href="callsignin">ログイン</a>
	<a href="logoutuser">ログアウト</a>
	<a href="callforgotpassword">パスワードの再発行</a>
	<a href="callusersettings" >ユーザーの編集</a>
	<a href="calldeposite">入金</a>
	<a href="top">トップ</a>
	<a href="vieweditem">閲覧履歴</a>

		<p>ユーザー注文管理</p>

	<a href="displaypurchaseditem">注文一覧</a>
	<a href="callcart">カート</a>


	<p>商品関係</p>
	<form method="POST" action="searchitem">
    	アイテム検索項目<input type="text" name="itemName" maxlength="20" ><br>
      			<input type="submit" value="検索">
   	</form>商品検索ページ
   	<br>
   		<form method="POST" action="searchshop">
    	ショップ検索項目<input type="text" name="shopName" maxlength="20" ><br>
      			<input type="submit" value="検索">
      	</form>

	<!--
	<a href="users/goodlist">いいねした商品</a>
	<a href="users/follownewitems.jsp">フォローしたショップの商品</a>
	<a href="callcart">カート</a>
	-->

	<p>ショップ</p>
	<a href="callopen">ショップ開設ページ</a>
	<a href="shopinfo?shopId=S1">ショップ情報を見る※サンプルなので強制的にs1を表示</a>
	<a href="callshopsettings">ショップ情報を編集する</a>
	<a href="calldisplayitem">商品登録</a>
	<a href="shopitemdetails">商品一覧</a>
	<a href="showshoporders">受注した注文一覧</a>
	<a href="">売上管理（月単位）</a>
	<a href="">商品別売上管理</a>


<!--
	<p>いずみ</p>
	<a href="try">実験</a><br>
	${result["item"].itemName}<br>
	${result["item"].itemPrice }<br>
	<c:forEach var="list" items='${result["list"]}'>
        <th><c:out value="${list}"/></th>
        </c:forEach>
-->

	<br><br><br><br>
	<a href="callsearch">あ</a>
	<a href="callitempage">商品ページ</a>
	<br>
	<a href="calldeposite">商品ページ</a>
	<a href="calldepositeresult">商品ページ</a>
	<a href="callshoptop">shoptop</a>
<a href="shopinfo">ショップ情報を見る</a>
</body>
</html>