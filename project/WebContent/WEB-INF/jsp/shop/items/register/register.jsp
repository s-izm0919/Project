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
            <select name="categoryName" required>
            			<option name="categoryName"></option>
                        <option name="categoryName" value="1">風景・自然の写真</option>
                        <option name="categoryName" value="2">人物・キャラクターの写真</option>
                        <option name="categoryName" value="3">食べ物の写真</option>
                        <option name="categoryName" value="4">植物・動物の写真</option>
                        <option name="categoryName" value="5">その他の写真</option>
                        <option name="categoryName" value="6">風景・自然のイラスト</option>
                        <option name="categoryName" value="7">人物・キャラクターのイラスト</option>
                        <option name="categoryName" value="8">食べ物のイラスト</option>
                        <option name="categoryName" value="9">植物・動物のイラスト</option>
                        <option name="categoryName" value="10">その他のイラスト</option>
			</select><br>
            データ本体<input type="file" name="itemDataPath" required><br>
            <input type="radio" name="itemIsOpen" value="1">公開
            <input type="radio" name="itemIsOpen" value="0" checked>非公開
            <input type="submit" value="登録">
        </form>
    </body>
</html>