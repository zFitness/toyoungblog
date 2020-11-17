$(document).ready(function () {
    //滚动
    $(document).scroll(function () {
        if ($(document).scrollTop() > 32) {
            //回到顶部按钮
            $('.m-cd-top').fadeIn();
            $('.site-header').addClass('site-header-hover')
        } else {
            $('.m-cd-top').fadeOut();
            $('.site-header').removeClass('site-header-hover')
        }
    })

    $('.m-cd-top').click(function () {
        $(document).scrollTop(0)
    })

    //目录
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


    //
    yyui_menu('.menu');

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