<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="addNewPlaceModal.jsp" %>
<%@ include file="viewPlaceModal.jsp" %>
<script src="<c:url value='/resources/js/myPlacesMap.js'/>" ></script>
        <meta name="_csrf" content="${_csrf.token}"/>
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <h3>My Places</h3>
    <div id="myPlacesMap"></div>