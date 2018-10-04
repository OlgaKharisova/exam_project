<%@ page import="ru.innopolis.model.Client" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.innopolis.model.Tour" %><%--
  Created by IntelliJ IDEA.
  User: sa
  Date: 02.10.18
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tour tourId</title>
</head>
<body>
<H1>Список туров:</H1>
<%
    List<Tour> list = (List<Tour>) request.getAttribute("tours");
    for (Tour tourId : list) {%>
<a href="/tours?id=<%=tourId.getId()%>">
    <table> Туры </table>
    <th>id</th>
    <td>tourId.getId()</td>

    <th>creator</th>
    <td><%=tourId.getCreator()%></td>

    <%--дописать--%>

</a><BR>
<%
    }
%>
</body>
</html>
