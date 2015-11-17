$( document ).ready(function() {
    $( "#registerForm" ).submit(function( event ) {
            if ($("#login").val().length < 4 || $("#login").val().length > 25){
                $( "#registerAlert" ).remove();
                $( "#registerForm" ).prepend( "<div id='registerAlert' class='alert alert-danger'>Provide login between 4-25 characters</div>" );
                event.preventDefault();
            } else if (!new RegExp('^[a-zA-Z0-9_]*$').test($("#login").val())){
                $( "#registerAlert" ).remove();
                $( "#registerForm" ).prepend( "<div id='registerAlert' class='alert alert-danger'>Use alphanumeric characters in login</div>" );
                event.preventDefault();
            } else if ($("#password").val().length < 8 || $("#password").val().length > 25){
                $( "#registerAlert" ).remove();
                $( "#registerForm" ).prepend( "<div id='registerAlert' class='alert alert-danger'>Provide password between 8-25 characters</div>" );
                event.preventDefault();
            } else if ($("#password").val().length === 0 || $("#password").val() !== $("#repeatPassword").val()){
                $( "#registerAlert" ).remove();
                $( "#registerForm" ).prepend( "<div id='registerAlert' class='alert alert-danger'>Password and Repeat password are not same</div>" );
                event.preventDefault();
            } else if ($("#firstname").val().length === 0 || $("#firstname").val().length > 40){
                $( "#registerAlert" ).remove();
                $( "#registerForm" ).prepend( "<div id='registerAlert' class='alert alert-danger'>Provide your first name (not longer than 40 signs)</div>" );
                event.preventDefault();
            } else if ($("#lastname").val().length === 0 || $("#lastname").val().length > 40){
                $( "#registerAlert" ).remove();
                $( "#registerForm" ).prepend( "<div id='registerAlert' class='alert alert-danger'>Provide your last name (not longer than 40 signs)</div>" );
                event.preventDefault();
            } else if ($("#email").val().length > 40 || $("#email").val().length === 0 || !new RegExp(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{1,4}$/i).test($("#email").val())){
                $( "#registerAlert" ).remove();
                $( "#registerForm" ).prepend( "<div id='registerAlert' class='alert alert-danger'>Provide proper email address (not longer than 40 signs)</div>" );
                event.preventDefault();
            } else if ($("#email").val().length === 0 || $("#email").val() !== $("#repeatEmail").val()){
                $( "#registerAlert" ).remove();
                $( "#registerForm" ).prepend( "<div id='registerAlert' class='alert alert-danger'>Email and Repeat email are not same</div>" );
                event.preventDefault();
            }else if ($("#phone").val().length !== 0 && !new RegExp(/^\+?[ 0-9]{8,25}$/i).test($("#phone").val())){
                alert(!new RegExp(/^\+?[ 0-9]{8,25}$/i).test($("#phone").val()));
                alert($("#phone").val().length != 0);
                alert($("#phone").val().length);
                $( "#registerAlert" ).remove();
                $( "#registerForm" ).prepend( "<div id='registerAlert' class='alert alert-danger'>Provide phone number between 8-25 numbers or none</div>" );
                event.preventDefault();
            }else if ($("#city").val().length > 40){
                $( "#registerAlert" ).remove();
                $( "#registerForm" ).prepend( "<div id='registerAlert' class='alert alert-danger'>Provide city name to 40 signs or none</div>" );
                event.preventDefault();
            }else if ($("#country").val().length > 40){
                $( "#registerAlert" ).remove();
                $( "#registerForm" ).prepend( "<div id='registerAlert' class='alert alert-danger'>Provide country name to 40 signs or none</div>" );
                event.preventDefault();
            }
    });
    $( "#email" ).keyup(function() {
        $("#loadingEmail").attr("hidden", false);
            $.get( "register/checkEmail", { email: $( "#email" ).val() } )
                .done(function( data ) {
                    if(data === true){
                        $("#loadingEmail").attr("hidden", true);
                        $("#failureEmail").attr("hidden", true);
                        $("#successEmail").attr("hidden", false);
                    } else {
                        $("#loadingEmail").attr("hidden", true);
                        $("#successEmail").attr("hidden", true);
                        $("#failureEmail").attr("hidden", false);
                    }

                    alert( "Data Loaded: " + data );
                });

        if (!new RegExp(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{1,4}$/i).test($("#email").val())){
            $(this).css('color', 'red');
        } else {
            $(this).css('color', '#555');
        }
    });

    $( "#email" ).keydown(function() {
        $("#loadingEmail").attr("hidden", false);
    });

    $( "#repeatEmail" ).keyup(function() {
        if ($("#email").val() !== $("#repeatEmail").val()){
            $(this).css('color', 'red');
            $( "#email" ).css('color', 'red');
        } else {
            $(this).css('color', '#555');
            $( "#email" ).css('color', '#555');
        }
    });
    $( "#login" ).keyup(function() {
        $("#loadingLogin").attr("hidden", false);
        $.get( "register/checkLogin", { login: $( "#login" ).val() } )
            .done(function( data ) {
            if(data === true){
                $("#loadingLogin").attr("hidden", true);
                $("#failureLogin").attr("hidden", true);
                $("#successLogin").attr("hidden", false);
            } else {
                $("#loadingLogin").attr("hidden", true);
                $("#successLogin").attr("hidden", true);
                $("#failureLogin").attr("hidden", false);
            }

            alert( "Data Loaded: " + data );
          });
    });

    $( "#login" ).keydown(function() {
        $("#loadingLogin").attr("hidden", false);
    });


/*    $( "#phone" ).keyup(function() {
        if (!new RegExp(/^\+?[ 0-9]{8,25}$/i).test($("#phone").val())){
            $(this).css('color', 'red');
        } else {
            $(this).css('color', '#555');
        }
    });*/
});