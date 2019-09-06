<%@ page import="service.UserService" %>
<%@ page import="pojo.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="style.css" rel="stylesheet">
    <title>Страница пользователя</title>
</head>
<body>

<h1>Страница пользователя</h1>

<h2>${requestScope.user.name}</h2>

<p>${requestScope.user.login}</p>

</body>
</html>
