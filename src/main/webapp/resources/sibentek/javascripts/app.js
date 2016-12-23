$(function () {
    var linkToHome = '.aw-topbar img';
    $('.js-toggle').bind('click', function (event) {
        $('.js-sidebar, .js-content').toggleClass('is-toggled');
        event.preventDefault();
    });
    $(linkToHome).bind('click', function (){
        location.href = 'index.xhtml';
    });
    $(linkToHome).css('cursor', 'pointer');
});

$(document).ready(function () {
    var url = window.location.href;
//    $('.aw-ul li a').click(function () {
//        $(this).addClass('is-selected');
//        $('.aw-ul li').parent().removeClass('is-selected');
//    });
    var menuItem = $('.aw-ul li a').filter(function () {
        return this.href === url;
    });

    menuItem.addClass('is-selected');
});