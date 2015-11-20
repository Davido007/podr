<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="<c:url value='/resources/libs/jquery-1.11.3.min.js'/>" ></script>
    <script src="<c:url value='/resources/libs/bootstrap-3.3.5-dist/js/bootstrap.min.js'/>" ></script>
    <script src="<c:url value='/resources/libs/bootstrap-fileinput-master/js/fileinput.js'/>"></script>
    <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet">
    <link href="<c:url value='/resources/libs/bootstrap-3.3.5-dist/css/bootstrap.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/resources/libs/bootstrap-fileinput-master/css/fileinput.min.css'/>" rel="stylesheet">
<script src="<c:url value='/resources/js/myAccount.js'/>" ></script>
<%@ include file="changePasswordModal.jsp" %>
<!--<form:form method="post" id="myProfileForm" action="register/add" commandName="user">-->
        <div id="myProfilePic">
           <!-- <input id="input-dim-1" type="file" multiple class="file-loading" accept="image/*">-->
            <img src="<c:url value='/resources/img/userIcon.png'/>"/>
            <h3>${user.login}</h3>
        </div>
        <div id="myProfileData">
        <div>
            <label class="label label-primary" path="login"><spring:message code="label.login"/></label>
            <p>${user.login}</p>
            <!--<form:label class="label label-primary" path="login">
            <spring:message code="label.login"/></form:label>
            <form:input class="form-control" path="login" />
            <img class="okIcon" id="successLogin" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" id="failureLogin" src="<c:url value='/resources/img/failIcon.png'/>" hidden>
            <img class="okIcon" id="loadingLogin" src="<c:url value='/resources/img/loading.gif'/>" hidden>-->
        </div>
        <div>
            <label class="label label-primary" path="firstname"><spring:message code="label.firstname"/></label>
            <p>${user.firstname}</p>
            <!--<form:label class="label label-primary" path="firstname">
            <spring:message code="label.firstname"/></form:label>
            <form:input class="form-control" path="firstname" />
            <img class="okIcon" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" src="<c:url value='/resources/img/failIcon.png'/>" hidden>-->
        </div>
        <div>
            <label class="label label-primary" path="lastname"><spring:message code="label.lastname"/></label>
            <p>${user.lastname}</p>
            <!--<form:label class="label label-primary" path="lastname"><spring:message code="label.lastname"/></form:label>
            <form:input class="form-control" path="lastname" />
            <img class="okIcon" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" src="<c:url value='/resources/img/failIcon.png'/>" hidden>-->
        </div>
        <div>
            <label class="label label-primary" path="email"><spring:message code="label.email"/></label>
            <p>${user.email}</p>
            <!--<form:label class="label label-primary" path="email"><spring:message code="label.email"/></form:label>
            <form:input class="form-control" path="email" />
            <img class="okIcon" id="successEmail" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" id="failureEmail" src="<c:url value='/resources/img/failIcon.png'/>" hidden>
            <img class="okIcon" id="loadingEmail" src="<c:url value='/resources/img/loading.gif'/>" hidden>-->
        </div>
        <c:if  test="${!empty user.phone}">
        <div>
            <label class="label label-primary" path="phone"><spring:message code="label.telephone"/></label>
            <p>${user.phone}</p>
            <!--<form:label class="label label-primary" path="phone"><spring:message code="label.telephone"/></form:label>
            <form:input class="form-control" path="phone" />
            <img class="okIcon" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" src="<c:url value='/resources/img/failIcon.png'/>" hidden>-->
        </div>
        </c:if>
        <c:if  test="${!empty user.city}">
        <div>
            <label class="label label-primary" path="city"><spring:message code="label.city"/></label>
            <p>${user.city}</p>
            <!--<form:label class="label label-primary" path="city"><spring:message code="label.city"/></form:label>
            <form:input class="form-control" path="city" />
            <img class="okIcon" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" src="<c:url value='/resources/img/failIcon.png'/>" hidden>-->
        </div>
        </c:if>
        <c:if  test="${!empty user.country}">
        <div>
            <label class="label label-primary" path="country"><spring:message code="label.country"/></label>
            <p>${user.country}</p>
            <!--<form:label class="label label-primary" path="country"><spring:message code="label.country"/></form:label>
            <form:input class="form-control" path="country" />
            <img class="okIcon" src="<c:url value='/resources/img/okIcon.png'/>" hidden>
            <img class="okIcon" src="<c:url value='/resources/img/failIcon.png'/>" hidden>-->
        </div>
        </c:if>
        </div>
        <div id="aboutMe">
          <label class="label label-primary" for="aboutMe">About me:</label></br>
          <textarea class="form-control" rows="5" id="aboutMe"></textarea>
        </div>
        <div id="myProfileButtons">
                <a id="changePhoto" data-toggle="modal" href="#myModalNorm" class="btn btn-primary btn-large"><spring:message code="label.uploadNewPhoto"/></a>
                <a id="changeYourData" data-toggle="modal" href="#myModalNorm" class="btn btn-primary btn-large"><spring:message code="label.changeYourData"/></a>
                <a id="changePassword" data-toggle="modal" href="#myModalNorm" class="btn btn-primary btn-large"><spring:message code="label.changePassword"/></a>
        </div>
</form:form>
