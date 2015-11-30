$( document ).ready(function() {
    getAllMarkers();
    getCurrentDate();
    prepareDatapicker();
    var centerPosition = new google.maps.LatLng(51.508742,-0.120850);
    var latitude;
    var longitude;
    var map;
    var output;
    var markers;

    function getAllMarkers (){
        $.get("user/userMarkers", { login: $("#userWelcome").text()}).then(function( data ) {
            markers = data;
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(initializeWithCurrentLocation);
            } else {
                initializeWithoutCurrentLocation();
            }
        });

    function getCurrentDate() {
        var d = new Date();
        var month = d.getMonth()+1;
        var day = d.getDate();

        output = (day<10 ? '0' : '') + day + '/' + (month<10 ? '0' : '') + month + '/' + d.getFullYear();
        $("#startDate").val(output);
        $("#endDate").val(output);
    }
    function prepareDatapicker() {
        $('.startDataPicker').datepicker({
            format: 'dd/mm/yyyy',
            weekStart: 1,
            startDate: "01/01/2015",
            endDate: "01/12/2070",
            autoclose: true
        });
        $('.endDataPicker').datepicker({
            format: 'dd/mm/yyyy',
            weekStart: 1,
            startDate: "01" + output.substring(2,10),
            endDate: "01/12/2070",
            autoclose: true
        });
    }

    var getLocation = function (){
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(initializeWithCurrentLocation);
        } else {
            initializeWithoutCurrentLocation();
        }
    };

    function addAllMarkers() {
        $.each(markers, function( index, value ) {
            new google.maps.Marker({
                position: new google.maps.LatLng(value.latitude,value.longitude),
                map: map,
                title: value.title
            }).addListener('click', function(evt) {
                var lat = evt.latLng.lat();
                var lng = evt.latLng.lng();
                var viewTitle = $(this)[0].title;
                var startDate;
                var finishDate;

                $.get( "user/getMarker", {title: viewTitle, latitude: lat, longitude: lng} ).then(function( data ) {
                    $( "#placeDates" ).empty();
                    $( "#placeTitle" ).empty();
                    $( "#placeNote" ).empty();
                    startDate = new Date(data.startDate).toLocaleString();
                    finishDate = new Date(data.finishDate).toLocaleString();

                    if(startDate.substring(0,startDate.indexOf(',')) === finishDate.substring(0,finishDate.indexOf(','))){
                        $("#placeDates").append(startDate.substring(0,startDate.indexOf(',')));
                    } else {
                        $("#placeDates").append(startDate.substring(0,startDate.indexOf(',')) + " - " + (finishDate.substring(0,finishDate.indexOf(','))));
                    }

                    $("#placeTitle").append(data.title);
                    $("#placeNote").append(data.note);
                });

                $('#viePlaceModal').modal('show');
            });
        });
    }

    function initializeWithCurrentLocation(position) {
        var mapProp = {
            center:new google.maps.LatLng(position.coords.latitude,position.coords.longitude),
            zoom:5,
            mapTypeId:google.maps.MapTypeId.ROADMAP
        };

        map=new google.maps.Map(document.getElementById("myPlacesMap"), mapProp);
        addAllMarkers();

        new google.maps.Marker({
            position: new google.maps.LatLng(position.coords.latitude,position.coords.longitude),
            map: map,
            icon: 'https://maps.google.com/mapfiles/kml/shapes/arrow.png',
            title: 'Hello World!'
        }).addListener('click', function() {
                     alert($(this)[0].title);
                    });

        google.maps.event.addListener(map, 'click', function( event ){
            latitude = event.latLng.lat();
            longitude = event.latLng.lng();
            $("#title").css("border-color","#ccc");
            $( "#titleAlert" ).remove();
            $('#addNewPlaceModal').modal('show');
        });
    }

    function initializeWithoutCurrentLocation() {
        var mapProp = {
            center:new google.maps.LatLng(51.508742,-0.120850),
            zoom:5,
            mapTypeId:google.maps.MapTypeId.ROADMAP
          };
        map=new google.maps.Map(document.getElementById("myPlacesMap"), mapProp);
        new google.maps.Marker({
            position: new google.maps.LatLng(51.508742,-0.120850),
            map: map,
            icon: 'https://maps.google.com/mapfiles/kml/shapes/schools_maps.png',
            title: 'Hello World!'
        });
        addAllMarkers();
        google.maps.event.addListener(map, 'click', function( event ){
            latitude = event.latLng.lat();
            longitude = event.latLng.lng();
            console.log( "Latitude: "+event.latLng.lat()+" "+", longitude: "+event.latLng.lng() );
            $("#title").css("border-color","#ccc");
            $( "#titleAlert" ).remove();
            $('#addNewPlaceModal').modal('show');
        });
    }

    $(function () {
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        $(document).ajaxSend(function(e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    });

    $( "#saveNewPlace" ).click(function() {

        if ($("#title").val().length < 1){
            $("#title").css("border-color","red");
            $( ".modal-body" ).prepend( "<div id='titleAlert' class='alert alert-danger'>Provide title</div>" );
        } else {
            $.post( "user/addMarker", { title: $("#title").val(), note: $("#note").val(), latitude: latitude,
                                        longitude: longitude, startDate: $("#startDate").val(), finishDate: $("#endDate").val()} );
            $("#title").css("border-color","#ccc");
            $( "#titleAlert" ).remove();
            new google.maps.Marker({
                position: new google.maps.LatLng(latitude,longitude),
                map: map,
                title: $("#title").val()
            }).addListener('click', function() {
                console.log($(this)[0].title);
            });
            $("#title").val("");
            prepareDatapicker();
            $('#addNewPlaceModal').modal('hide');
        }

    });
});
