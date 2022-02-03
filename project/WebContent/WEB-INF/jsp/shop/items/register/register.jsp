<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>商品登録ページ</title>
    </head>
    <body>
        <h1>商品登録</h1>
<!-- formの属性に[enctype="multipart/form-data"]を追加しました。 -->
        <form method="POST" action="additem" enctype="multipart/form-data">
            商品タイトル<input type="text" name="itemName" maxlength="50" required><br>
            価格<input type="number" name="itemPrice" value="0" required><br>
            サムネイル<input type="file" name="mainImagePath" required><br>
            商品説明<br><textarea cols="25" rows="8" name="itemExplanation"></textarea><br>
            カテゴリ
            <select name="categoryName">
                        <option name="categoryName" value="1"> painting</option>
                        <option name="categoryName" value="2"> manga</option>
                        <option name="categoryName" value="3">photo</option>
  </select><br>
            データ本体<input type="file" name="itemDataPath" required><br>
            <input type="radio" name="itemIsOpen" value="1">公開
            <input type="radio" name="itemIsOpen" value="0" checked>非公開
            <input type="submit" value="登録">
        </form>
    </body>
</html>