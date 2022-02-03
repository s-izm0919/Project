<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>商品編集ページ</title>
    </head>
    <body>
        <h1>商品編集</h1>
        <form method="POST" action="edititem?itemId=${result['singleItemResult'].itemId }">

            商品タイトル<input type="text" name="itemName" value="${result['singleItemResult'].itemName}" maxlength="50" required><br>
            価格<input type="number" name="itemPrice" value="${ result['singleItemResult'].itemPrice}" required><br>
            サムネイル<input type="text" name="mainImagePath" value="${ result['singleItemResult'].mainImagePath}" required><br>
            商品説明<br><textarea cols="25" rows="8" name="itemExplanation"  required>${ result['singleItemResult'].itemExplanation}</textarea><br>
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




            データ本体<input type="text" name="itemDataPath" value="${ result['singleItemResult'].itemDataPath}" required><br>

            <input type="radio" name="itemIsOpen" value="1">公開

            <input type="radio" name="itemIsOpen" value="0" checked>非公開


            <input type="submit" value="登録">
        </form>
    </body>
</html>