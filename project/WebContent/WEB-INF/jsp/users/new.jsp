
<%@ page language="java" pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>ユーザー登録</title>
    </head>
    <body>
        <h1>ユーザー登録</h1>
        <form method="POST" action="adduser">
            ユーザー名<input type="text" name="userName" maxlength="20" required><br>
            ユーザーID（半角英数）<input type="text" name="userIdentifiedName" maxlength="20" pattern="^[a-zA-Z0-9]+$" required><br>
            パスワード（半角英数）<input type="password" name="userPassword" maxlength="20" pattern="^[a-zA-Z0-9]+$"  required><br>
            メールアドレス<input type="email" name="userMail" maxlength="300" required><br>
            <input type="submit" value="登録">
        </form>

    </body>


</html>