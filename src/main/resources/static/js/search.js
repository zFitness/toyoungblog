$(document).ready(function () {
    $('.searchbox').click(function () {
        $('.js-search').addClass('is-visible')
    })

    $('.search_close').click(function () {
        $('.js-search').removeClass('is-visible')
    })
})
