<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Войти в систему</title>
    <link rel="shortcut icon" href="static/images/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap-reboot.css">
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap.css">
</head>
<body>
<jsp:include page="common/common-header.jsp"/>

<div>
    <h2> Авторизуйтесь в личном кабинете </h2>
    <form id="login" method="post" action="/login">
        <input type="text" name="name">Login</input><br>
        <input type="password" name="password">Пароль</input><br>
        <input type="submit" name="Авторизоваться"/>
    </form>
</div>

<div>
    <h2> Еще нет личного кабинета? Создайте его прямо сейчас </h2>
    <form id="registration" method="post" action="/registration">
        <input type="text" id="name" name="name">Имя</input><br>
        <input type="text" name="secondName">Фамилия</input><br>
        <input type="text" name="patronymic">Отчество</input><br>
        <input type="email" name="email">Email</input><br>
        <input type="password" name="password">Пароль</input><br>
        <input type="submit" name="Зарегистрироваться"/>
    </form>
</div>
<jsp:include page="common/common-footer.jsp"/>
</body>
</html>
