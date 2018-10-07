<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Туры по Японии</title>
    <link rel="shortcut icon" href="static/images/favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap-reboot.css">
    <link rel="stylesheet" type="text/css" href="static/css/bootstrap.css">
</head>
<body>
<jsp:include page="common/common-header.jsp"/>

<c:set var="tours" scope="request" value="${requestScope.get('tours')}" />
<c:choose>
    <c:when test="${tours.isEmpty()}" >
        <h1 class="text-center">В данный момент нет туров</h1>
    </c:when>
    <c:otherwise>
        <c:forEach var="tour" items="${tours}">
            <div class="card">
                <div class="card-header">
                    <h5 class="card-title">Здесь будут города</h5>
                </div>
                <div class="card-body">
                    <p class="card-text">${tour.description}</p>
                    <p class="card-text">Стоимость тура: ${tour.tourPrice} руб.</p>
                    <p class="card-text">Продолжительность тура: ${tour.getDuration()} дн.</p>
                </div>
                <div class="card-footer">
                    <p class="card-text">Максимальное количество человек: ${tour.maxParticipants}</p>
                    <a href="#" class="btn btn-primary">Забронировать</a>
                </div>
            </div>
        </c:forEach>
    </c:otherwise>
</c:choose>

<jsp:include page="common/common-footer.jsp"/>
</body>
</html>
