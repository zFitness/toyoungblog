$(document).ready(function () {
  // var converter = new showdown.Converter()
  // var html = converter.makeHtml(
  //   '# Marked in the browser\n\nRendered by **marked**.'
  // )
  // document.getElementById('article-content').innerHTML = html

  $('#donate-btn').click(function () {
    if ($('.donate_inner').css('display') == 'none') {
      $('.donate_inner').attr('style', 'display:block;')
    } else {
      $('.donate_inner').attr('style', 'display:none;')
    }
  })
})
