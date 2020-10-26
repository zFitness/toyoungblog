$(document).ready(function () {
    $('.main-wrapper').scroll(function () {
        if ($('.main-wrapper').scrollTop() > 100) {
            $('.m-cd-top').fadeIn();
        } else {
            $('.m-cd-top').fadeOut();
        }
    })

    $('.m-cd-top').click(function () {
        $('.main-wrapper').scrollTop(0)
    })

    $('.m-menu').click(function () {
        if ($('.toc-container-mob').css('display') == 'none') {
            $('.toc-container-mob').css('display', 'block');
        } else {
            $('.toc-container-mob').css('display', 'none');
        }
    })
})