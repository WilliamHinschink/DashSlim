$(function () {
    var linkToHome = '.aw-topbar img';
    $('.js-toggle').bind('click', function (event) {
        $('.js-sidebar, .js-content').toggleClass('is-toggled');
        event.preventDefault();
    });
    $(linkToHome).bind('click', function () {
        location.href = 'index.xhtml';
    });
    $(linkToHome).css('cursor', 'pointer');
});

$(document).ready(function () {
    var url = window.location.href;
    var menuItem = $('.aw-ul li a').filter(function () {
        return this.href === url;
    });

    menuItem.addClass('is-selected');
});
//$(document).ready(function () {
//    $('.aw-ul > li > a').click(function () {
//        if ($(this).attr('class') != 'is-selected') {
//            $('.aw-ul li ul').slideUp();
//            $(this).next().slideToggle();
//            $('.aw-ul li a').removeClass('is-selected');
//            $(this).addClass('is-selected');
//        }
//    });
//});
$(document).ready(function() {
    $('#aw-accordion').dcAccordion();
});