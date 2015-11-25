<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <script src="https://maps.googleapis.com/maps/api/js"></script>
        <script src="<c:url value='/resources/libs/jquery-1.11.3.min.js'/>" ></script>
        <link href="<c:url value='/resources/css/main.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/libs/bootstrap-3.3.5-dist/css/bootstrap.min.css'/>" rel="stylesheet">
        <link href="<c:url value='/resources/libs/bootstrap-datepicker-master/dist/css/bootstrap-datepicker.css'/>" rel="stylesheet">
        <script src="<c:url value='/resources/libs/bootstrap-3.3.5-dist/js/bootstrap.min.js'/>" ></script>
        <script src="<c:url value='/resources/libs/bootstrap-datepicker-master/dist/js/bootstrap-datepicker.js'/>" ></script>
        <script src="<c:url value='/resources/js/validate.js'/>" ></script>
        <script src="<c:url value='/resources/js/myAccount.js'/>" ></script>
        <script src="<c:url value='/resources/js/resizeImage.js'/>" ></script>
    </head>
    <body>
    <%@ include file="header.jsp" %>
    <section class="container">
    <h3>My Account</h3>
    <section id="userData">
    <h3>Pictures</h3>
    <c:set var="salary" scope="session" value="1"/>
    </section>
    <section id="userMenu">
        <ul>
            <li><a class="btn btn-primary btn-lg" id="myTravalo">My Travalo</a></li>
            <li><a class="btn btn-primary btn-lg" id="myProfile">My Profile</a></li>
            <li><a class="btn btn-primary btn-lg" id="myPlaces" >My Places</a></li>
            <li><a class="btn btn-primary btn-lg" id="myMessages">My Messages</a></li>
            <li><a class="btn btn-primary btn-lg" id="myFriends">My Friends</a></li>
            <li><a class="btn btn-primary btn-lg" id="myHotels">My Hotels</a></li>
            <li><a class="btn btn-primary btn-lg" id="myFlights">My Flights</a></li>
            <li><a class="btn btn-primary btn-lg" id="myRent">My Rent</a></li>
            <li><a class="btn btn-primary btn-lg" id="myToDO">My ToDO</a></li>
            <li><a class="btn btn-primary btn-lg" id="myMaps">My Maps</a></li>
            <li><a class="btn btn-primary btn-lg" id="myTrips">My Trips</a></li>
        </ul>

    </section>
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