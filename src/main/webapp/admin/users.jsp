<%@ page import="service.UserService" %>
<%@ page import="pojo.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="../style.css" rel="stylesheet">
    <title>Список пользователей</title>
</head>
<body>

<h1>Список пользователей</h1>

<p><b><a href="/crud_war/admin/add">Добавить нового пользователя</a></b></p>

<table>
    <colgroup>
        <col width="5%">
        <col width="20%">
        <col width="20%">
        <col width="10%">
        <col width="10%">
    </colgroup>
    <tr>
        <th>№</th>
        <th>Имя</th>
        <th>Логин</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.login}</td>
            <td><a href="/crud_war/admin/update?id=${user.id}">редактировать</a></td>
            <td><a href="/crud_war/admin/delete?id=${user.id}">удалить</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
