<%--
  Created by IntelliJ IDEA.
  User: sa
  Date: 02.10.18
  Time: 7:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создание клиента</title>
</head>
<body>
<form id = "create-client" method="post" action="/create-client">
    <input type="text" id = "name" name = "name">Имя</input><br>
    <input type="text" name = "secondName">Фамилия</input><br>
    <input type="text" name = "patronymic">Отчество</input><br>
    <input type="email" name = "email">Email</input><br>
    <input type="submit" name = "Создать клиента" />
</form>
</body>
</html>
