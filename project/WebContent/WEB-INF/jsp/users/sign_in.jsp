<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>ログインページ</title>
    </head>
    <body>
        <h1>ユーザーログイン</h1>
        <form method="POST" action=""/project${requestScope.target}"">
            ユーザーID（半角英数）またはメールアドレス<input type="text" name="userIdenNameOrEmail"><br>

            パスワード（半角英数）<input type="password" name="userPassword" required><br>
            <input type="submit" value="ログイン">

            <a href="forgetpassword">Forgetpassword </a>

            <input type="submit" value="ログイン"><br><br>
            <a href="new">アカウントを作る</a>

        </form>
    </body>
</html>