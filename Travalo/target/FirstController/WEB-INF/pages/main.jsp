<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet">
    </head>
        <body>
        <%@ include file="header.jsp" %>
            <h2>Message : ${message}</h2>
        </body>
</html>
