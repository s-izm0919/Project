<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>商品登録ページ</title>
    </head>
    <body>
        <h1>ショップ開設</h1>
        <form method="POST" action="addshop">

            ショップ名<input type="text" name="shopName" maxlength="40" required><br>
           	紹介文<br><textarea  cols="25" rows="8" name="shopExplanation" maxlength="500" ></textarea><br>
            お礼の一言<input type="text" name="shopSellerWord" maxlength="400" ><br>


            <input type="radio" name="shopIsOpen" value="open">公開

            <input type="radio" name="shopIsOpen" value="close" checked>非公開


            <input type="submit" value="ショップを開設する">

        </form>
    </body>
</html>