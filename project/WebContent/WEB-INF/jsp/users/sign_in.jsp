<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>ログインページ</title>
        <%@include file="../../../css/sign_in.css" %>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
    </head>
    <body>
          <header>

    		<h1>
			<a href="top">
			<img src="<%=application.getRealPath("/")%>images\icon.jpg"></a>
			</h1>
			<nav class="hd-nav">
				<ul>
				<li>
		        <input type="text" name="search" value="検索" >
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
       		<h1 class="yohaku">ログイン</h1>
       			<form method="POST" action="/project${requestScope.target}">
           			<input type="text" name="userIdenNameOrEmail"  placeholder="ユーザーIDまたはメールアドレス"><br><br>
           			<input type="password" name="userPassword" placeholder="パスワード" required><br><br>
           			<input type="submit" value="ログイン"><br><br>
           			<a href="forgetpassword" class="help">パスワードをお忘れのの方</a><br>
           			<a href="callnew" class="help">アカウントをお持ちでない方</a>
        		</form>
        	</div>
        </div>
    </body>
</html>