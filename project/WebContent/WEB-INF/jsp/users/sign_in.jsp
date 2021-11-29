<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>ログインページ</title>
    </head>
    <body>
        <h1>ユーザーログイン</h1>
        <form method="POST" action="add">
            ユーザーID（半角英数）<input type="text" name="userIdentifiedName"><br>
            メールアドレス<input type="email" name="userMail"><br>
            パスワード（半角英数）<input type="password" name="userPassword" required><br>
            <input type="submit" value="ログイン">
        </form>
    </body>
</html>