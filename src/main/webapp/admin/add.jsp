<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../style.css" rel="stylesheet">
    <title>Добавление пользователя</title>
</head>

<body>

<h1>Добавление пользователя</h1>

<form action="/crud_war/admin/add" method="post" name="addForm">
    <ul>
        <li><label for="name"><b>Имя:</b> </label><input type="text" name="name" id="name"></li>
        <li><label for="login"><b>Логин:</b> </label><input type="text" name="login" id="login"></li>
        <li><label for="password"><b>Пароль:</b> </label><input type="text" name="password" id="password"></li>
        <button class="submit" type="submit">OK</button>
    </ul>
</form>

</body>
</html>
