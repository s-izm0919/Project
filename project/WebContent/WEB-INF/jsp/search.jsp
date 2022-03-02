<!-- これは検索結果のJSPです。 -->

<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>商品検索結果</title>
		<%@include file="../../../css/search.css" %>
		<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
		<link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+P+One&display=swap" rel="stylesheet">
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
		<script type="text/javascript" src="../../../js/jquery.pagination.js"></script>
		<script type="text/javascript" src="../../../js/pagination.min.js"></script>
		<script type="text/javascript" src="../../../js/paginathing.min.js"></script>
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

        <h1>商品一覧</h1>
   		<br>

 <div class="nonemargin">
 	<div class="example">
    	<div class="a">
			<div class="wrapleft">
 				<div class="color">
 				<p>検索設定</p>
				<form method="POST" action="searchitemdetail">
    				<input type="hidden" name="itemsearchword" value="${result['itemsearchword']}">
    				<input type="hidden" name="shopsearchword" value="${result['shopsearchword']}">
    				<p>カテゴリ</p>
					<div class="cp_ipselect cp_sl01">
						<select name="category">
							<option value="0">指定なし</option>
							<option value="1">風景・自然の写真</option>
							<option value="2">人物・キャラクターの写真</option>
							<option value="3">食べ物の写真</option>
							<option value="4">植物・動物の写真</option>
							<option value="5">その他の写真</option>
							<option value="6">風景・自然のイラスト</option>
							<option value="7">人物・キャラクターのイラスト</option>
							<option value="8">食べ物のイラスト</option>
							<option value="9">植物・動物のイラスト</option>
							<option value="10">その他のイラスト</option>
							</select><br>
					</div>
    				<p>ソート</p><!-- 1:新着 2:いいね順 3:価格が高い順 4:価格が低い順-->

					<div class="cp_ipselect cp_sl01">
						<select name="sort">
							<option value="0">新着</option>
							<!--  <option value="1">いいね順</option> -->
							<option value="2">価格が高い順</option>
							<option value="3">価格が低い順</option>
						</select><br>
					</div>
					<a>金額</a><br>
					<p>&yen;0 ～ &yen;<span id="current-value" name="maxprice"></span></p>
					<input type="range" id="Money" name="maxprice" min="0" max="5000" step="250" value="5000">
					<script>
						const inputElem = document.getElementById('Money'); // input要素
						const currentValueElem = document.getElementById('current-value'); // 埋め込む先のspan要素

						// 現在の値をspanに埋め込む関数
						const setCurrentValue = (val) => {
							var money = Money.value;
	  						if(money > 4900)
	  						{
		  						currentValueElem.innerText = val + '+';
	  						}else{
		  						currentValueElem.innerText = val;
	 						}
						}

						// inputイベント時に値をセットする関数
						const rangeOnChange = (e) =>{
  							setCurrentValue(e.target.value);
						}
						window.onload = () => {
  							inputElem.addEventListener('input', rangeOnChange); // スライダー変化時にイベントを発火
  							setCurrentValue(inputElem.value); // ページ読み込み時に値をセット
						}


						</script><br><br>


					<input type="submit" value="検索">
				</form>
				</div>
			</div>
		</div>
		<div class="b">
			<div class="boxwrap">
				<div class="wrap pattern-3 mhb-20">
					<div class="color"><br>
				   		<h1>対象商品が  ${result["itemcount"]}  件ヒットしました。</h1>
				   		<div>
   						<div id="itemsdata" class="flex">
        				</div><br>
        				<div id="pages"></div>
        			</div>
				</div>
			</div>
		</div>
	</div>
</div>


<script>
	var showpages = 12;
	var pages = ${result["itemcount"]};
	var allpages = 0;

    var pagelist = [];

	(function(){

		if(pages<showpages){
			allpages += 1;
		}else{
			allpages = Math.floor(pages/showpages)+1
		}

		if(pages%showpages == 0){
			allpages -= 1;
		}

		var pagenation = document.getElementById("pages")
		for(let j= 1; j <= allpages; j++){
			ele = document.createElement('input');
		    ele.setAttribute("type", "button");
		    ele.setAttribute("value", j);
		    ele.setAttribute("onclick","changePage("+j+")");
		    pagenation.appendChild(ele);
		}

	}());

	var itemlist = [];
	var obj = [];


	(function(){


		<c:forEach var="item" items="${result['itemsearch']}" varStatus="status">

		obj = {
			itemId:'${item.itemId}',
			path:'${item.mainImagePath}',
			name:'${item.itemName}',
			price:'${item.itemPrice}',
			shopId:'${item.shopId}',
			shopName:'${item.shopName}'
		}
		itemlist.push(obj);

        </c:forEach>

        var pageitems = [];

		for(let k=0;k<pages;k++){
			pageitems.push(itemlist[k]);
			if(pageitems.length == showpages || k==(pages-1)){
				pagelist.push(pageitems);
				pageitems = [];
			}

		}

	}());

	function changePage(_pageNo){
		pageNo = _pageNo-1;
		$("div").remove("#remove");

		thisItemlist = [];
		console.log(thisItemlist);
		thisItemlist = pagelist[pageNo];
		console.log(thisItemlist);

		for(let i=0;i<thisItemlist.length;i++){
			//console.log(thisItemlist[i].name);
			//console.log(thisItemlist[i].price);
			$("#itemsdata").append("<div id='remove' class='margin' >"+"<div id='itemData"+i+"'class='wrap2 pattern-3 mhb-20 color' >"+"<div id='A'>"+"<div id='B'>");
			$("#itemData"+i+"").html("<a href='callitempage?itemId="+thisItemlist[i].itemId+"'><img src='upload/"+thisItemlist[i].path+"' class='img'></a><br>"+
									  "<a href='callitempage?itemId="+thisItemlist[i].itemId+"'>"+thisItemlist[i].name+"</a><br>"+
									  "<a>"+thisItemlist[i].price+"円</a><br>"+
			                          "<a href='shopinfo?shopId="+thisItemlist[i].shopId+"'>"+thisItemlist[i].shopName+"</a>");
		}

	}

    changePage(1);


</script>
<footer>
			<h2> </h2>
			<div></div>
			<br>
    	</footer>
</body>
</html>