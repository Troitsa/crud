<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../style.css" rel="stylesheet">
    <title>Редактирование пользователя</title>
</head>

<body>

<h1>Редактирование пользователя</h1>

<form action="/crud_war/admin/update" method="post" name="addForm">
    <ul>
        <input type="number" hidden name="id" value="${requestScope.user.id}"/>
        <li><label for="name"><b>Имя:</b> </label><input type="text" name="name" id="name" value="<c:out value="${requestScope.user.name}"/>"></li>
        <li><label for="login"><b>Логин:</b> </label><input type="text" name="login" id="login" value="${requestScope.user.login}"></li>
        <li><label for="pass"><b>Пароль:</b> </label><input type="text" name="password" id="pass"></li>
        <li><label for="role"><b>Роль:</b> </label><input type="text" name="role" id="role" value="${requestScope.user.role}"></li>
        <button class="submit" type="submit">OK</button>
    </ul>
</form>

</body>
</html>
