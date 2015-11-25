$( document ).ready(function() {
    getLocation();
    var centerPosition = new google.maps.LatLng(51.508742,-0.120850);
    var latitude;
    var longitude;
    var map;
    var output;
getCurrentDate();
prepareDatapicker();
    function getCurrentDate() {
        var d = new Date();
        var month = d.getMonth()+1;
        var day = d.getDate();

        output = (day<10 ? '0' : '') + day + '/' + (month<10 ? '0' : '') + month + '/' + d.getFullYear();
        $("#startDate").val(output);
        $("#endDate").val(output);
    }
    function prepareDatapicker() {
            $('.date').datepicker({
            format: 'dd/mm/yyyy',
            weekStart: 2,
            startDate: output,
            endDate: "01/12/2070"
        });
    }

    function getLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(initializeWithCurrentLocation);
        } else {
            initializeWithoutCurrentLocation();
        }
    }

    function initializeWithCurrentLocation(position) {
        var mapProp = {
            center:new google.maps.LatLng(position.coords.latitude,position.coords.longitude),
            zoom:5,
            mapTypeId:google.maps.MapTypeId.ROADMAP
        };
        map=new google.maps.Map(document.getElementById("myPlacesMap"), mapProp);
        new google.maps.Marker({
            position: new google.maps.LatLng(position.coords.latitude,position.coords.longitude),
            map: map,
            icon: 'https://maps.google.com/mapfiles/kml/shapes/arrow.png',
            title: 'Hello World!'
        });
        google.maps.event.addListener(map, 'click', function( event ){
            latitude = event.latLng.lat();
            longitude = event.latLng.lng();
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
        google.maps.event.addListener(map, 'click', function( event ){
            latitude = event.latLng.lat();
            longitude = event.latLng.lng();
            console.log( "Latitude: "+event.latLng.lat()+" "+", longitude: "+event.latLng.lng() );
            $('#addNewPlaceModal').modal('show');
        });
    }
    $( "#saveNewPlace" ).click(function() {
        if ($("#title").val().length < 1){
            $("#title").css("border-color","red");
            $( ".modal-body" ).prepend( "<div id='titleAlert' class='alert alert-danger'>Provide title</div>" );
        } else {
            new google.maps.Marker({
                position: new google.maps.LatLng(latitude,longitude),
                map: map,
                title: $("#title").val()
            }).addListener('click', function() {
                console.log($(this)[0].title);
            });
/*            marker.addListener('click', function() {
                map.setZoom(8);
                map.setCenter(marker.getPosition());
              });*/
            $("#title").val("");
            prepareDatapicker();
            $('#addNewPlaceModal').modal('hide');
        }

    });
    /*google.maps.event.addDomListener(window, 'load', initialize);*/
});
