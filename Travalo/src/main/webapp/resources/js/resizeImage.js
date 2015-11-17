function centerModal() {
    $(this).css('display', 'block');
    var $dialog = $(this).find(".modal-dialog");
    var offset = ($(window).height() - $dialog.height()) / 2;
    $dialog.css("margin-top", offset);
}
$( document ).ready(function() {
    $('#pictures img').on('click',function() {
        var sr=$(this).attr('src');
        var image = new Image();
        image.src = $(this).attr("src");
        var naturalWidth = image.naturalWidth;

        if(naturalWidth < 1280){
            $('#myModal .modal-dialog').css("width",naturalWidth);
        } else {
            $('#myModal .modal-dialog').css("width",1280);
        }

        $('#mimg').attr('src',sr);
        $('#myModal').modal('show');
    });
    $('.modal').on('show.bs.modal', centerModal);
    $(window).on("resize", function () {
        $('.modal:visible').each(centerModal);
    });
});
