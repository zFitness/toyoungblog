$(document).ready(function () {
    $('.main-wrapper').scroll(function () {
        if ($('.main-wrapper').scrollTop() > 100) {
            //回到顶部按钮
            $('.m-cd-top').fadeIn();
            if ($(document).width() >= 768) {
                $('.site-header').addClass('site-header-hover')
            }
        } else {
            $('.m-cd-top').fadeOut();
            if ($(document).width() >= 768) {
                $('.site-header').removeClass('site-header-hover')
            }
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

    $('.close-button .iconclose').click(function () {
        $('.toc-container-mob').css('display', 'none');
    })

})