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
	<h1>簡易ページリンク一覧(html式)</h1>
	user名:${user.userName}
	<br>
	shop名:${shop }
	<h1>簡易ページリンク一覧(未作成はhtml方式)</h1>
	user名:${user.userName}
	<a href=""></a>
	<p>ユーザー系</p>
	<a href="callnew">ユーザー登録</a>
	<a href="callsigninpage">ログイン</a>
	<a href="logoutuser">ログアウト</a>
	<a href="callforgotpassword">パスワードの再発行</a>
	<a href="callusersettings" >ユーザーの編集</a>
	<a href="users/deposite.jsp">入金</a>
	<a href="users/following.jsp">フォローしたショップ</a>
	<a href="top">トップ</a>
	<p>商品関係</p>
	<form method="POST" action="searchitem">
    	アイテム検索項目<input type="text" name="itemName" maxlength="20" ><br>
      			<input type="submit" value="検索">
   	</form>商品検索ページ
   	<br>
   		<form method="POST" action="searchshop">
    	ショップ検索項目<input type="text" name="shopName" maxlength="20" ><br>
      			<input type="submit" value="検索">
   	</form>商品検索ページ
	<a href="callitempage">商品ページ</a>
	<a href="users/goodlist">いいねした商品</a>
	<a href="users/follownewitems.jsp">フォローしたショップの商品</a>
	<a href="carts.jsp">カート</a>
	<p>ショップ</p>
	<a href="shopopen">ショップ開設ガイド</a>
	<a href="callopen">ショップ解説ページ</a>
	<a href="callshopsettings">ショップ管理</a>
	<a href="shop/setting">ショップ情報編集</a>
	<a href="shop/items.jsp">商品管理</a>
	<a href="additem">商品登録</a>
	<a href="shop/itwems/edit.jsp">商品編集</a>
	<a href="shop/orders_list.jsp">注文一覧</a>
	<a href="users/orders">注文詳細</a>
	<a href="shop/sales.jsp">売上管理</a>
	<a href="shop/chatlist.jsp">ユーザーとのチャット一覧</a>
	<a href=""></a>
	<p>いずみ</p>
	<a href="try">実験</a><br>
	${result["item"].itemName}<br>
	${result["item"].itemPrice }<br>
	<c:forEach var="list" items='${result["list"]}'>
        <th><c:out value="${list}"/></th>
        </c:forEach>

	<a href="callsearch">あ</a>
	<a href="callitempage">a</a>


</body>
</html>