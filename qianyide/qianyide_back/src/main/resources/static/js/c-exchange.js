// JavaScript Document

$(function () {

    ~function () {
        if ($('#J_ClassifyTabs').length) {
            new SAL.Slides({
                $slider: $('#J_ClassifyTabs').find('.tab-cont .cont'),
                $pager: $('#J_ClassifyTabs').find('.tab-item li'),
                $prev: $('#J_ClassifyTabs').find('.prev'),
                $next: $('#J_ClassifyTabs').find('.next'),
                pagerEvent: 'click',
                speed: 800,
                cycleSlide: false,
                fx: 'horizontal' //不需要动画则为none
            });
        }
    }();


});