$( document ).ready(function() {
    var isCorrect = false;
    $( "#registerForm" ).submit(function( event ) {
        if ( $( "input:first" ).val() === "correct" ) {
            alert($( "input:first" ).val().length);
            alert( "Validated" );
        } else {
          //  alert( "invalid" );
        }

//      $( "span" ).text( "Not valid!" ).show().fadeOut( 1000 );
//      event.preventDefault();
//      alert( "Handler for .submit() called." );
        event.preventDefault();
    });
    $( "#registerForm" ).keyup(function() {
        if ($("#login").val().length < 4 || $("#login").val().length > 25){} else {
            if ($("#password").val().length < 8){} else {
                if ($("#firstname").val().length === 0){} else {
                    if ($("#lastname").val().length === 0){} else {
                    $("#submitRegistration").prop('disabled', false);
                    }
                }
            }
        }

    });
});