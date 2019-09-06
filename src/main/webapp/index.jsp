<%@ page import="service.UserService" %>
<%@ page import="pojo.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="style.css" rel="stylesheet">
    <title>Список пользователей</title>
</head>
<body>

<h1>Вход в систему</h1>

<p><b>${requestScope.messages}</b></p>

<form action="/crud_war/index" method="post" name="login">
    <ul>
        <li><label for="login"><b>Логин:</b> </label><input type="text" name="login" id="login"></li>
        <li><label for="password"><b>Пароль:</b> </label><input type="text" name="password" id="password"></li>
        <button class="submit" type="submit">OK</button>
    </ul>
</form>

</body>
</html>
