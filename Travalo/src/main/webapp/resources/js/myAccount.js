$( document ).ready(function() {
    $( "#myTravalo" ).click(function() {
        $.get( "user/myTravalo", {} )
            .done(function( data ) {
           $( "#userMenu a" ).removeClass("focused-button");
           $( "#myTravalo" ).addClass("focused-button");
           $( "#userData" ).empty();
           $( "#userData" ).append(data);
          });
    });
    $( "#myProfile" ).click(function() {
        $.get( "user/myProfile", {} )
            .done(function( data ) {
           $( "#userMenu a" ).removeClass("focused-button");
           $( "#myProfile" ).addClass("focused-button");
           $( "#userData" ).empty();
           $( "#userData" ).append(data);
          });
    });
    $( "#myPlaces" ).click(function() {
        $.get( "user/myPlaces", {} )
            .done(function( data ) {
           $( "#userMenu a" ).removeClass("focused-button");
           $( "#myPlaces" ).addClass("focused-button");
           $( "#userData" ).empty();
           $( "#userData" ).append(data);
          });
    });
    $( "#myMessages" ).click(function() {
        $.get( "user/myMessages", {} )
            .done(function( data ) {
           $( "#userMenu a" ).removeClass("focused-button");
           $( "#myMessages" ).addClass("focused-button");
           $( "#userData" ).empty();
           $( "#userData" ).append(data);
          });
    });
    $( "#myFriends" ).click(function() {
        $.get( "user/myFriends", {} )
            .done(function( data ) {
           $( "#userMenu a" ).removeClass("focused-button");
           $( "#myFriends" ).addClass("focused-button");
           $( "#userData" ).empty();
           $( "#userData" ).append(data);
          });
    });
    $( "#myHotels" ).click(function() {
        $.get( "user/myHotels", {} )
            .done(function( data ) {
           $( "#userMenu a" ).removeClass("focused-button");
           $( "#myHotels" ).addClass("focused-button");
           $( "#userData" ).empty();
           $( "#userData" ).append(data);
          });
    });
    $( "#myFlights" ).click(function() {
        $.get( "user/myFlights", {} )
            .done(function( data ) {
           $( "#userMenu a" ).removeClass("focused-button");
           $( "#myFlights" ).addClass("focused-button");
           $( "#userData" ).empty();
           $( "#userData" ).append(data);
          });
    });
    $( "#myRent" ).click(function() {
        $.get( "user/myRent", {} )
            .done(function( data ) {
           $( "#userMenu a" ).removeClass("focused-button");
           $( "#myRent" ).addClass("focused-button");
           $( "#userData" ).empty();
           $( "#userData" ).append(data);
          });
    });
    $( "#myToDO" ).click(function() {
        $.get( "user/myToDO", {} )
            .done(function( data ) {
           $( "#userMenu a" ).removeClass("focused-button");
           $( "#myToDO" ).addClass("focused-button");
           $( "#userData" ).empty();
           $( "#userData" ).append(data);
          });
    });
    $( "#myMaps" ).click(function() {
        $.get( "user/myMaps", {} )
            .done(function( data ) {
           $( "#userMenu a" ).removeClass("focused-button");
           $( "#myMaps" ).addClass("focused-button");
           $( "#userData" ).empty();
           $( "#userData" ).append(data);
          });
    });
    $( "#myTrips" ).click(function() {
        $.get( "user/myTrips", {} )
            .done(function( data ) {
           $( "#userMenu a" ).removeClass("focused-button");
           $( "#myTrips" ).addClass("focused-button");
           $( "#userData" ).empty();
           $( "#userData" ).append(data);
          });
    });
});