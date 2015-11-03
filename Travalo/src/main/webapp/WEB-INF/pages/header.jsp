<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet">
    </head>
    <body>
        <ul id="topMenu">
            <li><a href="${routes.home}">Home</a></li>
            <li><a href="${routes.login}">Login</a></li>
        </ul>
    </body>
</html>