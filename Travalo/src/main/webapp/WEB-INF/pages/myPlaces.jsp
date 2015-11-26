<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://maps.googleapis.com/maps/api/js"></script>
<script src="<c:url value='/resources/js/myPlacesMap.js'/>" ></script>
        <meta name="_csrf" content="${_csrf.token}"/>
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <h3>My Places</h3>
    <%@ include file="addNewPlaceModal.jsp" %>
    <div id="myPlacesMap"></div>