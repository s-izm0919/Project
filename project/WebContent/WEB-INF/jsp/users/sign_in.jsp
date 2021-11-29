<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>ログインページ</title>
    </head>
    <body>
        <h1>ユーザーログイン</h1>
        <form method="POST" action="loginuser">
            ユーザーID （半角英数)<input type="text" name="userIdentifiedName" maxlength="20"><br>
            メールアドレス<input type="email" name="mail" maxlength="300"><br>
            パスワード （半角英数）<input type="email" name="mail" maxlength="300" required><br>
            <input type="submit" value="ログイン">
        </form>
    </body>
</html>