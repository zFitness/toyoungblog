$(function () {
    //判断屏幕宽度

    // 侧边栏弹出
    $('.openNav').click(function () {
        var left = $('#wrapper')[0].offsetLeft
        if (left == 0) {
            $('#wrapper').offset({
                left: 220,
            })
            $(this).css('transform', 'rotate(450deg)')
            $('.headSculpture img').addClass('img')
            $('.headSculpture p').addClass('opacity')
            $('#dark-wrapper').addClass('dark')
            $('.main-wrapper').css('overflow-y', 'hidden')
            setTimeout(function () {
                $('.option ul>li').addClass('li')
            }, 600)
        } else {
            $('#wrapper').offset({
                left: 0,
            })
            $(this).css('transform', 'rotate(0deg)')
            setTimeout(function () {
                $('.headSculpture img').removeClass('img')
                $('.headSculpture p').removeClass('opacity')
                $('.option ul>li').removeClass('li')
                $('#dark-wrapper').removeClass('dark')
                $('.main-wrapper').css('overflow-y', 'scroll')
            }, 300)
        }
    })
})
