<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    <script src="<c:url value='/resources/libs/jquery-1.11.3.min.js'/>" ></script>
    <script src="<c:url value='/resources/libs/bootstrap-3.3.5-dist/js/bootstrap.min.js'/>" ></script>
    <script src="<c:url value='/resources/libs/bootstrap-fileinput-master/js/fileinput.js'/>"></script>
    <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet">
    <link href="<c:url value='/resources/libs/bootstrap-3.3.5-dist/css/bootstrap.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/resources/libs/bootstrap-fileinput-master/css/fileinput.min.css'/>" rel="stylesheet">
    <script src="<c:url value='/resources/js/uploadImage.js'/>" ></script>
        <meta name="_csrf" content="${_csrf.token}"/>
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
    </head>
        <body>
        <%@ include file="header.jsp" %>
        <section class="container" class="panel panel-primary panel-transparent">
            <h2>Message : ${message}</h2>
            <h2>Message : ${user.login}</h2>
            <a class="btn btn-primary btn-lg" href="#">Call to Action!</a>
            <input id="input-dim-1" type="file" multiple class="file-loading" accept="image/*">
        </section>
        <%@ include file="footer.jsp" %>
        </body>
</html>
