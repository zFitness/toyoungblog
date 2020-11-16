$(document).ready(function () {
    $('.main-wrapper').scroll(function () {
        if ($('.main-wrapper').scrollTop() > 64) {
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
    yyui_menu('.menu');
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

    function yyui_menu(ulclass) {
        $(document).ready(function () {
            $(ulclass + ' li').hover(function () {
                $(this).children("ul").show(); //mouseover
            }, function () {
                $(this).children("ul").hide(); //mouseout
            });
        });
    }

})