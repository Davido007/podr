$( document ).ready(function() {
        $( "#saveChangedPassword" ).click(function() {
            $.get( "user/changePassword", {oldPassword: $("#oldPassword").val(), newPassword: $("#newPassword").val()} )
                .done(function( data ) {
                    alert(data);
              });
        });
});
