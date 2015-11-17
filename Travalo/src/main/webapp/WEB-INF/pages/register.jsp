<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <script src="<c:url value='/resources/libs/jquery-1.11.3.min.js'/>" ></script>
        <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/libs/bootstrap-3.3.5-dist/css/bootstrap.min.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/libs/bootstrap-3.3.5-dist/css/bootstrap.min.css'/>" rel="stylesheet">

        <script src="<c:url value='/resources/libs/bootstrap-3.3.5-dist/js/bootstrap.min.js'/>" ></script>
        <script src="<c:url value='/resources/js/validate.js'/>" ></script>
        <script src="<c:url value='/resources/js/resizeImage.js'/>" ></script>
    </head>
    <body>
    <%@ include file="header.jsp" %>
    <section class="container">
    <h3>Register</h3>
        <section id="pictures">
    <h3>Pictures</h3>
    <c:set var="salary" scope="session" value="1"/>
    <c:if  test="${!empty pictures}">
        <table class="data">
        <c:forEach items="${pictures}" var="img">

        <c:choose>
            <c:when test="${salary%3 == 0 && salary != 0}">
                <td class="col-xs-6 col-md-3"><img id="miniPhoto" class="img-responsive img-thumbnail" src="<c:url value='${img.imagePath}'/>"></td>
                </tr>
            </c:when>
            <c:when test="${salary%3 == 0}">
                <tr>
                <td class="col-xs-6 col-md-3"><img id="miniPhoto" class="img-responsive img-thumbnail" src="<c:url value='${img.imagePath}'/>"></td>
            </c:when>
            <c:otherwise>
                <td  class="col-xs-6 col-md-3"><img id="miniPhoto" class="img-responsive img-thumbnail" src="<c:url value='${img.imagePath}'/>"></td>
            </c:otherwise>
        </c:choose>

            <c:set var="salary" scope="session" value="${salary+1}"/>

            </c:forEach>
            </table>
        </c:if>
    </section>
    <form:form method="post" id="registerForm" action="register/add" commandName="user">
        <table>
        <tr>
            <td><form:label class="label label-primary" path="login">
            <spring:message code="label.login"/>*</form:label></td>
            <td><form:input class="form-control" path="login" /></td>
            <td><img class="okIcon" id="successLogin" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" id="failureLogin" src="<c:url value='/resources/img/failIcon.png'/>" hidden>
            <img class="okIcon" id="loadingLogin" src="<c:url value='/resources/img/loading.gif'/>" hidden></td>
        </tr>
        <tr>
            <td><form:label class="label label-primary" path="password"><spring:message code="label.password"/>*</form:label></td>
            <td><form:input type="password" class="form-control" path="password" /></td>
            <td><img class="okIcon" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" src="<c:url value='/resources/img/failIcon.png'/>" hidden></td>
        </tr>
        <tr>
            <td><label class="label label-primary"><spring:message code="label.repeatPassword"/>*</label></td>
            <td><input id="repeatPassword" type="password" class="form-control" /></td>
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
            <td><img class="okIcon" id="successEmail" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" id="failureEmail" src="<c:url value='/resources/img/failIcon.png'/>" hidden>
            <img class="okIcon" id="loadingEmail" src="<c:url value='/resources/img/loading.gif'/>" hidden></td>
        </tr>
        <tr>
            <td><label class="label label-primary"><spring:message code="label.repeatEmail"/>*</label></td>
            <td><input id="repeatEmail" class="form-control" /></td>
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
                <input type="submit" id="submitRegistration" class="btn btn-primary btn-lg" value="<spring:message code="label.add"/>" />
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
    <div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <img id="mimg" src="" class="img-responsive">
            </div>
        </div>
      </div>
    </div>
</html>