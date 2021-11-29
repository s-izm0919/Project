<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>商品編集ページ</title>
    </head>
    <body>
        <h1>商品登録</h1>
        <form method="POST" action="add">
            商品タイトル<input type="text" name="itemName" required><br>
            価格<input type="number" name="itemPrice" required><br>
            サムネイル<input type="file" name="mainImagePath" required><br>
            商品説明<br><textarea cols="24" rows="5" name="itemExplanation"></textarea><br>
            カテゴリ<select name="categoryId" required>
                        <option value="猫">猫</option>
                        <option value="犬">犬</option>
                        <option value="金">金</option>
                    </select><br>
            データ本体<input type="file" name="itemDataPath" required><br>

            <input type="radio" name="example" value="公開">公開

            <input type="radio" name="example" value="非公開" checked>非公開


            <input type="submit" value="登録">
        </form>
    </body>
</html>

