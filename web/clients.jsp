<%@ page import="ru.innopolis.model.Client" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: sa
  Date: 02.10.18
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clients list</title>
</head>
<body>
<H1>Список клиентов:</H1>
<%
    List<Client> list = (List<Client>) request.getAttribute("clients");
    for (Client clientId : list) {%>
<a href="/clients?id=<%=clientId.getId()%>"><%=clientId.getName()%>
</a><BR>
<%
    }
%>
</body>
</html>
