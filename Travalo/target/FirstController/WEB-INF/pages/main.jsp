<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet">
    <link href="<c:url value='/resources/libs/bootstrap-3.3.5-dist/css/bootstrap.min.css'/>" rel="stylesheet">
    </head>
        <body>
        <%@ include file="header.jsp" %>
        <section class="container" class="panel panel-primary panel-transparent">
            <h2>Message : ${message}</h2>
            <a class="btn btn-primary btn-lg" href="#">Call to Action!</a>
        </section>
        <%@ include file="footer.jsp" %>
        </body>
</html>
