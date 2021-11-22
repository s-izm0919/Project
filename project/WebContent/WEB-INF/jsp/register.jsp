<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>ユーザー登録</title>
    </head>
    <body>
        <h1>ユーザー登録</h1>
        <form method="POST" action="add">
            ユーザー名<input type="text" name="名前"><br>
            ユーザーID（半角英数）<input type="text" name="ユーザーID"><br>
            パスワード（半角英数）<input type="text" name="パスワード"><br>
            メールアドレス<input type="text" name="メールアドレス"><br>
            <input type="submit" value="登録">
        </form>
    </body>
</html>