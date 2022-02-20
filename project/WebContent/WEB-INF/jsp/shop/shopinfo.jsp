<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    	<link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+P+One&display=swap" rel="stylesheet">
        <title>ショップ情報</title>
        <%@include file="../../../css/shopinfo.css" %>
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

	    (window.onload = function() {
    		if("${requestScope.error}" == "error"){
    			document.getElementById("error").innerHTML = "ログイン情報が間違っています";
    		}
    	})();
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
       		<h1 class="yohaku">ショップ情報</h1>

				<p>ショップ名:${result['shopInfo'].shopName}</p>
				<p>ショップの説明:${result['shopInfo'].shopExplanation}</p>

				<table border="1">
				<tr>
					<th>商品イメージ</th>
					<th>商品名</th>
					<th>価格</th>
				</tr>

				<c:forEach var="itemlist" items="${result['itemList'] }">

					<tr>
					<td><a href="callitempage?itemId=${itemlist.itemId}"><img src='upload\<c:out value="${itemlist.mainImagePath}"/>'></a></td>
					<td><c:out value="${itemlist.itemName }"/></td>
					<td><c:out value="${itemlist.itemPrice }"/></td>
					</tr>
					</a>
				</c:forEach>
				</table>

        	</div>
        </div>
    </body>
</html>