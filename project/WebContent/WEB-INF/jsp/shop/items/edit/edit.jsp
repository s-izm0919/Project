<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>商品編集ページ</title>
    </head>
    <body>
        <h1>商品登録</h1>
        <form method="POST" action="edititem">
            商品タイトル<input type="text" name="itemName" maxlength="50" required><br>
            価格<input type="number" name="itemPrice"  required><br>
            サムネイル<input type="file" name="mainImagePath" required><br>
            商品説明<br><textarea cols="25" rows="8" name="itemExplanation"></textarea><br>
            カテゴリ<select name="categoryId" required>
                        <option value="cat">猫</option>
                        <option value="dog">犬</option>
                        <option value="gold">金</option>
                    </select><br>
            データ本体<input type="file" name="itemDataPath" required><br>

            <input type="radio" name="example" value="公開">公開

            <input type="radio" name="example" value="非公開" checked>非公開


            <input type="submit" value="登録">
        </form>
    </body>
</html>

