$( document ).ready(function() {
    $("#input-dim-1").fileinput({
        uploadUrl: "/Travalo/images/add",
        allowedFileExtensions: ["jpg", "png", "gif"],
        minImageWidth: 50,
        minImageHeight: 50
    });
    $('.fileinput-remove').attr('hidden', true);
});
