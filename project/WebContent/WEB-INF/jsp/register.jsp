<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>ユーザー登録</title>
    </head>
    <body>
        <h1>ユーザー登録</h1>
        <form method="POST" action="add">
            ニックネーム<input type="text" name="nickName"><br>
            ユーザ-名<input type="text" name="userName"><br>
            パスワード<input type="text" name="password"><br>
            メールアドレス<input type="text" name="mail"><br>
            <input type="submit" value="登録">
        </form>
    </body>
</html>