<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>ログインページ</title>
        <%@include file="../../../css/sign_in.css" %>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
		<script type="text/javascript">
	    function getdata(){
	        if(window.location.search){
	            /* URLの「?」以降のパラメータを変数nに代入 */
	            var n=window.location.search.substring(0,window.location.search.length);
	            var par = "/project${requestScope.target}"+n;
	            /* テキストボックスにパラメータを表示 */
	            //document.form3.elements["getpram"].value=par;
	            document.form.action=par;
	        }
	    }
	    /* オンロード時に実行 */
	    window.onload=getdata;

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
       			<form method="POST" action="callsigninpage" name="form">
           			<input type="text" name="userIdenNameOrEmail"  placeholder="ユーザーIDまたはメールアドレス"><br><br>
           			<input type="password" name="userPassword" placeholder="パスワード" required><br><br>
           			<input type="submit" value="ログイン"><br><br>
           			<a href="callforgotpassword" class="help">パスワードをお忘れのの方</a><br>
           			<a href="callnew" class="help">アカウントをお持ちでない方</a>
        		</form>
        	</div>
        </div>
    </body>
</html>