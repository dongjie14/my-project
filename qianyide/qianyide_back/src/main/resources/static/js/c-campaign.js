// JavaScript Document

$(function () {

    ~function () {
        if ($('#J_ClassifyTabs').length) {
            var $s = $('#J_ClassifyTabs').find('.tab-cont .cont'), $p = '';
            if ($s.length > 1) {
                $s.each(function (i) {
                    $p += i ? '<li></li>' : '<li class="active"></li>';
                });
                $p = $($p).appendTo($('#J_ClassifyTabs').find('.rec-pager'))
                new SAL.Slides({
                    $slider: $s,
                    $pager: $p,
                    $prev: $('#J_ClassifyTabs').find('.prev'),
                    $next: $('#J_ClassifyTabs').find('.next'),
                    pagerEvent: 'click',
                    speed: 800,
                    cycleSlide: false,
                    fx: 'horizontal'
                });
            }
        }
    }();

});