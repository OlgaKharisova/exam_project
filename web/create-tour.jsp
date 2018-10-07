<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Создание тура</title>
</head>
<body>
<form id = "create-manager" method="post" action="/create-tour">
    <input type="text" name = "tourPrice">цена всего тура</input><br>
    <input type="text" name = "flightPrice">цена авиаперелета</input><br>
    <input type="date" name = "startDate">дата начала тура</input><br>
    <input type="date" name = "endDate">дата окончания тура</input><br>
    <input type="text" name = "maxParticipants">количество участников в туре</input><br>
    <input type="text" name = "tourStatus">статус тура</input><br>
    <input type="text" name = "creator">менеджер, создавший тур</input><br>
    <input type="text" name = "description">описание</input><br>
    <input type="submit" name = "Создать тур" />
</form>
</body>
</html>
