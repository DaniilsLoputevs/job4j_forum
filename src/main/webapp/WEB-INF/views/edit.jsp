<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

    <title>Forum</title>

</head>

<body>
<%--<%--%>
<%--    String reqId = request.getParameter("id");--%>
<%--    Candidate can = new Candidate(0, "");--%>
<%--    if (reqId != null) {--%>
<%--        can = StoreCandidate.instOf().getById(Integer.parseInt(reqId));--%>
<%--    }--%>
<%--%>--%>
<div class="container">
    <div class="row">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/index'/>">Главная</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/reg'/>">Регистрация</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/post/7'/>">Test post 7</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/edit/7'/>">Test edit 7</a>
            </li>
        </ul>
    </div>

    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <c:choose>
                    <c:when test="${post.id==null}">Новая Тема.</c:when>
                    <c:otherwise>Редактирование Темы.</c:otherwise>
                </c:choose>
            </div>
            <form action="/edit/" method="POST">
                <div class="card-body">
<%--                    <c:set var="id" scope="session" value="${post.id}"/>--%>
<%--                    <c:set var="name" scope="session" value="${post.name}"/>--%>
<%--                    <c:set var="description" scope="session" value="${post.desc}"/>--%>

                    <label hidden>Hidden input post ID
                        <input hidden type="text" name="id" value="${post.id}">
                    </label>

                    <label>Название
                        <input type="text" class="form-control" name="name" value="${post.name}">
                    </label>
                    <label>Описание
                        <input type="text" class="form-control" name="desc" value="${post.desc}">
                    </label>
                    <label>Создано
                        <input type="text" class="form-control" name="createdTime" value="${createdTime}">
                    </label>
                    <button type="submit" class="btn btn-primary">Подтвердить изменения</button>

        <%--  УДАЛЕНИЕ!!! --%>
<%--                    <c:if test="${id > 0}">--%>
<%--                        &lt;%&ndash; delete candidate &ndash;%&gt;--%>
<%--                        <form action="<c:url value='/candidate/delete.do?id=${id}'/>" method="post"--%>
<%--                              enctype="application/x-www-form-urlencodeda">--%>
<%--                            <h3>Осторожно!</h3>--%>
<%--                            <button type="submit" class="btn btn-primary">Удалить кандидата</button>--%>
<%--                        </form>--%>
<%--                    </c:if>--%>

                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>