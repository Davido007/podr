<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <script src="<c:url value='/resources/libs/jquery-1.11.3.min.js'/>" ></script>
        <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/libs/bootstrap-3.3.5-dist/css/bootstrap.min.css'/>" rel="stylesheet">
        <script src="<c:url value='/resources/js/validate.js'/>" ></script>
        <script src="<c:url value='/resources/libs/bootstrap-3.3.5-dist/js/bootstrap.min.js'/>" ></script>
    </head>
    <body>
    <%@ include file="header.jsp" %>
    <section class="container">
    <h3>Register</h3>
    <form:form method="post" id="registerForm" action="register/add" commandName="user">
        <div class="alert alert-info fade in">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>Please provide your data</strong>
        </div>
        <table>
        <tr>
            <td><form:label class="label label-primary" path="login">
            <spring:message code="label.login"/>*</form:label></td>
            <td><form:input class="form-control" path="login" /></td>
            <td><img class="okIcon" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" src="<c:url value='/resources/img/failIcon.png'/>" hidden></td>
        </tr>
        <tr>
            <td><form:label class="label label-primary" path="password"><spring:message code="label.password"/>*</form:label></td>
            <td><form:input type="password" class="form-control" path="password" /></td>
            <td><img class="okIcon" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" src="<c:url value='/resources/img/failIcon.png'/>" hidden></td>
        </tr>
        <tr>
            <td><label class="label label-primary"><spring:message code="label.repeatPassword"/>*</label></td>
            <td><input type="password" class="form-control" /></td>
            <td><img class="okIcon" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" src="<c:url value='/resources/img/failIcon.png'/>" hidden></td>
        </tr>
        <tr>
            <td><form:label class="label label-primary" path="firstname">
            <spring:message code="label.firstname"/>*</form:label></td>
            <td><form:input class="form-control" path="firstname" /></td>
            <td><img class="okIcon" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" src="<c:url value='/resources/img/failIcon.png'/>" hidden></td>
        </tr>
        <tr>
            <td><form:label class="label label-primary" path="lastname"><spring:message code="label.lastname"/>*</form:label></td>
            <td><form:input class="form-control" path="lastname" /></td>
            <td><img class="okIcon" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" src="<c:url value='/resources/img/failIcon.png'/>" hidden></td>
        </tr>
        <tr>
            <td><form:label class="label label-primary" path="email"><spring:message code="label.email"/>*</form:label></td>
            <td><form:input class="form-control" path="email" /></td>
            <td><img class="okIcon" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" src="<c:url value='/resources/img/failIcon.png'/>" hidden></td>
        </tr>
        <tr>
            <td><label class="label label-primary"><spring:message code="label.repeatEmail"/>*</label></td>
            <td><input class="form-control" /></td>
            <td><img class="okIcon" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" src="<c:url value='/resources/img/failIcon.png'/>" hidden></td>
        </tr>
        <tr>
            <td><form:label class="label label-primary" path="phone"><spring:message code="label.telephone"/></form:label></td>
            <td><form:input class="form-control" path="phone" /></td>
            <td><img class="okIcon" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" src="<c:url value='/resources/img/failIcon.png'/>" hidden></td>
        </tr>
        <tr>
            <td><form:label class="label label-primary" path="city"><spring:message code="label.city"/></form:label></td>
            <td><form:input class="form-control" path="city" /></td>
            <td><img class="okIcon" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" src="<c:url value='/resources/img/failIcon.png'/>" hidden></td>
        </tr>
        <tr>
            <td><form:label class="label label-primary" path="country"><spring:message code="label.country"/></form:label></td>
            <td><form:input class="form-control" path="country" /></td>
            <td><img class="okIcon" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" src="<c:url value='/resources/img/failIcon.png'/>" hidden></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" id="submitRegistration" class="btn btn-primary btn-lg" value="<spring:message code="label.add"/>" disabled />
            </td>
        </tr>
    </table>
    </form:form>
    <!--<h3>Users</h3>
    <c:if  test="${!empty usersList}">
    <table class="data">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Telephone</th>
        <th>City</th>
        <th>Country</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${usersList}" var="emp">
        <tr>
            <td>${emp.lastname}  ${emp.firstname} </td>
            <td>${emp.email}</td>
            <td>${emp.phone}</td>
            <td>${emp.city}</td>
            <td>${emp.country}</td>
            <td>delete</td>
        </tr>
    </c:forEach>
    </table>
    </c:if>-->
    </section>
    <%@ include file="footer.jsp" %>
    </body>
</html>