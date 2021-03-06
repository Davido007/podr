<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/libs/bootstrap-3.3.5-dist/css/bootstrap.min.css'/>" rel="stylesheet">
    </head>
    <body>
        <section  id="header">
        <a href="${routes.home}" id="logo">Travalo</a>
            <ul id="topMenu">
                <c:choose>
                    <c:when test="${not empty user}">
                    <li id="userIcon"><a href="${routes.myAccount}"><img src="<c:url value='/resources/img/userIcon.png'/>"/></a></li>
                        <li id="userWelcome"><a href="${routes.myAccount}">${user.login}</a></li>
                        <li><a href="${routes.logout}">Logout</a></li>
                    </c:when>
                    <c:otherwise>
                        <li id="loginLi"><a href="${routes.login}">Login</a></li>
                        <li><a href="${routes.register}">Register</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </section>
    </body>
</html>