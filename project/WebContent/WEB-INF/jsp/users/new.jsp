<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>ユーザー登録</title>
    </head>
    <body>
        <h1>ユーザー登録</h1>
        <form method="POST" action="add">
            ユーザー名<input type="text" name="userName"><br>
            ユーザーID（半角英数）<input type="text" name="nickName"><br>
            パスワード（半角英数）<input type="password" name="password"><br>
            メールアドレス<input type="email" name="mail"><br>
            <input type="submit" value="登録">
        </form>
    </body>
</html>