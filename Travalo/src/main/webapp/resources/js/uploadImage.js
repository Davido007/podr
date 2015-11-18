$( document ).ready(function() {
    $("#input-dim-1").fileinput({
        uploadUrl: "/Travalo/images/add",
        allowedFileExtensions: ["jpg", "png", "gif"],
        minImageWidth: 50,
        minImageHeight: 50
    });
    $('.fileinput-remove').attr('hidden', true);
    $(function () {
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        $(document).ajaxSend(function(e, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    });
});
