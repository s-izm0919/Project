<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ページ移動画面</title>
</head>
<body>
	<h1>簡易ページリンク一覧(html式)</h1>
	user名:${result.userName}
	<a href=""></a>
	<p>ユーザー系</p>
	<a href="new">ユーザー登録</a>
	<a href="callsigninpage">ログイン</a>
	<a href="logoutuser">ログアウト</a>
	<a href="users/pass_reissue.jsp">パスワードの再発行</a>
	<a href="callusersettings" >ユーザーの編集</a>
	<a href="users/deposite.jsp">入金</a>
	<a href="users/following.jsp">フォローしたショップ</a>
	<a href="top">トップ</a>
	<p>商品関係</p>
	<a href="search.jsp">検索結果</a>
	<a href="items">商品ページ</a>
	<a href="users/goodlist">いいねした商品</a>
	<a href="users/follownewitems.jsp">フォローしたショップの商品</a>
	<a href="carts.jsp">カート</a>
	<p>ショップ</p>
	<a href="guide/shop.jsp">ショップ開設ガイド</a>
	<a href="open">ショップ解説ページ</a>
	<a href="shop/top.jsp">ショップ管理</a>
	<a href="shop/setting">ショップ情報編集</a>
	<a href="shop/items.jsp">商品管理</a>
	<a href="shop/items/register.jsp">商品登録</a>
	<a href="shop/itwems/edit.jsp">商品編集</a>
	<a href="shop/orders_list.jsp">注文一覧</a>
	<a href="users/orders">注文詳細</a>
	<a href="shop/sales.jsp">売上管理</a>
	<a href="shop/chatlist.jsp">ユーザーとのチャット一覧</a>
	<a href=""></a>
</body>
</html>